package foodstore.codes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import foodstore.codes.dao.AddProductDao;
import foodstore.codes.dao.CategoryDao;
import foodstore.codes.model.AddProduct;
import foodstore.codes.model.Category;

@Controller("HomePageController")
class HomePageController
{
	@RequestMapping(value="Login")
	public String Login(){
	System.out.println("Login");
	return "Login";
}
}

@Controller("HomeController")
class HomeController
{
	@RequestMapping(value="Home")
	public ModelAndView Login(){
	System.out.println("Index");
	return new ModelAndView("redirect:http://localhost:8080/Foodstore");
}
}

@Controller("AboutController")
class AboutController
{
	@RequestMapping(value="About")
	public String About(){
	System.out.println("About");
	return "About";
}
}

@Controller("ProductsController")
class ProductsController
{
	@Autowired
	AddProductDao adao;
	@RequestMapping(value="Products")
    public ModelAndView listOfTeams() {
	 //AddProduct addp=new AddProduct();
        ModelAndView modelAndView = new ModelAndView("Product");
         	        List<AddProduct> teams = adao.getProducts();
         	        //System.out.println("obj:"+teams);
                    modelAndView.addObject("lists", teams);
        	        return modelAndView;
    }
	
}

@Controller("UserProductsController")
class UserProductsController
{
	@Autowired
	AddProductDao adao;
	@RequestMapping(value="UserProduct")
    public ModelAndView listOfTeams() {
	 //AddProduct addp=new AddProduct();
        ModelAndView modelAndView = new ModelAndView("UserProduct");
         	        List<AddProduct> teams = adao.getProducts();
         	        //System.out.println("obj:"+teams);
                    modelAndView.addObject("lists", teams);
        	        return modelAndView;
    }
	
}



@Controller("ContactController")
class ContactController
{
	@RequestMapping(value="Contact")
	public String Contact(){
	System.out.println("Contact");
	return "Contact";
}
}
