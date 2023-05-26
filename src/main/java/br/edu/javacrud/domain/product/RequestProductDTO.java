package br.edu.javacrud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//forma de criar um dto					 //aqui fica do tipo integer e não number porque ele recebe do body um json e vem do tipo Integer;
public record RequestProductDTO(
		
		String id,
		
		@NotBlank
		String name, 
		
		@NotNull
		Integer price_in_cents) {
	
}
