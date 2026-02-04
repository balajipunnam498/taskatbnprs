package com.bnprs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnprs.dao.UserDao;
import com.bnprs.model.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl {
	
	@Autowired
	private UserDao userDao;
	
	
	public String saveUser(User user) {
		userDao.save(user);
		return "saved";
	}
	
	public User getUser(int userid) {
		User user = userDao.findById(userid).get();
		return user;
	}
	
	public String updateUser(int userid,String email) {
		int updated = userDao.updateEmailById(userid, email);
		 return updated > 0 ? "email updated" : "user not found";
	}
	
	public String deleteUser(int userid) {
		userDao.deleteById(userid);
		return "Deleted";
	}
}
