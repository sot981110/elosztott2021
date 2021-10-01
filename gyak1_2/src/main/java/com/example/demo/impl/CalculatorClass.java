package com.example.demo.impl;

import org.springframework.stereotype.Service;

import com.example.demo.CalculatorInterface;

@Service
public class CalculatorClass implements CalculatorInterface {

	@Override
	public Double add(Double operand1, Double operand2) {
		return operand1 + operand2;
	}

}
