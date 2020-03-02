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
		Style bouldering = new Style("Bouldering", "Ropeless climbing on boulders, protected by crash pads.");
		bouldering = styleRepo.save(bouldering);
		
		Grade five12a = new Grade("5.12a");
		Grade five12d = new Grade("5.12d");
		Grade five9 = new Grade("5.9");
		Grade five6 = new Grade("5.6");
		Grade v6 = new Grade("V6");
		Grade five14 = new Grade("5.14c");
		
		Route twinky = new Route("Twinky", "The steepest route in the Red River Gorge.", sport, five12a);
		twinky = routeRepo.save(twinky);
		Route phantasia = new Route("Phantasia", "The harder route next to Twinky.", sport, five12d);
		phantasia = routeRepo.save(phantasia);
		Route happyHands = new Route("Happy Hands", "The New River Gorge's classic hand crack.", trad, five9);
		happyHands = routeRepo.save(happyHands);
		Route durrance = new Route("Durrance(approach)", "The \"easiest\" way up Devil's Tower.", trad, five6);
		durrance = routeRepo.save(durrance);
		Route monkeySwing = new Route("Monkey Swing", "The Chippewa Creek classic boulder.", bouldering, v6);
		monkeySwing = routeRepo.save(monkeySwing);
		Route dawnWallFree = new Route("Dawn Wall Free", "2500 foot route up Yosemite's El Capitan.", trad, five14);
		dawnWallFree = routeRepo.save(dawnWallFree);
	
	}
	
}
