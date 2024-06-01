package com.jsp.foodapp.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.Dao.ProductDao;
import com.jsp.foodapp.Dao.UserDao;
import com.jsp.foodapp.dto.Products;
import com.jsp.foodapp.dto.User;

@Controller
public class UserController 
{
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	@RequestMapping("/AddUser")
	public ModelAndView addUser()
	{
		ModelAndView mav = new ModelAndView("AddUserForm");
		User user = new User();
		mav.addObject("User", user);
		return mav;
	}
	
	@RequestMapping("/SaveUser")
	public ModelAndView saveUserData(@ModelAttribute("User") User user)
	{
		ModelAndView mav = new ModelAndView("adminOptions");
		userDao.saveUserData(user);
		mav.addObject("msg", "Signup completed Successfully");
		return mav;
	}
	
	@RequestMapping("/UserValidate")
	public ModelAndView LogIn(HttpServletRequest req)
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = userDao.loginValidate(email,password);
		if(user!=null)
		{
			ModelAndView mav = new ModelAndView("UserHome");
			HttpSession http = req.getSession();
			http.setAttribute("user", user);
			return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("UserLogIn");
			mav.addObject("msg", "Invalid Credentials");
			return mav;
		}
	}
	
}
