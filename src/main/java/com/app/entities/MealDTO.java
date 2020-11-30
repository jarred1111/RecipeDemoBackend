package com.app.entities;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealDTO {

	private String strMeal;
	private int idMeal;
	private String strCategory;
	private String MealType;
	private String strMealThumb;
	
	@JsonProperty("Ingredients")
	private String[] Ingredients;
	 
	@JsonProperty("IngredientMeasurements")
	private String[] IngredientMeasurements;
	
	private String strInstructions;
	private int ServingAmount;
	private String Difficulty;
	
	public String getStrMeal() {
		return strMeal;
	}
	public void setStrMeal(String strMeal) {
		this.strMeal = strMeal;
	}
	public int getIdMeal() {
		return idMeal;
	}
	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}
	public String getStrCategory() {
		return strCategory;
	}
	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}
	public String getMealType() {
		return MealType;
	}
	public void setMealType(String mealType) {
		MealType = mealType;
	}
	public String getStrMealThumb() {
		return strMealThumb;
	}
	public void setStrMealThumb(String strMealThumb) {
		this.strMealThumb = strMealThumb;
	}
	public String[] getIngredients() {
		return Ingredients;
	}
	public void setIngredients(String[] ingredients) {
		Ingredients = ingredients;
	}
	public String[] getIngredientMeasurements() {
		return IngredientMeasurements;
	}
	public void setIngredientMeasurements(String[] ingredientMeasurements) {
		IngredientMeasurements = ingredientMeasurements;
	}
	public String getStrInstructions() {
		return strInstructions;
	}
	public void setStrInstructions(String strInstructions) {
		this.strInstructions = strInstructions;
	}
	public int getServingAmount() {
		return ServingAmount;
	}
	public void setServingAmount(int servingAmount) {
		ServingAmount = servingAmount;
	}
	public String getDifficulty() {
		return Difficulty;
	}
	public void setDifficulty(String difficulty) {
		Difficulty = difficulty;
	}
	@Override
	public String toString() {
		return "MealDTO [strMeal=" + strMeal + ", idMeal=" + idMeal + ", strCategory=" + strCategory + ", MealType="
				+ MealType + ", strMealThumb=" + strMealThumb + ", Ingredients=" + Arrays.toString(Ingredients)
				+ ", IngredientMeasurements=" + Arrays.toString(IngredientMeasurements) + ", strInstructions="
				+ strInstructions + ", ServingAmount=" + ServingAmount + ", Difficulty=" + Difficulty + "]";
	}
}
