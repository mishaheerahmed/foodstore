package foodstore.codes.controller;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import foodstore.codes.dao.RegisterDao;
import foodstore.codes.model.Register;




@Controller
public class RegisterController 
{
	
	@Autowired
	RegisterDao rdao;
	
	
		

	@RequestMapping(value="Register", method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("Register")Register register)
	{
			System.out.println("Register");	
			ModelAndView model=new ModelAndView("Register");
			return model;
	}
	
	
	@RequestMapping(value="Register", method=RequestMethod.POST)
	public ModelAndView Success(Register reg, Model m)
	{
			rdao.adduser(reg);
			ModelAndView model=new ModelAndView("Login","Register", new Register());
			return model;
	}
	

	
	
}
