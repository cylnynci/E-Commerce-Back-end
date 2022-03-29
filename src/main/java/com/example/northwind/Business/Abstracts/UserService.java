package com.example.northwind.Business.Abstracts;

import com.example.northwind.Core.Entities.User;
import com.example.northwind.Core.Utilities.Results.DataResult;
import com.example.northwind.Core.Utilities.Results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User>findByEmail(String email);
}
