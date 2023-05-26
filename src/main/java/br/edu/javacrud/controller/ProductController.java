package br.edu.javacrud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.javacrud.domain.product.Product;
import br.edu.javacrud.domain.product.ProductRepository;
import br.edu.javacrud.domain.product.RequestProductDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	
	@GetMapping
	//responseEntity é apenas uma classe padrão para mandar respostas pro meu cliente;
	public ResponseEntity getAllProducts() {		
		var allProducts = repository.findAll();		
		return ResponseEntity.ok(allProducts);
	}
	
	@PostMapping									//uso o valid para fazer a verificação usando a classe RequestProductDTO, anotação a principio vai verificar os parametros passados e se corresponder ao que veio no body da requisição
	public ResponseEntity registerProduct(@RequestBody @Valid RequestProductDTO data) {
		
		//System.out.println(data);				// se vir algum parametro com tipo errado, ou parametros a mais ou a menos, o @Valid vai fazer essa verificação atravez da classe.
		
		Product product = new Product(data);
		
		repository.save(product);
		
		return ResponseEntity.ok().build(); //ao usar ok() que é o status 200, se não colocar um corpo dentro do metodo, preciso usar o build().
	}
	
	@PutMapping
	public ResponseEntity updateProduct(@RequestBody @Valid RequestProductDTO data) {
		
		Optional<Product> optionalProduct = repository.findById(data.id());
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setName(data.name());
			product.setPrice_in_cents(data.price_in_cents());
			repository.save(product);
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}		
		
	}
	
	 
	
	
}
