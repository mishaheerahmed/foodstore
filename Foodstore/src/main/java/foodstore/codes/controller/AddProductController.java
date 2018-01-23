package foodstore.codes.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import foodstore.codes.dao.AddProductDao;
import foodstore.codes.dao.CategoryDao;
import foodstore.codes.model.AddProduct;
import foodstore.codes.model.Category;

@Controller
public class AddProductController {
	@Autowired
	AddProductDao adao;
	


	
	@RequestMapping(value="AddProduct", method=RequestMethod.POST)
	public ModelAndView Success(AddProduct apt, Model m)
	{
		  List<Category> categories=adao.getAllCategories();
		    m.addAttribute("categories", categories);
			adao.addproduct(apt);
			MultipartFile image=apt.getPimage();
		       if(image != null && !image.isEmpty())
		       {
		      	Path path=Paths.get("D://workspace/Foodstore/src/main/webapp/images/"+apt.getpid()+".png");
		      	try {
		   			image.transferTo(new File(path.toString()));
		   		} catch (IllegalStateException e) {
		   			// TODO Auto-generated catch block
		 			e.printStackTrace();
		  		} catch (IOException e) {
		 			// TODO Auto-generated catch block
		  			e.printStackTrace();
		   		}
		       }
			ModelAndView model=new ModelAndView("redirect:ViewProduct","AddProduct", new AddProduct());
			List<AddProduct> teams = adao.getProducts();
	        //System.out.println("obj:"+teams);
          model.addObject("lists", teams);
			return model;
			}
	
	@RequestMapping(value="AddProduct", method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("AddProduct")AddProduct addproduct,Model model1)
	{
			System.out.println("AddProduct");	
			List<Category> categories=adao.getAllCategories();
			model1.addAttribute("categories", categories);
			model1.addAttribute("product",new AddProduct());
			ModelAndView model=new ModelAndView("AddProduct");
            return model;
	}
	@Bean
	public MultipartResolver multipartresolver(){
		CommonsMultipartResolver multipartresolver=new CommonsMultipartResolver();
		return multipartresolver;
	}
	
	@RequestMapping(value="ViewProduct", method=RequestMethod.GET)
    public ModelAndView listOfTeams() {
	 //AddProduct addp=new AddProduct();
        ModelAndView modelAndView = new ModelAndView("ViewProduct");
         	        List<AddProduct> teams = adao.getProducts();
         	        //System.out.println("obj:"+teams);
        modelAndView.addObject("lists", teams);
        	        return modelAndView;
    }
	 @RequestMapping("EditProduct/{pid}")  
	 public ModelAndView editUser(@PathVariable int pid) {  
	  AddProduct apobj = adao.single_object(pid);  
	  return new ModelAndView("EditProduct", "command",apobj );  
	  }  
	
	 @RequestMapping(value="EditProduct/update",method=RequestMethod.POST)  
	 public ModelAndView updateUser(@ModelAttribute("apobj") AddProduct adp) {  
	  adao.edit_list(adp);  
	  return new ModelAndView("redirect:http://localhost:8080/Foodstore/ViewProduct");
	 }  
	 @RequestMapping(value="delete/{pid}",method=RequestMethod.POST)  
	 public ModelAndView deleteProduct(@PathVariable int pid) {  
	  adao.deleteRow(pid);  
	  return new ModelAndView("redirect:http://localhost:8080/Foodstore/ViewProduct");
	 }  

}
