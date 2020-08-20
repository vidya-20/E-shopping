package com.online.dao;

import com.online.model.UserDetail;
public interface userDao {
	public boolean registerUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUser(String username);
}
