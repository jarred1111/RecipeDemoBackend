package com.app.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.models.DAOMeal;


@Repository
public interface MealDao extends CrudRepository<DAOMeal, Long> {

	@Query(value = "SELECT id FROM recipe where meal_db_id = :id", nativeQuery = true)
	DAOMeal findByMeal_db_Id(@Param("id") int id);

	@Query(value = "SELECT * FROM recipe WHERE id IN (:mealIds)", nativeQuery = true)
	List<DAOMeal> getAllByIds(@Param("mealIds") Iterable<Long> mealIds);
}
