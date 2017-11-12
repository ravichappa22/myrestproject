package com.example.rest;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class MyRestController {
	
	
	@RequestMapping("/name")
	@PreAuthorize("hasRole('ROLE_write')")
	public Principal getMyName(Principal user){
		System.out.println("inside getMyName>>>>");
		return user;
	}

}
