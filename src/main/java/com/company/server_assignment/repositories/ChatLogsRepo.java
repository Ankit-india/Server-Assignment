package com.company.server_assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.server_assignment.entities.ChatLogs;
import com.company.server_assignment.entities.User;

public interface ChatLogsRepo extends JpaRepository<ChatLogs, Integer>{
	
	List<ChatLogs> findByUser(User user);
}
