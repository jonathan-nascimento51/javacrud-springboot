package br.edu.javacrud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProductDTO(
		
		String id,
		
		@NotBlank
		String name, 
		
		@NotNull
		Integer price_in_cents) {
	
}
