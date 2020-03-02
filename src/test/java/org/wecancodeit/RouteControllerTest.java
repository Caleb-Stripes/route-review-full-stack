package org.wecancodeit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@WebMvcTest(RouteController.class)
public class RouteControllerTest {

	@InjectMocks
	private RouteController underTest;
	
	@Resource
	private MockMvc mockMvc;
	
	@MockBean
	RouteRepository routeRepo;
	
	@MockBean
	StyleRepository styleRepo;
	
	@MockBean
	GradeRepository gradeRepo;
	
	@Mock
	private Route route;
	
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
	
	@Mock
	private Model routeModel;
	
	@Mock
	private Model styleModel;
	
	@Mock
	private Model gradeModel;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(mockMvc).isNotNull();
	}
	
	@Test
	public void shouldAddSingleRouteToModel() throws RouteNotFoundException {
		long arbitraryRouteId = 1;
		when(routeRepo.findById(arbitraryRouteId)).thenReturn(Optional.of(route));
		
		underTest.findOneRoute(arbitraryRouteId, routeModel);
		verify(routeModel).addAttribute("routes", route);
	}
	
	@Test
	public void shouldAddAllRoutesToModel() {
		Collection<Route> allRoutes = Arrays.asList(route, routeTwo);
		when(routeRepo.findAll()).thenReturn(allRoutes);
		
		underTest.findAllRoutes(routeModel);
		verify(routeModel).addAttribute("routes", allRoutes);
	}
	
	@Test
	public void shouldAddSingleStyleToModel() throws StyleNotFoundException {
		long arbitraryStyleId = 1;
		when(styleRepo.findById(arbitraryStyleId)).thenReturn(Optional.of(styleOne));
		
		underTest.findOneStyle(arbitraryStyleId, styleModel);
		verify(styleModel).addAttribute("styles", styleOne);
	}
	
	@Test
	public void shouldAddAllStylesToModel() {
		Collection<Style> allStyles = Arrays.asList(styleOne, styleTwo);
		when(styleRepo.findAll()).thenReturn(allStyles);
		
		underTest.findAllStyles(styleModel);
		verify(styleModel).addAttribute("styles", allStyles);
	}
	
	@Test
	public void shouldAddSingleGradeToModel() throws GradeNotFoundException {
		long arbitraryGradeId = 1;
		when(gradeRepo.findById(arbitraryGradeId)).thenReturn(Optional.of(gradeOne));
		
		underTest.findOneGrade(arbitraryGradeId, gradeModel);
	}
	
	@Test
	public void shouldAddAllGradesToModel() {
		Collection<Grade> allGrades = Arrays.asList(gradeOne, gradeTwo);
		when(gradeRepo.findAll()).thenReturn(allGrades);
		
		underTest.findAllGrades(gradeModel);
		verify(gradeModel).addAttribute("grades", allGrades);
	}
	
//	@Test
//	public void shouldRouteToSingleRouteView() throws Exception {
//		long arbitraryRouteId = 1;
//		when(routeRepo.findById(arbitraryRouteId)).thenReturn(Optional.of(route));
//		mockMvc.perform(get("route?id=1")).andExpect(status().isOk());
//		
//	}
	
}
