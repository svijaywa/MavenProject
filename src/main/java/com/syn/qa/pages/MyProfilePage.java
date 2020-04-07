package com.syn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.syn.qa.base.TestBase;

public class MyProfilePage extends TestBase {
	
	@FindBy(id="syn_customer_field_profile_customer_type_require")
	 WebElement iama;
	
	@FindBy(id="syn_customer_field_profile_fax_require")
	 WebElement fax;
	
	@FindBy(id="syn_customer_field_profile_first_name_require")
	 WebElement firstname;
	
	@FindBy(id="syn_customer_field_profile_inform_me_by_require")
	 WebElement plsInformMeBy;
	
	@FindBy(id="syn_customer_field_profile_last_name_require")
	 WebElement lastName;
	
	@FindBy(id="syn_customer_field_profile_location_require")
	 WebElement address;
	
	@FindBy(id="syn_customer_field_profile_mobile_require")
	 WebElement mobile;
	
	@FindBy(id="syn_customer_field_profile_telephone_require")
	 WebElement telephone;
	
	@FindBy(id="syn_customer_field_profile_title_require")
	 WebElement title;
	
	@FindBy(id="syn_customer_field_customer_groups_require")
	 WebElement customer_group;
	
	@FindBy(id="syn_customer_field_login_method_require")
	 WebElement login_method;
	
	
	

}
