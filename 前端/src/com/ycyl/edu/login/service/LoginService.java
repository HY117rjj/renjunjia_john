package com.ycyl.edu.login.service;

import com.ycyl.edu.system.entity.EduStudent;


public interface LoginService {
	
	public EduStudent checkUser(String user, String password, String isAdmin);
}
