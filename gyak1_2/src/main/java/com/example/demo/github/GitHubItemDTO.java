package com.example.demo.github;

import java.util.List;

public class GitHubItemDTO {
	private String name;
	private String path;
	private String url;
	
	private List<GitHubRepoDTO> githubRepoDTO;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<GitHubRepoDTO> getGithubRepoDTO() {
		return githubRepoDTO;
	}

	public void setGithubRepoDTO(List<GitHubRepoDTO> githubRepoDTO) {
		this.githubRepoDTO = githubRepoDTO;
	}
}
