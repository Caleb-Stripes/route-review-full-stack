package org.wecancodeit;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
//found the following two imports from a google search for "mock mvc spring docs"
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteController.class)
public class RouteControllerMockMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private RouteRepository routeRepo;
	
	@MockBean
	private StyleRepository styleRepo;
	
	@MockBean
	private GradeRepository gradeRepo;

	@Mock
	private Route routeOne;
	
	@Mock
	private Route routeTwo;
	
	@Mock
	private Style styleOne;
	
	@Mock
	private Style styleTwo;
	
	@Mock
	private Grade gradeOne;
	
	@Mock
	private Grade gradeTwo;

	@Test
	public void shouldRouteToSingleRouteView() throws Exception {
		long arbitraryRouteId = 1;
		when(routeRepo.findById(arbitraryRouteId)).thenReturn(Optional.of(routeOne));
		mvc.perform(get("/route?id=1")).andExpect(view().name(is("route")));
	}
	
	@Test 
	public void statusShouldBeOkForSingleRoute() throws Exception {
		long arbitraryRouteId = 1;
		when(routeRepo.findById(arbitraryRouteId)).thenReturn(Optional.of(routeOne));
		mvc.perform(get("/route?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void statusShouldBeNotOkForSingleRoute() throws Exception {
		
		mvc.perform(get("/route?id=1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldPutSingleRouteIntoModel() throws Exception {
		when(routeRepo.findById(1L)).thenReturn(Optional.of(routeOne));
		mvc.perform(get("/route?id=1")).andExpect(model().attribute("routes", is(routeOne)));
	}
	
	@Test
	public void shouldRouteToAllRoutesView() throws Exception {
		mvc.perform(get("/show-routes?")).andExpect(view().name(is("routes")));
	}
	
	@Test
	public void statusShouldBeOkForAllRoutes() throws Exception {
		mvc.perform(get("/show-routes")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldPutAllRoutesIntoModel() throws Exception {
		Collection<Route> allRoutes = Arrays.asList(routeOne, routeTwo);
		when(routeRepo.findAll()).thenReturn(allRoutes);
		mvc.perform(get("/show-routes")).andExpect(model().attribute("routes", is(allRoutes)));
	}

	@Test
	public void shouldRouteToSingleStyleView() throws Exception {
		long arbitraryStyleId = 1;
		when(styleRepo.findById(arbitraryStyleId)).thenReturn(Optional.of(styleOne));
		mvc.perform(get("/style?id=1")).andExpect(view().name(is("style")));
	}
	
	@Test 
	public void statusShouldBeOkForSingleStyle() throws Exception {
		long arbitraryStyleId = 1;
		when(styleRepo.findById(arbitraryStyleId)).thenReturn(Optional.of(styleOne));
		mvc.perform(get("/style?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void statusShouldBeNotOkForSingleStyle() throws Exception {
		
		mvc.perform(get("/style?id=1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldPutSingleStyleIntoModel() throws Exception {
		when(styleRepo.findById(1L)).thenReturn(Optional.of(styleOne));
		mvc.perform(get("/style?id=1")).andExpect(model().attribute("styles", is(styleOne)));
	}
	
	@Test
	public void shouldRouteToAllStylesView() throws Exception {
		mvc.perform(get("/show-styles?")).andExpect(view().name(is("styles")));
	}
	
//	@Test
//	public void statusShouldBeOkForAllRoutes() throws Exception {
//		mvc.perform(get("/show-routes")).andExpect(status().isOk());
//	}
//	
//	@Test
//	public void shouldPutAllRoutesIntoModel() throws Exception {
//		Collection<Route> allRoutes = Arrays.asList(routeOne, routeTwo);
//		when(routeRepo.findAll()).thenReturn(allRoutes);
//		mvc.perform(get("/show-routes")).andExpect(model().attribute("routes", is(allRoutes)));
//	}
}