package com.company.server_assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.server_assignment.payloads.ApiResponse;
import com.company.server_assignment.payloads.ChatLogsDto;
import com.company.server_assignment.services.ChatLogsService;

@RestController
@RequestMapping("/chatlogs/")
public class ChatLogsController {
	
	@Autowired
	private ChatLogsService chatLogsService;
	
	// Create Chat Logs
	@PostMapping("/user/{userId}")
	public ResponseEntity<ChatLogsDto> createChatLogs (@RequestBody ChatLogsDto chatLogsDto, @PathVariable Integer userId){
		ChatLogsDto createChatLogsDto = this.chatLogsService.createChatLogs(chatLogsDto, userId);
		return new ResponseEntity<>(createChatLogsDto, HttpStatus.CREATED);
	}
	
	// Get all message send by user
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ChatLogsDto>> getChatLogsByUser(@PathVariable Integer userId) {
//		System.out.println("above This block of code is executed");
		List<ChatLogsDto> listOfChatLogsByUser = this.chatLogsService.getChatLogsByUser(userId);
//		System.out.println("This block of code is executed");
		return new ResponseEntity<>(listOfChatLogsByUser, HttpStatus.CREATED);
	}
	
	// Deleting a whole chat clog for a particular user
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<ApiResponse> deleteChatByUser(@PathVariable Integer userId) {
		this.chatLogsService.deleteChatByUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("ChatLogs deleted sucessfully", true), HttpStatus.OK);
	}
	
	// deleting a single message for a particular user
	@DeleteMapping("/user/{userId}/message/{messageId}")
	public ResponseEntity<ApiResponse> deleteChatByUserMsg(@PathVariable Integer userId, @PathVariable Integer messageId) {
		this.chatLogsService.deleteChatByUserMsg(userId, messageId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Message deleted sucessfully", true), HttpStatus.OK);
	}
		
}
