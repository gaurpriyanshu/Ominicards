package com.spring_mongo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mongo.model.User;
import com.spring_mongo.repository.UserRepository;



@RestController
public class UserController {


	List<User> list;
	@Autowired
	private UserRepository repo;

	final String domains[] = {"@google.com" , "@gmail.com" , "@yahoo.com" , "@hotmail.com"};
	@GetMapping("/findAllUsers/{input}")
	public List<String> getUsers(@PathVariable String input) {
		input = input.toLowerCase();
		List<String> usersWithGivenSequenceList = new ArrayList<>();
		list = repo.findAll();
		for(User user : list) {
            String userEmail = user.getUserEmail();
			String name = userEmail.split("@")[0];
			if(name.contains(input))
				usersWithGivenSequenceList.add(userEmail);
        }
		for(String domain : domains)
			if(!usersWithGivenSequenceList.contains(input + domain))
				usersWithGivenSequenceList.add(input+domain);
		System.out.println("No of Emails returned with the given input: "+ usersWithGivenSequenceList.size());
		return usersWithGivenSequenceList;
	}
}
