package org.wecancodeit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Route {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	private String description;
	
	/* because one style may have many routes, we have a @OneToMany relationship
	 * owned by the style class. Here we use annotation to build the route side
	 * of the relationship making sure to create a single object because a route
	 * can have only one style.
	 */
	@ManyToOne
	private Style style;
	
	@ManyToOne
	private Grade grade;

	//when using JPA make sure to create a default constructor
	public Route() {
		
	}
	
	public Route(String name, String description, Style style, Grade grade) {
		this.name = name;
		this.description = description;
		this.style = style;
		this.grade = grade;
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
	
	public Style getStyle() {
		return style;
	}
	
	public Grade getGrade() {
		return grade;
	}

	/* bringing in the hashCode() can be done by on the drop-down menu
	 * Source/Generate hashCode() and clicking the necessary boxes, and
	 * is needed for correcting iterable over assertion issues.
	 */	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
