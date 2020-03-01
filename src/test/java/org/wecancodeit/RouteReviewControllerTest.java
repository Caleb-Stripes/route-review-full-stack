package org.wecancodeit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class RouteReviewControllerTest {

	@Resource
	private MockMvc mockMvc;
	
	@MockBean
	RouteRepository routeRepo;
	
	@Mock
	private Route route;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(mockMvc).isNotNull();
	}
	
	@Test
	public void shouldRouteToSingleRouteView() throws Exception {
		long arbitraryRouteId = 1;
		when(routeRepo.findById(arbitraryRouteId)).thenReturn(Optional.of(route));
		mockMvc.perform(get("route?id=1")).andExpect(status().isOk());
		
	}
	
}
