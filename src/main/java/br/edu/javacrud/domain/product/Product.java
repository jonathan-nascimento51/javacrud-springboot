package br.edu.javacrud.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor //contrutor com todos os parametros
@NoArgsConstructor //contrutor sem parametros
@EqualsAndHashCode(of="id") //indica que é minha primary key
public class Product {

	@Id //diz que é nosso id da table.
	@GeneratedValue(strategy = GenerationType.UUID) //id não sera passado para o construtor, sera gerado automaticamente pela Anotação.
	private String id;		//definindo a estrategia de geração de id como UUID.
	
	private String name;

	private Integer price_in_cents;
	
	
	public Product(RequestProductDTO requestProductDTO){
		
		this.name = requestProductDTO.name();
		this.price_in_cents = requestProductDTO.price_in_cents();
	}
}
