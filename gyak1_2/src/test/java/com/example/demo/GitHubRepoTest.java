package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.github.GithubItemDTO;
import com.example.demo.github.GithubSearchResponseRoot;
import com.example.demo.impl.GithubRepo;

class RepoTest {
	
	private final String githubSearchRepositoryURL = "https://api.github.com/search/repositories";

	@Test
	void test_searchByText_202() {
		RestTemplate mockRestTemplate = mock(RestTemplate.class);
		GithubRepo repo = new GithubRepo(mockRestTemplate);
		String qs = "asd";
		
		GithubItemDTO item = new GithubItemDTO();
		item.setName("demo");
		
		List<GithubItemDTO> itemList = new ArrayList();
		itemList.add(item);
		
		GithubSearchResponseRoot mockRoot = new GithubSearchResponseRoot();
		mockRoot.setItems(itemList);
		
		when(mockRestTemplate.getForEntity(githubSearchRepositoryURL + "?q=" + qs,
				GithubSearchResponseRoot.class)).thenReturn(
						new ResponseEntity(mockRoot, HttpStatus.OK));
		
		List<String> response = repo.searchByText(qs);
		
		assertThat(response, hasSize(1));
		assertThat(response.get(0), is("demo"));
		
		verify(mockRestTemplate).getForEntity(githubSearchRepositoryURL + "?q=" + qs, GithubSearchResponseRoot.class);
	}
	
	@Test
	void test_searchByText_404() {
		RestTemplate mockRestTemplate = mock(RestTemplate.class);
		GithubRepo repo = new GithubRepo(mockRestTemplate);
		String qs = "asd";
		
		when(mockRestTemplate.getForEntity(githubSearchRepositoryURL + "?q=" + qs,
				GithubSearchResponseRoot.class)).thenReturn(
						new ResponseEntity(null, HttpStatus.NOT_FOUND));
		
		try {
			List<String> response = repo.searchByText(qs);
			fail("Exception not thrown");
		}
		catch(RestCommunicationException ex) {
			
		}
		
		//assertThat(response, hasSize(0));
		
		verify(mockRestTemplate).getForEntity(githubSearchRepositoryURL + "?q=" + qs, GithubSearchResponseRoot.class);
	}

}
© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
Loading complete