package com.ycyl.edu.login.service.impl;

import java.util.Iterator;

import lombok.Data;

import com.ycyl.edu.login.dao.LoginDao;
import com.ycyl.edu.login.service.LoginService;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.util.MD5;

@SuppressWarnings("all")
@Data
public class LoginServiceImpl implements LoginService {	
	
	private String password;
	public LoginDao loginDao;
	
	public EduStudent checkUser(String username, String password, String isAdmin) {
		if (password == null || password.trim().equals("")) {
			this.password = "";
		} else {
			this.password = new MD5().getStrByMD5(password);
		}

		String sql = "from EduStudent where userName='" + username + "'";// and admin = '" + isAdmin + "'";
		Iterator itr = loginDao.findBySql(sql).iterator();

		String pass = "";
		while (itr.hasNext()) {
			EduStudent user = (EduStudent) itr.next();
			pass = user.getUserPass();
			if (pass == null){
				pass = "";
			}
			if (pass.equals(this.password)){
				return user;
			}
		}
		return null;
	}
}
