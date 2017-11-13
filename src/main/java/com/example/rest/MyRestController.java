package com.example.rest;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public String getMyName(){
		
		System.out.println("inside getMyName>>>>" + SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("Authorities="+ SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		return "Rest Service called successfully which has ROLE_write";
	}

}
