package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.models.DAOGeneralUser;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public DAOGeneralUser getUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
}
