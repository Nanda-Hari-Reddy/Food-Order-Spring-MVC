package com.jsp.foodapp.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.foodapp.Dao.AdminDao;
import com.jsp.foodapp.dto.Admin;

@Controller
public class AdminController
{
	@Autowired
	AdminDao adminDao;
	
	@RequestMapping("/addAdmin")
	public ModelAndView saveAdmin()
	{
		Admin admin = new Admin();
		ModelAndView mav = new ModelAndView("adminloginform");
		admin.setEmail("admin@gmail.com");
		admin.setPassword("admin");
		adminDao.saveAdmin(admin);
		return mav;
	}
	
	@RequestMapping("/validate")
	public ModelAndView validateAdmin(HttpServletRequest req)
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Admin admin = adminDao.validate(email,password);
		if(admin!=null)
		{
			ModelAndView mav = new ModelAndView("adminOptions");
			return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("adminloginform");
			mav.addObject("msg", "Invalid credential");
			return mav;
		}
	}
}
