package com.jsp.foodapp.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.jsp.foodapp.Dao.ProductDao;
import com.jsp.foodapp.dto.Products;


@Controller
public class ProductController 
{
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/AddProduct")
	public ModelAndView sendProduct()
	{
		ModelAndView mav = new ModelAndView("ProductAdd");
		Products product = new Products();
		mav.addObject("Product", product);
		return mav;
	}
	
	@RequestMapping("/SaveProduct")
	public ModelAndView saveProduct(@ModelAttribute("Product") Products product)
	{
		ModelAndView mav = new ModelAndView("adminOptions");
		productDao.saveProduct(product);
		mav.addObject("msg", "Product added");
		return mav;
	}
	
	@RequestMapping("/ViewProduct")
	public ModelAndView ViewProduct()
	{
		ModelAndView mav = new ModelAndView("ShowingProduct");
		List<Products> productList = productDao.getProduct();
		mav.addObject("prodList", productList);
		return mav;
	}
	
	@RequestMapping("/Update")
	public ModelAndView update(@RequestParam("id") int id)
	{
		ModelAndView mav = new ModelAndView("updateProduct");
		Products product = productDao.getById(id);
		mav.addObject("Product", product);
		return mav;
	}
	
	@RequestMapping("/UpdateData")
	public ModelAndView updateProduct(@ModelAttribute("Product") Products product)
	{
		productDao.updateProduct(product);
		ModelAndView mav = new ModelAndView("ShowingProduct");
		List<Products> productList = productDao.getProduct();
		mav.addObject("prodList", productList);
		System.out.println(product.getId());
		return mav;
	}
	
	
	
	@RequestMapping("/Delete")
	public ModelAndView deleteProducts(@RequestParam("id") int id)
	{
		productDao.deleteProduct(id);
		
//		productDao.deleteProductById(id);
		ModelAndView mav = new ModelAndView("redirect:/ViewProduct");
		return mav;
	}
	
	@RequestMapping("/showProductforOrder")
	public ModelAndView order()
	{
		ModelAndView mav = new ModelAndView("OrderingFood");
		List<Products> prodList = productDao.getProduct();
		mav.addObject("ProductList", prodList);
		return mav;
	}
	
}
