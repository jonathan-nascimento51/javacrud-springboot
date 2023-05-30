package br.edu.javacrud.domain.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String>{
	
	List<Product> findAllByActiveTrue();
	
}
