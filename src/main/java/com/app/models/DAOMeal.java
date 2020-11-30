package com.app.models;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity()
@Table(name = "recipe")
public class DAOMeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String meal_name;
	@Column
	private int meal_db_id;
	@Column
	private String food_catagory;
	@Column
	private String meal_type;
	@Column
	private String meal_img_url;

	@ElementCollection
	@OrderColumn
	private String[] ingredient;

	@ElementCollection
	@OrderColumn
	private String[] ingredient_measurements;

	@Column(length = 1000000)
	@Lob
	private String instructions;
	@Column
	private int serving_amount;
	@Column
	private String difficulty;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMeal_name() {
		return meal_name;
	}

	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}

	public int getMeal_db_id() {
		return meal_db_id;
	}

	public void setMeal_db_id(int meal_db_id) {
		this.meal_db_id = meal_db_id;
	}

	public String getFood_catagory() {
		return food_catagory;
	}

	public void setFood_catagory(String food_catagory) {
		this.food_catagory = food_catagory;
	}

	public String getMeal_type() {
		return meal_type;
	}

	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}

	public String getMeal_img_url() {
		return meal_img_url;
	}

	public void setMeal_img_url(String meal_img_url) {
		this.meal_img_url = meal_img_url;
	}

	public String[] getIngredient() {
		return ingredient;
	}

	public void setIngredient(String[] ingredient) {
		this.ingredient = ingredient;
	}

	public String[] getIngredient_measurements() {
		return ingredient_measurements;
	}

	public void setIngredient_measurements(String[] ingredient_measurements) {
		this.ingredient_measurements = ingredient_measurements;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getServing_amount() {
		return serving_amount;
	}

	public void setServing_amount(int serving_amount) {
		this.serving_amount = serving_amount;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return "DAOMeal [id=" + id + ", meal_name=" + meal_name + ", meal_db_id=" + meal_db_id + ", food_catagory="
				+ food_catagory + ", meal_type=" + meal_type + ", meal_img_url=" + meal_img_url + ", ingredient="
				+ Arrays.toString(ingredient) + ", ingredient_measurements=" + Arrays.toString(ingredient_measurements)
				+ ", instructions=" + instructions + ", serving_amount=" + serving_amount + ", difficulty=" + difficulty
				+ "]";
	}

}
