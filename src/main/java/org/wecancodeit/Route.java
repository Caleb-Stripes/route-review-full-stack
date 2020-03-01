package org.wecancodeit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Route {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	private String description;

	//when using JPA make sure to create a default constructor
	public Route() {
		
	}
	
	public Route(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

}
