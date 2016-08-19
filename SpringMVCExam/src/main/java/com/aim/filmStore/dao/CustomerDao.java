package com.aim.filmStore.dao;


import java.util.List;
import java.util.Map;

import com.aim.filmStore.domain.Customer;
import com.aim.filmStore.domain.Staff;





public interface CustomerDao{
	int saveCustomer(Customer customer);
  
	int getNewId();
	
	int updateCustomer(Customer customer);
	
	Customer getCustomerByName(String name);
	
	Customer getCustomerById(int id);
	
	int deleteCustomer(int id);
	
	List<Customer> getCustomerList();
	
	int getcount();
	
	List<Customer> getCustomerPage(Map<String,Integer> paramMap);
}
