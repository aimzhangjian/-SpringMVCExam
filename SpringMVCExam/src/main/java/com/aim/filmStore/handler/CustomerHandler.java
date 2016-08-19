package com.aim.filmStore.handler;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aim.filmStore.domain.Customer;
import com.aim.filmStore.domain.PageBean;
import com.aim.filmStore.service.CustomerService;

@RequestMapping("/customerHandler")
@Controller
@Scope("prototype")
public class CustomerHandler {

	@Autowired
	private CustomerService customerService;

	@ResponseBody
	@RequestMapping("/getCustomers")
	public PageBean<Customer> getCustomers(
			@RequestParam(value = "pc", required = false) Integer pc,
			HttpServletRequest request) {

		/*
		 * 1.获取页面传递的pc 2.给定ps的值 3.使用pc和ps调用service方法，得到PageBean,保存到request域
		 * 4.转发到list.jsp
		 */

		if (pc == null) {
			pc = 1;
		}

		int ps = 10;
		PageBean<Customer> pb = customerService.loadAllFile(pc, ps);

		// 设置url

		pb.setUrl(getUrl(request));
		return pb;
	}

	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(
			@RequestParam(value = "customer_id", required = false) int customer_id) {
		customerService.deleteCustomer(customer_id);
		return "hompager";
	}

	/*
	 * 截取url
	 */
	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();// 获取项目名
		String servletPath = request.getServletPath();// 获取servletPath
		String queryString = request.getQueryString();// 获取问号后的参数
		// 判断参数后是否包含&pc=，包含便截取掉
		if (queryString != null) {
			if (queryString.contains("&pc=")) {
				int index = queryString.indexOf("&pc=");
				queryString = queryString.substring(0, index);
			}
		}
		return contextPath + servletPath + "?" + queryString;
	}
	@RequestMapping("/toAddCustomer")
	public String toAddCustomer(Map<String, Object> map){
		map.put("customer",new Customer());
		map.put("address",customerService.getAddress());
		return "notebook";
	}
	
	@RequestMapping("/toEditerCustomer")
	public String toEditerCustomer(@RequestParam(value = "customer_id", required = false) int customer_id,Map<String, Object> map){
		
		map.put("customer",customerService.getCustomerById(customer_id));
		map.put("address",customerService.getAddress());
		return "playvideo";
	}
	
	@RequestMapping("/saveEditerCustomer")
	public String saveEditerCustomer(Customer customer){
		
		customerService.updateCustomer(customer);
		
		return "hompager";
	}
	
	@ModelAttribute
	public void getCustomer(
			@RequestParam(value = "customer_id", required = false) Integer customer_id,
			Map<String, Object> map) {
		if (customer_id != null) {
			map.put("customer",customerService.getCustomerById(customer_id));
		}
	}

	
	@RequestMapping("/addCustomer")
	public String addCustomer(Customer customer){
	
		customer.setAddress_id(customer.getAddress().getAddress_id());
		customer.setStore_id(1);
		customer.setActive(1);
		Date date = new Date();
		long datetime = date.getTime();
		Timestamp timestamp = new Timestamp(datetime);

		customer.setCreate_date(timestamp);
		customer.setLast_update(timestamp);
		
		customerService.saveCustomer(customer);
		
		
		return "hompager";
	}
	

}
