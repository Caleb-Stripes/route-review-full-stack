package org.wecancodeit;

import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RouteController implements Controller {

	@Resource
	RouteRepository routeRepo;
	
	@RequestMapping("/route")
	public String findOneRoute(@RequestParam(value = "id")long id, Model routeModel) 
			throws RouteNotFoundException {
		Optional<Route> route = routeRepo.findById(id);
		
		if (route.isPresent()) {
			routeModel.addAttribute("routes", route.get());
			return "route";
		} else {
			throw new RouteNotFoundException();
		}
		
	}
	
	
	//this is a default method that came with the implementation of the controller interface in this class
	//it would be really cool to understand exactly what this means so far I can tell:
	/* it is expecting a return value for a public object of class ModelAndView with the parameter inputs of
	 * HttpSerletRequest Class request, and HttpServletResponse class response, 
	 * and returning a null value.
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

}
