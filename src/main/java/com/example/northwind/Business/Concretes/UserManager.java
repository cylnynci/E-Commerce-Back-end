package com.example.northwind.Business.Concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.Business.Abstracts.UserService;
import com.example.northwind.Core.DataAccess.UserDao;
import com.example.northwind.Core.Entities.User;
import com.example.northwind.Core.Utilities.Results.DataResult;
import com.example.northwind.Core.Utilities.Results.Result;
import com.example.northwind.Core.Utilities.Results.SuccessDataResult;
import com.example.northwind.Core.Utilities.Results.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı Bulundu");
	}

}
