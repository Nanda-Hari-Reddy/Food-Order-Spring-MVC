package com.jsp.foodapp.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.Dao.ProductDao;
import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;
import com.jsp.foodapp.dto.Products;
import com.jsp.foodapp.dto.User;

@Controller
public class ItemController 
{
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/AddItem")
	public ModelAndView addItem(@RequestParam("id") int id, HttpSession session)
	{
		Products product = productDao.getById(id);
		Item item = new Item();
		item.setName(product.getName());
		item.setCost(product.getCost());
		ModelAndView mav = new ModelAndView("ItemAdd");
		mav.addObject("Item", item);
		return mav;
		
	}
	
	@RequestMapping("ItemAdded")
	public ModelAndView saveItem(@ModelAttribute("Item") Item item, HttpSession session)
	{
		System.out.println(item.toString());
		FoodOrder foodorder = (FoodOrder)session.getAttribute("foodorder");
		item.setCost(item.getQuantity()*item.getCost());
		List<Item> itemList = foodorder.getItem();
		System.out.println(itemList);
		item.setFoodorder(foodorder);
		if(itemList!=null)
		{
			
			itemList.add(item);
			foodorder.setItem(itemList);
		}
		else
		{
			List<Item> itemLists = new ArrayList<Item>();
			itemLists.add(item);
			System.out.println(item.toString());
			foodorder.setItem(itemLists);
			System.out.println(itemLists);
		}
		ModelAndView mav = new ModelAndView("redirect:/showProductforOrder");
		return mav;
	}
}
