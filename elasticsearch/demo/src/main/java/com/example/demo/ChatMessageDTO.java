package com.example.demo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ChatMessageDTO {
	@NotBlank
	private String id;
	@NotBlank
	private String message;
	@NotBlank
	private String sender;
	@NotBlank
	private String roomId;
	@NotBlank
	private String roomName;
	
	public ChatMessage toDocument() {
		return ChatMessage.builder()
				.id(this.getId())
				.message(this.getMessage())
				.sender(this.getSender())
				.roomId(this.getRoomId())
				.roomName(this.getRoomName())
				.build();
	}
}
