package com.example.demo.github;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
		
		return response.getBody().items.stream().map(item -> item.name).collect(Collectors.toList());
	}

}
