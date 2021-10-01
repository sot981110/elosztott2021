package com.example.demo.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.github.GitHubRootDTO;
import com.example.demo.github.Repo;
import com.example.demo.github.RestCommunicationException;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GitHubRepo implements Repo {

	private final String gitHubRepoLink = "https://api.github.com/search/repositories";
	
	private final RestTemplate restTemplate;
			
	@Override
	public List<String> searchByText(String queryString) {
		String url = gitHubRepoLink + "?q=" + queryString;
		ResponseEntity<GitHubRootDTO> response = restTemplate.getForEntity(url, GitHubRootDTO.class);
		
		if(response.getStatusCode() == HttpStatus.OK) {
			return response.getBody().getItems().stream().map(item -> item.getName()).collect(Collectors.toList());
		}
		else {
			throw new RestCommunicationException();
		}	
	}

}
