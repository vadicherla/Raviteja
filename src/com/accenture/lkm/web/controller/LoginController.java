package com.accenture.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.dao.LoginDAO;

@Controller
public class LoginController {

	@Autowired
	LoginDAO loginDAO;
	
	  @RequestMapping(value = "/loadLogin", method = RequestMethod.GET)
	  public ModelAndView loadLoginPage() { 
		  ModelAndView modelAndView = new ModelAndView(); 
		  modelAndView.setViewName("login");
		  return modelAndView; }
	 
		
	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("uName")String userName, @RequestParam("pwd")String password) {
    	LoginBean loginBean = new LoginBean();
		loginBean.setPassword(password);
		loginBean.setUserName(userName);
		
				
		String Val = loginDAO.validateLogin(loginBean);

		ModelAndView modelAndView = new ModelAndView();

		if (Val.equals("user1")) {
			loginBean.setUserid(1001);
			loginBean.setStream("JAVA");
			modelAndView.setViewName("userDetails");
			modelAndView.addObject("message",""+userName);
			modelAndView.addObject("msg",""+loginBean.getStream());
			modelAndView.addObject("id",""+loginBean.getUserid());
						
		} else if (Val.equals("user2")) {
			loginBean.setUserid(1002);
			loginBean.setStream("ANGULAR");
			modelAndView.setViewName("userDetails");
			modelAndView.addObject("message",""+userName);
			modelAndView.addObject("msg",""+loginBean.getStream());
			modelAndView.addObject("id",""+loginBean.getUserid());}
			else {
			
			modelAndView.setViewName("failure");
			modelAndView.addObject("errorMessage","Please Login again with valid credentials");
		}
		return modelAndView;

	}
}