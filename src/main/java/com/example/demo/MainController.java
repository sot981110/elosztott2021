package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final CalculatorInterface calculator;
	
	private final Repo repoSearcher;

	@RequestMapping(method=RequestMethod.GET, path="/")
	public String main() {
		return "Hello World";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/calculator", produces=MediaType.APPLICATION_JSON_VALUE)
	public Double calculate(@Valid CalculatorRequestDTO calcObj) {
		return calculator.add(calcObj.getOperand1(), calcObj.getOperand2());
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/repo", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> repoSearch(@Valid RepoSearchDTO repoObj) {
		return repoSearcher.searchByText(repoObj.getQueryString());
	}
}
