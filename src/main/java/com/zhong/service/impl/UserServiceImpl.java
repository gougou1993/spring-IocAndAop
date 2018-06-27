package com.zhong.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhong.dao.UserDao;
import com.zhong.entity.User;
import com.zhong.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate; // 
	
	@Override
	public User findById(Long id) {
		
		return (User) jdbcTemplate.query("select * from user ", new RowMapper(){
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user =new User();
				user.setUsername(rs.getString("username"));
				return user;
			}
		}).get(0);
		
//		return userDao.findById(id);
	}

	@Override
	public int deleteById(Long id) {
		return 0;
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	// 测试嵌套事务的运行
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void parent() {
		// 这样调用其实事务是不生效的
		//this.child();
		
		// 正确的做法:获得当前的对象的代理对象，调用其方法，并且捕获其抛出的异常(不然父方法自己回滚了)，不影响父类的事务
		try{
			UserService currentProxy = (UserService)AopContext.currentProxy();
			currentProxy.child();// 子方法本身的事务生效
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void child() {
		// TODO Auto-generated method stub
		
	}

}
