package com.app.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.models.DAOGeneralUser;

@Repository
public interface UserDao extends CrudRepository<DAOGeneralUser, Long> {
	DAOGeneralUser findByUsername(String username);
	
	@Query( value = "SELECT * FROM Users",  nativeQuery = true)
	Collection<DAOGeneralUser> findAllActiveUsers();

	@Query(value = "SELECT * FROM Users where username = :username", nativeQuery = true)
	DAOGeneralUser findUserByUsername(String username);
}