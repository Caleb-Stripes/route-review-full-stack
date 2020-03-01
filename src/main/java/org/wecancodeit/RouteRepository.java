package org.wecancodeit;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, Long> {

	Collection<Route> findRouteByStyle(Style style);

	Collection<Route> findRouteByGrade(Grade grade);



}
