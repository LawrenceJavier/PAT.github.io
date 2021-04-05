package edu.comillas.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.comillas.demo.model.User;
import edu.comillas.demo.service.UserService;

@Controller
@RequestMapping("/controller")
public class DemoController {
	

	@GetMapping("list")
	public String list(Model model) {
		UserService userlist = new UserService();
		final User user1 = new User();
		user1.setNombre("javi");
		final User user2 = new User();
		user2.setNombre("alberto");
		final User user3 = new User();
		user3.setNombre("juan");
		final List<User> users = List.of(user1, user2, user3);
		model.addAttribute("users", users);
		
		
		return "list";
		

	}

}
