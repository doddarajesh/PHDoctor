package com.lgin.qb.phd.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lgin.qb.phd.Repository.RegRepository;
import com.lgin.qb.phd.model.Reg;



@Service
public class RegServiceImpl implements UserDetailsService{

	@Autowired
	RegRepository mr;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {
		
		Reg h=mr.findByEmail(email)
				.orElseThrow(()->
				new UsernameNotFoundException("User Not Found with ->email : " + email)
						);
		return RegService.build(h);
	}

}
