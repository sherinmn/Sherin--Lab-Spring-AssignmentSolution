package com.greatlearning.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.student.entity.User;
import com.greatlearning.student.repository.UserRepository;
import com.greatlearning.student.security.CustomUserDetails;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User dbUser = userRepository.findByUsername(userName);

		if (dbUser == null)
			throw new UsernameNotFoundException("Cannot find the user");
		else
			return new CustomUserDetails(dbUser);
	}

}
