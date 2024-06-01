package com.jsp.foodapp.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.Dao.ProductDao;
import com.jsp.foodapp.Dao.UserDao;
import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;
import com.jsp.foodapp.dto.User;


@Controller
public class FoodOrderController 
{
	@Autowired
	UserDao userDao;
//	@Autowired
//	ProductDao productDao;
	@RequestMapping("/OrderFood")
	public ModelAndView orderFood()
	{
		FoodOrder foodOrder = new FoodOrder();
		ModelAndView mav = new ModelAndView("AddOrder");
		mav.addObject("foodOrder", foodOrder);
		return mav;
	}
	
	@RequestMapping("saveOrder")
	public ModelAndView saveOrder(@ModelAttribute("foodOrder") FoodOrder order, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("redirect:/showProductforOrder");
		session.setAttribute("foodorder", order);
		return mav;
	}
	
	@RequestMapping("/submitOrder")
	public ModelAndView submitOrder(HttpSession session)
	{
		FoodOrder fOrder = (FoodOrder)session.getAttribute("foodorder");
		User users = (User)session.getAttribute("user");
		List<FoodOrder> orderList  = users.getFoodOrder();
		if(orderList!=null)
		{
			orderList.add(fOrder);
			List<Item> itemLists = fOrder.getItem();
			double sum=0;
			for(Item items :itemLists)
			{
				sum+=items.getCost();
			}
			fOrder.setTotalCost(sum);
			users.setFoodOrder(orderList);
			fOrder.setUser(users);
		}
		else
		{
			List<FoodOrder> orderLists = new ArrayList<FoodOrder>();
			orderLists.add(fOrder);
			List<Item> itemLists = fOrder.getItem();
			double sum=0;
			for(Item items :itemLists)
			{
				sum+=items.getCost();
			}
			fOrder.setTotalCost(sum);
			users.setFoodOrder(orderLists);
			fOrder.setUser(users);
		}
			userDao.updateUser(users);
			ModelAndView mav = new ModelAndView("ShowBill");
			mav.addObject("ItemList", fOrder.getItem());
			return mav;
		
	}
	
	@RequestMapping("/ViewOrders")
	public ModelAndView ViewOrders(HttpSession session)
	{
		User user = (User)session.getAttribute("user");
		List<FoodOrder> foodorderList =  user.getFoodOrder();
		ModelAndView mav = new ModelAndView("MyOrders");
		mav.addObject("OdderList", foodorderList);
		return mav;
 	}
}
