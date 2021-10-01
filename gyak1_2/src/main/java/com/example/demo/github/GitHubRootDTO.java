package com.example.demo.github;

import java.util.List;

public class GitHubRootDTO {
	private int total_count;
	private boolean incomplete_result;
	private List<GitHubItemDTO> items;
	
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public boolean isIncomplete_result() {
		return incomplete_result;
	}
	public void setIncomplete_result(boolean incomplete_result) {
		this.incomplete_result = incomplete_result;
	}
	public List<GitHubItemDTO> getItems() {
		return items;
	}
	public void setItems(List<GitHubItemDTO> items) {
		this.items = items;
	}
}
