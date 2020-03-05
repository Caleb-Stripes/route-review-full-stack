package org.wecancodeit;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoutePopulator implements CommandLineRunner{

	@Resource
	private RouteRepository routeRepo;
	
	@Resource
	private StyleRepository styleRepo;
	
	@Resource
	private GradeRepository gradeRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Style sport = new Style("Sport", "Lead climbing using fixed eqipment to protect the climber.");
		sport = styleRepo.save(sport);
		Style trad = new Style("Trad", "Lead climbing using non-fixed gear to protect the climber.");
		trad = styleRepo.save(trad);
		Style boulder = new Style("Boulder", "Ropeless climbing on boulders, protected by crash pads.");
		boulder = styleRepo.save(boulder);
		
		Grade five12a = new Grade("5.12a");
		five12a = gradeRepo.save(five12a);
		Grade five12d = new Grade("5.12d");
		five12d = gradeRepo.save(five12d);
		Grade five9 = new Grade("5.9");
		five9 = gradeRepo.save(five9);
		Grade five6 = new Grade("5.6");
		five6 = gradeRepo.save(five6);
		Grade v6 = new Grade("V6");
		v6 = gradeRepo.save(v6);
		Grade five14 = new Grade("5.14c");
		five14 = gradeRepo.save(five14);
		
		Route twinky = new Route("Twinky", "The steepest route in the Red River Gorge.", sport, five12a, "images/twinky.JPG");
		twinky = routeRepo.save(twinky);
		Route phantasia = new Route("Phantasia", "The harder route next to Twinky.", sport, five12d, "images/phantasia.JPG");
		phantasia = routeRepo.save(phantasia);
		Route happyHands = new Route("Happy Hands", "The New River Gorge's classic hand crack.", trad, five9, "images/happy-hands.jpg");
		happyHands = routeRepo.save(happyHands);
		Route durrance = new Route("Durrance(approach)", "The \"easiest\" way up Devil's Tower.", trad, five6, "images/durrance.jpeg");
		durrance = routeRepo.save(durrance);
		Route monkeySwing = new Route("Monkey Swing", "The Chippewa Creek classic boulder.", boulder, v6, "images/monkey-swing.jpg");
		monkeySwing = routeRepo.save(monkeySwing);
		Route dawnWallFree = new Route("Dawn Wall Free", "2500 foot route up Yosemite's El Capitan.", trad, five14, "images/dawn-wall-free.jpeg");
		dawnWallFree = routeRepo.save(dawnWallFree);
		Route narcissus = new Route("Narcissus", "A steep classic climb in a cave on the shores of Summersville Lake", sport, five12a, "images/narcissus.jpg");
		narcissus = routeRepo.save(narcissus);
	
	}
	
}
