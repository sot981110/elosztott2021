package com.example.demo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class FindByDTO {
	@NotBlank
	private String query;
}
