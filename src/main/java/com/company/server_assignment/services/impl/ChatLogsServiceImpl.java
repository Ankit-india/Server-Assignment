package com.company.server_assignment.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.server_assignment.entities.ChatLogs;
import com.company.server_assignment.entities.User;
import com.company.server_assignment.exceptions.ResourceNotFoundException;
import com.company.server_assignment.payloads.ChatLogsDto;
import com.company.server_assignment.repositories.ChatLogsRepo;
import com.company.server_assignment.repositories.UserRepo;
import com.company.server_assignment.services.ChatLogsService;

@Service
public class ChatLogsServiceImpl implements ChatLogsService{

	@Autowired
	private ChatLogsRepo chatLogsRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public ChatLogsDto createChatLogs(ChatLogsDto chatLogsDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(" User ", "UserId ", userId));
		ChatLogs chatLogs = this.modelMapper.map(chatLogsDto, ChatLogs.class);
		chatLogs.setUser(user);
		chatLogs.setTimeStamp(new Date());
		
		ChatLogs createdChatLogs = this.chatLogsRepo.save(chatLogs);
		return this.modelMapper.map(createdChatLogs, ChatLogsDto.class);
	}

	@Override
	public List<ChatLogsDto> getChatLogsByUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User " , "UserId", userId));
		List<ChatLogs> listOfChatLogs = this.chatLogsRepo.findByUser(user);
		List<ChatLogsDto> listOfChatLogsDto = listOfChatLogs.stream().map((chatLog) -> this.modelMapper.map(chatLog, ChatLogsDto.class)).collect(Collectors.toList());
		return listOfChatLogsDto;
	}

	@Override
	public void deleteChatByUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User " , "UserId", userId));
		List<ChatLogs> listOfChatLogs = this.chatLogsRepo.findByUser(user);
		for(ChatLogs chatLogs : listOfChatLogs) {
			this.chatLogsRepo.delete(chatLogs);
		}
	}

	@Override
	public void deleteChatByUserMsg(Integer userId, Integer messageId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User " , "UserId", userId));
		List<ChatLogs> listOfChatLogs = this.chatLogsRepo.findByUser(user);
		boolean check = true;
		for(ChatLogs chatLogs : listOfChatLogs) {
//			System.out.println(chatLogs.getMessageId() + "    " + messageId);
			if(chatLogs.getMessageId()==messageId) {
//				System.out.println("when cond satisfies");
				this.chatLogsRepo.delete(chatLogs);
				check = false;
			}
		}
		if(check) {
			throw new ResourceNotFoundException("User", "messageId", messageId);
		}
		
	}

}
