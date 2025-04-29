package com.one.app.websocket;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MessageVO {
	
	private Long chatNum;
	private Long roomNum;
	private String sender;
	private String body;
	private String receiver;
	private String date;
	private String status;
	private boolean readStatus;

}
