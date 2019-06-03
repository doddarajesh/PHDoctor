package com.lgin.qb.phd.controller;

import java.sql.Time;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lgin.qb.phd.Repository.BillRepository;
import com.lgin.qb.phd.Repository.RegRepository;
import com.lgin.qb.phd.Request.Accountsettings;
import com.lgin.qb.phd.Request.EditProfile;
import com.lgin.qb.phd.Request.ForgetPassword;
import com.lgin.qb.phd.Request.ForgetPasswordLink;
import com.lgin.qb.phd.Request.Loginform;
import com.lgin.qb.phd.Request.Otp;
import com.lgin.qb.phd.Request.Passwordsettings;
import com.lgin.qb.phd.Request.Signup;
import com.lgin.qb.phd.Security.jwt.JwtProvider;
import com.lgin.qb.phd.Service.OtpService;
import com.lgin.qb.phd.model.Bill;
import com.lgin.qb.phd.model.Reg;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class MainController {
	
	@Autowired
	RegRepository userrepository;
	
	@Autowired
	AuthenticationManager authenticationmanager;
	
	@Autowired
	BillRepository billrepository;
	
	@Autowired
	OtpService otpService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtProvider jwtprovider;
	
	@Autowired
	public JavaMailSender mailsender;
	

	
	
	Long otpgentime;
	int otp;

// to create pharmacy registration	
	
	@PostMapping(value ="create")
	public ResponseEntity<String> postCustomer(@RequestBody Signup customer) {
		if(userrepository.existsByEmail(customer.getEmail())) {
			return new ResponseEntity<String>("Fail-> Email is already in use...",HttpStatus.BAD_REQUEST);
			
		}else
			
			if(userrepository.existsByMobilenumber(customer.getMobilenumber())) {
				return new ResponseEntity<String>("Fail-> ContactNumber is already in use...",HttpStatus.BAD_REQUEST);
			}

		Reg r = userrepository.save(new Reg(customer.getShopname(), customer.getUsername(), customer.getPharmacycouncilreciptnumber(),
				customer.getPharmacistregistrationnumber(), customer.getCountry(), customer.getState(), customer.getCity(), customer.getPincode(),
				customer.getEmail(), encoder.encode(customer.getPassword()), encoder.encode(customer.getCnfpass()), customer.getMobilenumber(), customer.getPharmacylicensenumber(),
				customer.getPancardnumber(), customer.getGstnumber(), customer.getNameofbranch(), customer.getBranchlocality(), customer.getYearofregistration(),
				customer.getValiditylicenseupto(), customer.getBranchemail(), customer.getLandlinenumber()));
		
		userrepository.save(r);
        
		 return ResponseEntity.ok().body("Registered successfully...!");
} 
	
	
	@GetMapping(path="/user/{id}")
	   public String[] getuser(@PathVariable("id") Long id){
		   
		   Optional<Reg> reg=userrepository.findById(id);	   
		   
		   Reg r=reg.get();
		   
		  String[] rg= {r.getPassword(),r.getUsername(),r.getEmail()};
		   
		   return rg;
		   	  
	  }
	
	@GetMapping(path="/users/{id}")
	  public @ResponseBody Optional<Reg> getAllEmail(@PathVariable("id") Long id) {
	       return userrepository.getAllEmail();
	       
	   }
	
// to get the data from registration through id
	
	@GetMapping("/get/{id}")
	public Optional<Reg> getuser(@PathVariable("id") long id ){
		return userrepository.findById(id);
	}
	
// to get all data from registration
	
	@GetMapping("/retrivereg")
	public List<Reg> getall(){
		return userrepository.findAll();
	}
	

// to login
	
		@PostMapping(value="/login")
		public ResponseEntity<?> authenticateUser(@Valid @RequestBody Loginform loginRequest){
			
			
			Authentication authentication=authenticationmanager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			String jwt=jwtprovider.generateJwtToken(authentication);
			UserDetails userDetails=(UserDetails) authentication.getPrincipal();
			return ResponseEntity.ok().body("Login is successfull...!");
			
		}
	
// to create bill dashboard
		
	@PostMapping("/createbill")
	public ResponseEntity<String> createuser(@RequestBody Bill bill) {
		 billrepository.save(bill);
		 return ResponseEntity.ok().body("Successfully uploaded...!");
	}


	
//to get the data through billid
	
	@GetMapping("/retrive/{id}")
	public Optional<Bill> getuser1(@PathVariable("id") Long id){
		return billrepository.findById(id);
	}
	
// edit profile 
		
		@PutMapping(value="/update/{id}") 
		public ResponseEntity<String> editprofileById(@RequestBody EditProfile editRequest , @PathVariable("id") Long id){
			
	    Optional<Reg> user=userrepository.findById(id);
			 if(user.isPresent()) {
				 
	         Reg u=user.get();
				 u.setShopname(editRequest.getShopname());
				 u.setNameofbranch(editRequest.getNameofbranch());
				 u.setMobilenumber(editRequest.getMobilenumber());
				 u.setEmail(editRequest.getEmail());
				 u.setBranchlocality(editRequest.getBranchlocality());
				 u.setValiditylicenseupto(editRequest.getValiditylicenseupto());
				 u.setBranchemail(editRequest.getBranchemail());
				 u.setLandlinenumber(editRequest.getLandlinenumber());
				 
				
				 
				 userrepository.save(u);
				 
				 return ResponseEntity.ok().body("Updated successfully...!");
				 
				 }
	   
	             return ResponseEntity.ok().body("Error found in edit profile");
	  }
		
		
	// update email  through id
		
		@PutMapping("/updated/{id}")
		public ResponseEntity<String> update(@RequestBody Accountsettings account,@PathVariable("id") Long id){
			
			if(userrepository.existsByEmail(account.getEmail())) {
				
			
			  Optional<Reg> user=userrepository.findById(id);
			  if(user.isPresent()) {
				  
				  Reg u=user.get();
				  u.setEmail(account.getNewemailid());
				  
				  userrepository.save(u);
				  
				  
				  return ResponseEntity.ok().body("Updated successfully...!");
			  }
			  
			}
	   
	             return ResponseEntity.ok().body("Enter valid mail id...");
	  }
					 
// update password through id
		
		@PutMapping("/updating/{id}")
		
		public ResponseEntity<String> updated(@RequestBody Passwordsettings p,@PathVariable("id") Long id) {
			
			if(userrepository.existsByPassword(p.getPassword())) {
			
//			 if(userrepository.existsByCnfpass(p.getCnfpass())) {
					
			  Optional<Reg> user=userrepository.findById(id);
			  
			  if(user.isPresent()) {                                  
				  
				  Reg u=user.get();
				  
				  u.setPassword(encoder.encode(p.getNewpassword()));
				  
				   u.setCnfpass(encoder.encode(p.getCnfnewpass()));
				  
				    userrepository.save(u);
				  
				   return ResponseEntity.ok().body("Updated successfully...!");
		}
   } 
	                 return ResponseEntity.ok().body("Enter valid password ");
	}
		
//		@PostMapping("/signin")
//		public ResponseEntity<String> signin(@RequestBody Loginform login){
//		
//		if(userrepository.existsByEmail(login.getEmail())) {
//				
//			 if(userrepository.existsByPassword(login.getPassword())) {
//					
//					return ResponseEntity.ok().body("login successfully!");
//					
//				}	
//			}
//			
//			return ResponseEntity.ok().body("login is not successfully!");
//			
//		}
//				
//		} 
	
// to generate otp

		@PostMapping(value="/reset")
		public ResponseEntity<String>user(@Valid @RequestBody ForgetPassword resetRequest){
			
			SimpleMailMessage message=new SimpleMailMessage();
			if(userrepository.existsByEmail(resetRequest.getEmail())) {
				
				message.setTo(resetRequest.getEmail());
				message.setSubject("Reset password");
				
				otp=otpService.generateOTP();
				message.setText("your otp:"+otp);
				Calendar c=Calendar.getInstance();
				otpgentime=c.getTimeInMillis();
				
				mailsender.send(message);
				
				return new ResponseEntity<String>("Mail id exists",HttpStatus.FOUND);
			}
			
			return ResponseEntity.ok().body("Mail id does not exists");
			
			}
		
// to verify otp
		
		
	    @PostMapping(value="verify")
	    public ResponseEntity<String> verify(@Valid @RequestBody Otp otpform){
		
			Calendar c=Calendar.getInstance();
			
			Time time;
			
			if((otp)==otpform.getOtp()) {
				
				if(c.getTimeInMillis()-otpgentime<=(5000*60)) 
				{
					return new ResponseEntity<String>("Entered otp is valid...!",HttpStatus.FOUND);
				}
			}
				return ResponseEntity.ok().body("Otp is not valid");
				
				}
		
// to update or change the password through Email
	 	
	 @PutMapping(value="/forgot/{email}")
	 public ResponseEntity<String> updatepassword( @RequestBody ForgetPasswordLink forgot , @PathVariable("email") String email){
		
	 		Optional<Reg>user=userrepository.findByEmail(email);
	        
	 			if(user.isPresent()) {
	 			Reg u=user.get();
	 		    u.setPassword(encoder.encode(forgot.getPassword()));
	 			u.setCnfpass(encoder.encode(forgot.getCnfpass()));
	 			userrepository.save(u);
	 			return ResponseEntity.ok().body("New password updated succesfully...!");
	 			
	 			}
	 			
	 			
	 	
	 			return ResponseEntity.ok().body("Password is not updated");
	 			
	 }
	 
}

