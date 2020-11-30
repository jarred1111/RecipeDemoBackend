package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MealDao;
import com.app.entities.MealDTO;
import com.app.models.DAOMeal;


@Service
public class RecipeService {

	@Autowired
	private MealDao mealDao;

	public DAOMeal save(MealDTO meal) {
		return mealDao.save(MapMealDTO(meal));
	}
	
	public DAOMeal getMealByMealDBID(MealDTO meal) {
		return mealDao.findByMeal_db_Id(meal.getIdMeal());
	}

	private DAOMeal MapMealDTO(MealDTO meal) {
		DAOMeal newMeal = new DAOMeal();
		
		newMeal.setDifficulty(meal.getDifficulty());
		newMeal.setFood_catagory(meal.getStrCategory());
		newMeal.setIngredient(meal.getIngredients());
		newMeal.setIngredient_measurements(meal.getIngredientMeasurements());
		newMeal.setInstructions(meal.getStrInstructions());
		newMeal.setMeal_db_id(meal.getIdMeal());
		newMeal.setMeal_img_url(meal.getStrMealThumb());
		newMeal.setMeal_name(meal.getStrMeal());
		newMeal.setMeal_type(meal.getMealType());
		newMeal.setServing_amount(meal.getServingAmount());

		return newMeal;
	}

	public List<DAOMeal> getAllMealsByID(Iterable<Long> mealIds) {
		System.out.println("\n RecipeService:" + mealIds);
		
		return mealDao.getAllByIds(mealIds);
	}
}
