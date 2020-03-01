package org.wecancodeit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingTest {

	//TestEntityManager is required for tests involving entities
	//(POJOs to be put into collections)
	@Resource
	private TestEntityManager entityManager;

	@Resource
	private RouteRepository routeRepo;

	@Resource
	private StyleRepository styleRepo;

	@Test
	public void shouldSaveAndLoadRoute() {
		Route route = routeRepo.save(new Route("route", null, null));
		long routeId = route.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Route> result = routeRepo.findById(routeId);
		result.get();
		assertThat(route.getName(), is("route"));
	}

	@Test
	public void shouldSaveAndLoadMoreRoutes() {
		Route routeOne = routeRepo.save(new Route("routeOne", null, null));
		long routeOneId = routeOne.getId();
		Route routeTwo = routeRepo.save(new Route("routeTwo", null, null));
		long routeTwoId = routeTwo.getId();

		Optional<Route> result = routeRepo.findById(routeOneId);
		result.get();
		Optional<Route> result2 = routeRepo.findById(routeTwoId);
		result2.get();
		assertThat(routeOne.getName(), is("routeOne"));
		assertThat(routeTwo.getName(), is("routeTwo"));
	}

	@Test
	public void shouldGenerateRouteId() {
		Route route = routeRepo.save(new Route("route", null, null));
		long routeId = route.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(routeId, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadRouteWithDescripton() {
		Route route = routeRepo.save(new Route("route", "description", null));
		long routeId = route.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Route> result = routeRepo.findById(routeId);
		result.get();
		assertThat(route.getDescription(), is("description"));
	}

	@Test
	public void shouldSaveAndLoadTypeWithDescription() {
		Style style = styleRepo.save(new Style("style", "description"));
		long styleId = style.getId();

		entityManager.flush();
		entityManager.clear();

		Optional<Style> result = styleRepo.findById(styleId);
		result.get();
		assertThat(style.getName(), is("style"));
		assertThat(style.getDescription(), is("description"));
	}
	
	/* one style can have multiple routes, but each route will
	 * have only one style. So, this is a many to one relationship
	 * where style is the owner.
	 */
	@Test
	public void shouldEstablishStyleToRouteRelationship() {
		//route is not the owner of the relationship so we create them first
		Route twinky = routeRepo.save(new Route("twinky", "description", null));
		Route phantasia = routeRepo.save(new Route("phantasia", "description", null));

		Style sport = new Style("sport", "description", twinky, phantasia);
		styleRepo.save(sport);
		long styleId = sport.getId();

		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Style> result = styleRepo.findById(styleId);
		result.get();
		assertThat(sport.getRoutes(), containsInAnyOrder(twinky,phantasia));
	}
	
	@Test
	public void shouldFindRoutesForStyle() {
		
	}
}
