package foodstore.codes.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import foodstore.codes.dao.AddProductDao;
import foodstore.codes.dao.RegisterDao;
import foodstore.codes.model.AddProduct;

@Controller
public class LoginPageController {

	
	@Autowired
	 RegisterDao registerdao;

	@Autowired
	AddProductDao adao;
	//@SuppressWarnings("unchecked")
	//	@SuppressWarnings("unchecked")
		@RequestMapping(value="/login_session_attributes")
		public ModelAndView login_session_attributes(HttpSession session,Model model) {
		ModelAndView modelAndView=null;
		boolean loggedIn=true;
			System.out.println("Spring Security");
			String userid = SecurityContextHolder.getContext().getAuthentication().getName();
			//UserCredential user = registerdao.getuserid(userid);
			session.setAttribute("name", userid);
			//session.setAttribute("password", user.getPassword());
			session.setAttribute("LoggedIn", "true");

			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			//String page="";
			//String role="ROLE_USER";
			for (GrantedAuthority authority : authorities) 
			{
			  
			     if (authority.getAuthority().equals("ROLE_USER")) 
			     {
			    	  modelAndView = new ModelAndView("UserProduct");
	         	        List<AddProduct> teams = adao.getProducts();
	         	        //System.out.println("obj:"+teams);
	        modelAndView.addObject("lists", teams);
	        	        break;
			     }
			     else 
			     {
			    	  modelAndView = new ModelAndView("admin");
	         	        List<AddProduct> teams = adao.getProducts();
	         	        //System.out.println("obj:"+teams);
	        modelAndView.addObject("lists", teams);
	        	        break;
			    }
			}
			return modelAndView;
		}

		@RequestMapping("/Logout")  
		 public ModelAndView getLoginForm(  
		   @RequestParam(value = "Logout", required = false) String Logout) {  
		  
		  String message = "";  
		   if (Logout != null) {  
		   message = "Logout successful !";  
		  }  
		  return new ModelAndView("Login", "message", message);  
		 }  
	   //@RequestMapping(value="product")
		//public String product()
		//{
			//System.out.println("product");
			//return "product";
		//}

}
