package org.wecancodeit;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grade {

	@Id
	@GeneratedValue
	private Long id;

	private String yds;

	@OneToMany(mappedBy = "grade")
	private Collection<Route> routes;
	
	public Grade() {
		
	}

	public Grade(String yds, Route...routes) {
		this.yds = yds;
		this.routes = new HashSet<>(Arrays.asList(routes));
		
	}
	

	public String getYds() {
		return yds;
	}

	public Long getId() {
		return id;
	}

	public Collection<Route> getRoutes() {
		return routes;
	}

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
		Grade other = (Grade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
