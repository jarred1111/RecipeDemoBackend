package com.app.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.entities.GeneralUserDTO;
import com.app.models.DAOGeneralUser;

@Service
public class JwtUserDetailsService implements UserDetailsService, IJwtUserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOGeneralUser user = userDao.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public DAOGeneralUser save(GeneralUserDTO user) {	
		
		System.out.println(user.toString());
		UUID uuid = UUID.randomUUID();
		
		DAOGeneralUser newUser = new DAOGeneralUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUID(uuid);
		
		System.out.println(newUser.toString());
		return userDao.save(newUser);
	}
}
