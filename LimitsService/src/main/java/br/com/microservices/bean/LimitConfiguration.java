package br.com.microservices.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LimitConfiguration {

	int maximum;
	int minimum;
	
}
