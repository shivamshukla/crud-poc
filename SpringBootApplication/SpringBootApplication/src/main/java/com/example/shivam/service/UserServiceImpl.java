package com.example.shivam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.shivam.domain.User;
import com.example.shivam.domain.UserRepository;

/**
 * 
 * @author shivam
 *
 */
@Service
public class UserServiceImpl implements UserDetailsService  {
	private final UserRepository repository;

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User currentUser = repository.findByUsername(username);
    	
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(), true, 
        		true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        
        System.out.println("ROLE: " + currentUser.getRole());
        return user;
    }
    
}