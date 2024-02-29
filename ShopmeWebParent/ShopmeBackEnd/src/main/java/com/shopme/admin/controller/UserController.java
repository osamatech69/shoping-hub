package com.shopme.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.admin.services.UserService;
import com.shopme.coomon.entity.Role;
import com.shopme.coomon.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public String listAll(Model model) {
		List<User> listUsers=service.listAll();
		/* List<Role>listRole=service.listRoles(); */
		model.addAttribute("listUsers", listUsers);
		/* model.addAttribute("listRole", listRole); */
		return "users";
	}
	
	@GetMapping("user/new")
	public String createNewUser(Model model) {
	List<Role>listRoles=service.listRoles();
		User user=new User();
		user.setEnabled(true);
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);

		return "user_form";
	}
	
	@PostMapping("users/save")
	public String saveUser(User user,RedirectAttributes attributes) {
		service.save(user);
		attributes.addFlashAttribute("message","the user has been save successfully ");
		System.out.println(user);
		return "redirect:/users";
	}
	
}
