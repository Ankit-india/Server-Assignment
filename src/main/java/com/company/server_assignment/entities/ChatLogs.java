package com.company.server_assignment.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "chat_logs")
public class ChatLogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int messageId;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "time_stamp")
	private Date timeStamp;
	
	@Column(name = "is_sent")
	private boolean isSent;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
