package org.wecancodeit;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Style {

	@Id
	@GeneratedValue
	private Long id;

	private String description;
	private String name;

	/* because one style may have many routes, we have a @OneToMany relationship
	 * owned by the style class. Here we use annotation to build the style side
	 * of the relationship making sure to create a collection because it can contain
	 * more than one route. Make sure it is mappedBy the table in which the collection
	 * should appear, in this case the "style" table.
	 */
	@OneToMany(mappedBy = "style")
	private Collection <Route> routes;
	
	public Style() {

	}

	/* this constructor has included the option of having a one to many relationship with routes.
	 * note that a HashSet is declared as the value of this.routes to allow for multiple routes
	 * to populate the constructor. Do not forget to add this part of the this. section in the creator
	 * method, or it may cause issues in testing and program execution.
	 */
	public Style(String name, String description, Route...routes) {
		this.name = name;
		this.description = description;
		this.routes = new HashSet<>(Arrays.asList(routes));
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	/* using the method declaration "Collection" allows us to create a
	 * relationship between two POJOs, making one into a parameter for
	 * the other. Here we want to be able to put multiple routes, into
	 * a style object. Annotation for the type of relationship will be
	 * placed higher in the class using the @ symbol.
	 */
	public Collection<Route> getRoutes() {
		return routes;
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
		Style other = (Style) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
