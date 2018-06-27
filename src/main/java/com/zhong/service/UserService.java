package com.zhong.service;

import com.zhong.entity.User;
/**
 * 
 * @author admin
 *
 */
public interface UserService {
	public User findById(Long id);
	public int  deleteById(Long id);
	public User update(User user);
	
	public void parent();
	public void child();
}
