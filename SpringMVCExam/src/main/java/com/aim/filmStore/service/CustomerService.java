package com.aim.filmStore.service;

import java.util.List;
import java.util.Map;

import com.aim.filmStore.domain.Address;
import com.aim.filmStore.domain.Customer;
import com.aim.filmStore.domain.PageBean;




public interface CustomerService{
	
    public int saveCustomer(Customer t);
    public int getNewId();
    public Customer getCustomerByName(String name);
    public Customer getCustomerById(int id);
    public int deleteCustomer(int id);
    public List<Customer> getCustomerList();
	public int updateCustomer(Customer customer);
	public PageBean<Customer> loadAllFile(int pc, int ps);
	public List<Address> getAddress();
}
