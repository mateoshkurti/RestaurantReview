package ca.sheridancollege.shkurtim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.shkurtim.beans.Restaurant;
import ca.sheridancollege.shkurtim.beans.RestaurantReviews;
import ca.sheridancollege.shkurtim.database.DatabaseAccess;

@Controller
public class ReviewController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("reviewList", da.getReviews());
		for (RestaurantReviews a: da.getReviews()) {
			System.out.println(a.toString());
		}
		model.addAttribute("restaurant", new Restaurant());
		return "index";
	}

	@PostMapping("/reviewSent")
	public String reviewSent(Model model, @RequestParam String name, @RequestParam String title,
			@RequestParam String reviewer, @RequestParam String description) {

		da.insert(name, title, description, reviewer);
		return "reviewSent";
	}

	@GetMapping("/reviews")
	public String showReviews(Model model) {

		model.addAttribute("reviewList", da.getReviews());
		return "reviews";
	}
	
	@GetMapping("/index")
	public String indexi(Model model) {

		model.addAttribute("restaurant", new Restaurant());
		return "index";
	}
}
