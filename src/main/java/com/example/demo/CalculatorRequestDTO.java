package com.example.demo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CalculatorRequestDTO {
	@NotNull
	private Double operand1;
	@NotNull
	private Double operand2;
	@NotNull
	private String operand;
}
