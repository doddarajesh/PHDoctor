package com.lgin.qb.phd.Service;

import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class OtpService {


	public Integer generateOTP(){
		
		Random random=new Random();
				int OTP=100000+random.nextInt(500000);
				return OTP;
		
		}
	
}
