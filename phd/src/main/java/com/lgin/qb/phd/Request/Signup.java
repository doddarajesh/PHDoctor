package com.lgin.qb.phd.Request;

import javax.persistence.Column;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//
//import org.springframework.beans.factory.annotation.Value;
//
//import antlr.collections.List;

public class Signup {
	
	@Column(name = "shopname")
	private String shopname;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "pharmacycouncilreciptnumber")
	private String pharmacycouncilreciptnumber;
	
	@Column(name = "pharmacistregistrationnumber")
	private String pharmacistregistrationnumber;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pincode")
	private String pincode;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "cnfpass")
	private String cnfpass;
	
	@Column(name = "mobilenumber")
	private String mobilenumber;
	
	@Column(name = "pharmacylicensenumber")
	private String pharmacylicensenumber;
	
	@Column(name = "pancardnumber")
	private String pancardnumber;
	
	@Column(name = "gstnumber")
	private String gstnumber; 
	
	@Column(name = "nameofbranch")
	private String nameofbranch; 
	
	@Column(name = "branchlocality")
	private String branchlocality; 
	
	@Column(name = "yearofregistration")
	private String yearofregistration; 
	
	@Column(name = "validitylicenseupto")
	private String validitylicenseupto; 
	
	@Column(name = "branchemail")
	private String branchemail; 
	
	@Column(name = "landlinenumber")
	private String landlinenumber;

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPharmacycouncilreciptnumber() {
		return pharmacycouncilreciptnumber;
	}

	public void setPharmacycouncilreciptnumber(String pharmacycouncilreciptnumber) {
		this.pharmacycouncilreciptnumber = pharmacycouncilreciptnumber;
	}

	public String getPharmacistregistrationnumber() {
		return pharmacistregistrationnumber;
	}

	public void setPharmacistregistrationnumber(String pharmacistregistrationnumber) {
		this.pharmacistregistrationnumber = pharmacistregistrationnumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getCnfpass() {
		return cnfpass;
	}

	public void setCnfpass(String cnfpass) {
		this.cnfpass = cnfpass;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPharmacylicensenumber() {
		return pharmacylicensenumber;
	}

	public void setPharmacylicensenumber(String pharmacylicensenumber) {
		this.pharmacylicensenumber = pharmacylicensenumber;
	}

	public String getPancardnumber() {
		return pancardnumber;
	}

	public void setPancardnumber(String pancardnumber) {
		this.pancardnumber = pancardnumber;
	}

	public String getGstnumber() {
		return gstnumber;
	}

	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}

	public String getNameofbranch() {
		return nameofbranch;
	}

	public void setNameofbranch(String nameofbranch) {
		this.nameofbranch = nameofbranch;
	}

	public String getBranchlocality() {
		return branchlocality;
	}

	public void setBranchlocality(String branchlocality) {
		this.branchlocality = branchlocality;
	}

	public String getYearofregistration() {
		return yearofregistration;
	}

	public void setYearofregistration(String yearofregistration) {
		this.yearofregistration = yearofregistration;
	}

	public String getValiditylicenseupto() {
		return validitylicenseupto;
	}

	public void setValiditylicenseupto(String validitylicenseupto) {
		this.validitylicenseupto = validitylicenseupto;
	}

	public String getBranchemail() {
		return branchemail;
	}

	public void setBranchemail(String branchemail) {
		this.branchemail = branchemail;
	}

	public String getLandlinenumber() {
		return landlinenumber;
	}

	public void setLandlinenumber(String landlinenumber) {
		this.landlinenumber = landlinenumber;
	} 
}
	

