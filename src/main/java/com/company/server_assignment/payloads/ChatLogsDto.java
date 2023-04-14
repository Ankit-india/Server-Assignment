package com.company.server_assignment.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatLogsDto {
	
	private String message;
	
	private Date timeStamp;
	
	private boolean isSent;
	
	private UserDto user;
}
