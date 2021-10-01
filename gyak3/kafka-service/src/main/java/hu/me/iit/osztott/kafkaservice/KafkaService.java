package hu.me.iit.osztott.kafkaservice;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaService {
	void sendMessage(MessageDTO messageDTO) throws JsonProcessingException;
}