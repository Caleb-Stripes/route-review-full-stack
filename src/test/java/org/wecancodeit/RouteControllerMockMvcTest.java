package org.wecancodeit;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
//found the following two imports from a google search for "mock mvc spring docs"
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

	@Test
	public void shouldRouteToSingleCourseView() throws Exception {
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

}
