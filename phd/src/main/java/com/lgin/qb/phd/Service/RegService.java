package com.lgin.qb.phd.Service;

import java.util.Collection;

import java.util.Objects;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lgin.qb.phd.model.Reg;



public class RegService implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private long id;

	
	private String shopname;
	

	private String username;
	

	private String pharmacycouncilreciptnumber;
	
	
	private String pharmacistregistrationnumber;
	
	
	private String country;
	
	
	private String state;
	
	
	private String city;
	
	
	private String pincode;
	
	
	private String email;
	
	
	private String password;
	
	
	private String cnfpass;
	
	
	private String mobilenumber;
	
	
	private String pharmacylicensenumber;
	
	
	private String pancardnumber;
	
	
	private String gstnumber; 
	
	
	private String nameofbranch; 
	
	
	private String branchlocality; 
	
	
	private String yearofregistration; 
	
	
	private String validitylicenseupto; 
	
	
	private String branchemail; 
	
	
	private String landlinenumber; 
	
	private static Collection<? extends GrantedAuthority> authorities;

	public RegService(long id, String shopname, String username, String pharmacycouncilreciptnumber,
			String pharmacistregistrationnumber, String country, String state, String city, String pincode,
			String email, String password, String cnfpass, String mobilenumber, String pharmacylicensenumber,
			String pancardnumber, String gstnumber, String nameofbranch, String branchlocality,
			String yearofregistration, String validitylicenseupto, String branchemail, String landlinenumber,Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.shopname = shopname;
		this.username = username;
		this.pharmacycouncilreciptnumber = pharmacycouncilreciptnumber;
		this.pharmacistregistrationnumber = pharmacistregistrationnumber;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.email = email;
		this.password = password;
		this.cnfpass = cnfpass;
		this.mobilenumber = mobilenumber;
		this.pharmacylicensenumber = pharmacylicensenumber;
		this.pancardnumber = pancardnumber;
		this.gstnumber = gstnumber;
		this.nameofbranch = nameofbranch;
		this.branchlocality = branchlocality;
		this.yearofregistration = yearofregistration;
		this.validitylicenseupto = validitylicenseupto;
		this.branchemail = branchemail;
		this.landlinenumber = landlinenumber;
		this.authorities = authorities;
	}
		
		public static RegService build(Reg reg){
		
			
			return new RegService(reg.getId(),
					reg.getShopname(),
					reg.getUsername(),
					reg.getPharmacycouncilreciptnumber(),
					reg.getPharmacistregistrationnumber(),
					reg.getCountry(),
					reg.getState(),
					reg.getCity(),
					reg.getPincode(),
					reg.getEmail(),
					reg.getPassword(),
					reg.getCnfpass(),
					reg.getMobilenumber(),
					reg.getPharmacylicensenumber(),
					reg.getPancardnumber(),
					reg.getGstnumber(),
					reg.getNameofbranch(),
					reg.getBranchlocality(),
					reg.getYearofregistration(),
					reg.getValiditylicenseupto(),
					reg.getBranchemail(),
					reg.getLandlinenumber(),
					authorities);
			
		}
	public long getId() {
		return id;
	}

	public String getShopname() {
		return shopname;
	}

	public String getUsername() {
		return username;
	}

	public String getPharmacycouncilreciptnumber() {
		return pharmacycouncilreciptnumber;
	}

	public String getPharmacistregistrationnumber() {
		return pharmacistregistrationnumber;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getPincode() {
		return pincode;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCnfpass() {
		return cnfpass;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public String getPharmacylicensenumber() {
		return pharmacylicensenumber;
	}

	public String getPancardnumber() {
		return pancardnumber;
	}

	public String getGstnumber() {
		return gstnumber;
	}

	public String getNameofbranch() {
		return nameofbranch;
	}

	public String getBranchlocality() {
		return branchlocality;
	}

	public String getYearofregistration() {
		return yearofregistration;
	}

	public String getValiditylicenseupto() {
		return validitylicenseupto;
	}

	public String getBranchemail() {
		return branchemail;
	}

	public String getLandlinenumber() {
		return landlinenumber;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
	        
        RegService reg = (RegService) o;
        return Objects.equals(id, reg.getId());
    

	}
}
