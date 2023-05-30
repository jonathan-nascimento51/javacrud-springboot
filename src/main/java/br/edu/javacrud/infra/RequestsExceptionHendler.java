package br.edu.javacrud.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice //indica que a classe lida com excessões
public class RequestsExceptionHendler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threat404() {
		return ResponseEntity.badRequest().body("Dado não encontrado");
	}
}
