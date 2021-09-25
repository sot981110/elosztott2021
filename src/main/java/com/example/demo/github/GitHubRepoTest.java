package com.example.demo.github;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GitHubRepoTest {
	@Test
	void test_searchByText_1() {
		RestTemplate mockRestTemplate = mock(RestTemplate.class);
		GitHubRepo = new GitHubRepo(mockRestTemplate);
		String qs = "valami";
		GitHubItemDTO item = new GitHubItemDTO();
		item.setName("demo");
		List<GitHubItemDTO> items = new ArrayList();
		items.add(item);
		GitHubRootDTO mockRoot = new GitHubRootDTO();
		mockRoot.setItems(items);
		
		when(mockRestTemplate.getForEntity(gitHubRepoLink + "?q=" + qs, GitHubRootDTO.class)).thenReturn(new ResponseEntity(mockRoot, HttpStatus.OK));
		
		List<String> response = repo.searchByText(qs);
		
		assertThat(response, hasSize(1));
		assertThat(response.get(0), is("demo"));
		
		verify(mockRestTemplate).getForEntity(gitHubRepoLink + "?q=" + qs, GitHubRootDTO.class);
	}
	
	@Test
	void test_searchByText_404() {
		RestTemplate mockRestTemplate = mock(RestTemplate.class);
		GitHubRepo = new GitHubRepo(mockRestTemplate);
		String qs = "valami";
		
		when(mockRestTemplate.getForEntity(gitHubRepoLink + "?q=" + qs, GitHubRootDTO.class)).thenReturn(new ResponseEntity(null, HttpStatus.NOT_FOUND));
		
		try {
			List<String> response = repo.searchByText(qs);
			fail("No Exception");
		}
		catch(RestCommunicationException ex) {
			
		}
		
		
		verify(mockRestTemplate).getForEntity(gitHubRepoLink + "?q=" + qs, GitHubRootDTO.class);
	}
}
