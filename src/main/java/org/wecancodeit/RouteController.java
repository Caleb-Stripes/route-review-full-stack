package org.wecancodeit;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

	@Resource
	RouteRepository routeRepo;

	@Resource
	StyleRepository styleRepo;

	@RequestMapping("/route")
	public String findOneRoute(@RequestParam(value = "id") long id, Model routeModel) throws RouteNotFoundException {
		Optional<Route> route = routeRepo.findById(id);

		if (route.isPresent()) {
			routeModel.addAttribute("routes", route.get());
			return "route";
		} else {
			throw new RouteNotFoundException();
		}

	}

	// for this note pay attention to the *
	/*
	 * @RequestMappinig("/*end-point-we-are-hitting*") public String
	 * findAllRoutes(Model routeModel) {
	 * routeModel.addAttribute("*name-of-model-referenced-in-thymeleaf*",
	 * routeRepo.findAll()); return("*template-name*");
	 */
	@RequestMapping("/show-routes")
	public String findAllRoutes(Model routeModel) {
		routeModel.addAttribute("routes", routeRepo.findAll());
		return ("routes");
	}

	public String findOneStyle(@RequestParam(value = "id") long id, Model styleModel) throws StyleNotFoundException {
		Optional<Style> style = styleRepo.findById(id);

		if (style.isPresent()) {
			styleModel.addAttribute("styles", style.get());
			return "style";
		} else {
			throw new StyleNotFoundException();
		}

	}

}
// This came when the class was created with controller interface

//	//this is a default method that came with the implementation of the controller interface in this class
//	//it would be really cool to understand exactly what this means so far I can tell:
//	/* it is expecting a return value for a public object of class ModelAndView with the parameter inputs of
//	 * HttpSerletRequest Class request, and HttpServletResponse class response, 
//	 * and returning a null value.
//	 */
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		return null;
//	}
