package com.example.demo.github;

import java.util.List;

public interface Repo {
	List<String> searchByText(String queryString);
}
