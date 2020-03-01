package org.wecancodeit;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, Long> {

	Collection<Route> findRouteByStyle(Style sport);

	Collection<Route> findRouteByGrade(Grade grade);



}
