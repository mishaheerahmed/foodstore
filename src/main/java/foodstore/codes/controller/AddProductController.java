package foodstore.codes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import foodstore.codes.dao.AddProductDao;
import foodstore.codes.model.AddProduct;

@Controller
public class AddProductController {
	@Autowired
	AddProductDao adao;
	
	
		

	@RequestMapping(value="AddProduct", method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("AddProduct")AddProduct AddProduct)
	{
			System.out.println("AddProduct");	
			ModelAndView model=new ModelAndView("AddProduct");
			return model;
	}
	
	
	@RequestMapping(value="AddProduct", method=RequestMethod.POST)
	public ModelAndView Success(AddProduct pr, Model m)
	{
			adao.addproduct(pr);
			ModelAndView model=new ModelAndView("Login","AddProduct", new AddProduct());
			return model;
	}
	

	

}
