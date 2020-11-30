package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.config.JwtTokenUtil;
import com.app.entities.MealDTO;
import com.app.models.DAOMeal;
import com.app.service.LinkingService;
import com.app.service.RecipeService;
import com.app.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private LinkingService linkService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/Meal-db-save", method = RequestMethod.POST)
	public ResponseEntity<?> saveTheMealDbRecipe(HttpServletRequest request, @RequestBody MealDTO meal) {

		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
		DAOMeal foundMeal = recipeService.getMealByMealDBID(meal);

		if (foundMeal == null) {
			recipeService.save(meal);
			foundMeal = recipeService.getMealByMealDBID(meal);
		}

		linkService.linkUserToRecipe(foundMeal.getId(), userService.getUserByUsername(username).getId());
		return ResponseEntity.ok("Saved");
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/GetUserRecipes", method = RequestMethod.GET)
	public ResponseEntity<?> GetUserRecipes(HttpServletRequest request) {

		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(jwtToken);

		Long id = userService.getUserByUsername(username).getId();
		
		Iterable<Long> mealIDs = linkService.getUserRecipesFromID(id);

		return ResponseEntity.ok(recipeService.getAllMealsByID(mealIDs));
	}

}
