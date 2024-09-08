package com.security.test.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.test.entity.UserInfo;
import com.security.test.repository.UserInfoRepo;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo=userInfoRepo.findByName(username);
		
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("user not found " +username));
		
		
	}

}
