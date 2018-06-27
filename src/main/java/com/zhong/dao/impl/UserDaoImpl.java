package com.zhong.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhong.dao.UserDao;
import com.zhong.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Override
	public User findById(Long id) {
		User user = new User();
		user.setUsername("zhong");
		user.setVersion(1L);
		return user;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public User deleteById(Long id) {
		return null;
	}

}
