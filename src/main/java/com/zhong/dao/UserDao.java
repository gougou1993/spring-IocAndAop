package com.zhong.dao;

import com.zhong.entity.User;

public interface UserDao {
	public User findById(Long id);
	public User update(User user);
	public User deleteById(Long id);
}
