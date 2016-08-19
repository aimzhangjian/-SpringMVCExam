package com.aim.filmStore.service.impl;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aim.filmStore.dao.AddressDao;
import com.aim.filmStore.dao.CustomerDao;
import com.aim.filmStore.dao.PaymentDao;
import com.aim.filmStore.dao.RentalDao;
import com.aim.filmStore.domain.Address;
import com.aim.filmStore.domain.Customer;
import com.aim.filmStore.domain.PageBean;
import com.aim.filmStore.service.CustomerService;



/**
 * 业务层注解
 * 
 * @author aim
 * 
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private RentalDao rentalDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Transactional()
	public int saveCustomer(Customer t) {
		int sign=customerdao.saveCustomer(t);
		int id = getNewId();

		Customer customer = getCustomerById(id);

		SimpleDateFormat simpleDate = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
        System.out.println("已经保存的数据如下:");
		System.out.println("Id:"+customer.getCustomer_id()+"    first_name:" + customer.getFirst_name()
				+ "   last_name:" + customer.getLast_name() + "   email:"
				+ customer.getEmail() + "   create_date:"
				+ simpleDate.format(customer.getCreate_date()));

		return sign;
	}

	
	@Transactional()
	public int getNewId() {
		int id=customerdao.getNewId();
		return id;
	}
	@Transactional()
	public Customer getCustomerByName(String name){
		Customer customer=customerdao.getCustomerByName(name);
		return customer;
	}

	
	@Transactional()
	public Customer getCustomerById(int id){
		Customer customer=customerdao.getCustomerById(id);
		return customer;
	}

	@Transactional()
	@Override
	public int deleteCustomer(int id) {
		
	    paymentDao.deletePayment(id);
		
	    rentalDao.deleteRental(id);
	    
		int sign=customerdao.deleteCustomer(id);
		return sign;
	}


	@Override
	public List<Customer> getCustomerList() {
		
		return customerdao.getCustomerList();
	}


	@Override
	public int updateCustomer(Customer customer) {
		return customerdao.updateCustomer(customer);
	}
	
	
	public PageBean<Customer> loadAllFile(int pc, int ps) {

		/*
		 * 1.设置PagerBean对象 2.设置pb的pc和ps 3.得到tr，设置给pb 4.得到beanList，设置给pb 5.返回pb
		 */
		PageBean<Customer> pb = new PageBean<Customer>();
		pb.setPc(pc);
		pb.setPs(ps);

		/*
		 * 得到tr
		 */
		int tr = customerdao.getcount();
		pb.setTr(tr);
        
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("num1",(pc-1)*ps);
		map.put("num2",ps);
		List<Customer> beanList =customerdao.getCustomerPage(map);
		pb.setBeanList(beanList);
		return pb;
	}
	
	public List<Address> getAddress(){
		return addressDao.getAddress();
	}
	
}
