package com.aim.filmStore.handler;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aim.filmStore.domain.Customer;
import com.aim.filmStore.domain.Staff;
import com.aim.filmStore.service.CustomerService;
import com.aim.filmStore.service.StaffService;
import com.aim.filmStore.util.ValidateUtil;

@RequestMapping("/loginHandler")
@SessionAttributes(value = { "user" })
@Controller
@Scope("prototype")
public class LoginHandler {

	@Autowired
	private StaffService staffService;

	@Autowired
	private CustomerService customerService;

	/**
	 * 验证信息
	 */
	@RequestMapping(value = "/doLogin")
	public String doLogin(
			@RequestParam(value = "password", required = false) String password,
			Customer customer, Map<String, Object> map) {
		// 1.验证登陆信息
		if (ValidateUtil.isValid(password)) {
			Customer user = customerService.getCustomerByName(customer
					.getFirst_name());
			if (user == null) {
				return "login";
			} else {
				map.put("user", user);
				return "hompager";
			}
		} else {
			return "login";
		}

	}

	@RequestMapping(value = "/quit")
	public String quit(HttpSession session){
		session.removeAttribute("user");
		return "login";
	}

	
	
}
