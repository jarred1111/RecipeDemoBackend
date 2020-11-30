package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRecipesLinkDao;
import com.app.models.DAOLink;

@Service
public class LinkingService {

	@Autowired
	private UserRecipesLinkDao linkDao;

	public void linkUserToRecipe(long mealId, long userId) {
		DAOLink link = new DAOLink();
		link.setMealId(mealId);
		link.setUserId(userId);
		linkDao.save(link);
	}

	public Iterable<Long> getUserRecipesFromID(long id) {
		return linkDao.findAllByUserId(id);
	}
}
