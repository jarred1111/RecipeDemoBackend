package com.app.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.models.DAOLink;

import antlr.collections.List;

@Repository
public interface UserRecipesLinkDao extends CrudRepository<DAOLink, Long> {

	@Query(value = "SELECT id FROM Saved_Recipe where user_Id = :id", nativeQuery = true)
	Iterable<Long> findAllByUserId(long id);

}
