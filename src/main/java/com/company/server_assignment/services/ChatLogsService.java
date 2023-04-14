package com.company.server_assignment.services;

import java.util.List;

import com.company.server_assignment.payloads.ChatLogsDto;

public interface ChatLogsService {
	
	ChatLogsDto createChatLogs(ChatLogsDto chatLogsDto, Integer userId);
	
	List<ChatLogsDto> getChatLogsByUser(Integer userId);
	
	void deleteChatByUser(Integer userId);
	
	void deleteChatByUserMsg(Integer userId, Integer messageId);

}
