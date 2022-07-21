package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Config.BCryptPasswordEncoder;
import com.example.demo.Model.User2;
import com.example.demo.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//1.show register page
	
	@GetMapping("/reg")
	public String showReg()
	{
		return "UserRegister";
	}
	
	//2.read form data for save operation
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User2 user2, Model model)
	{
		Integer id = service.saveUser(user2);
		user2.setPwd(this.bCryptPasswordEncoder.encode(user2.getPwd()));
		String msg="User "+id+" saved";
		model.addAttribute("message",msg);
		return "UserRegister";
	}
	@GetMapping("/get")
	public Object getUsers()
	{
		return service.getUser();
	}
}
