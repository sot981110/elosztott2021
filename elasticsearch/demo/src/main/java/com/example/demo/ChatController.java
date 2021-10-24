package com.example.demo;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
@Slf4j
public class ChatController {
	private final ChatMessageRepository chatMessageRepository;
	
	@PostMapping()
	public void newData(@RequestBody @Valid ChatMessageDTO chatMessageDTO) {
		log.info(chatMessageDTO.toString());
		chatMessageRepository.save( chatMessageDTO.toDocument());
	}
	
	@GetMapping(consumes = "application/json")
	public Page<ChatMessage> findBySender(@RequestBody @Valid FindByDTO senderDTO){
		return chatMessageRepository.findBySender(senderDTO.getQuery(), PageRequest.of(0, 10));
	}
	
//	@GetMapping(consumes = "application/json")
//	public Page<ChatMessage> findByMessage(@RequestBody @Valid FindByDTO messageDTO){
//		return chatMessageRepository.findByMessage(messageDTO.getQuery(), PageRequest.of(0, 10));
//	}
}
