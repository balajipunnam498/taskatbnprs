package com.bnprs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnprs.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	 	@Modifying
	    @Transactional
	    @Query("UPDATE User u SET u.email = :email WHERE u.userid = :id")
	    int updateEmailById(int id, String email);
	
}
