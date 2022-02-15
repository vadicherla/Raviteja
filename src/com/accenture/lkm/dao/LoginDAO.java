package com.accenture.lkm.dao;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.LoginBean;

@Repository
public class LoginDAO {

	public String validateLogin(LoginBean loginBean){
		
		String uName = loginBean.getUserName();
		String password = loginBean.getPassword();
		
		if(uName.equalsIgnoreCase("RAVI") && password.equals("123"))
		{
			return "user1";
		}else if(uName.equalsIgnoreCase("pranab") && password.equals("111"))
		 		{	 			
		 	 return "user2";
		 		}	 
		else
		{
			return "failure";
		}
	}
	}

