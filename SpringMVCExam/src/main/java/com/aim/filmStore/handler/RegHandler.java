/*package com.aim.filmStore.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aim.filmStore.domain.Staff;
import com.aim.filmStore.service.StaffService;
import com.aim.filmStore.util.DateUtil;
import com.aim.filmStore.util.ValidateUtil;

@Controller("regAction")
@Scope("prototype")
public class RegHandler{

	private static final long serialVersionUID = 1L;
	private static boolean error = false;
	private Random random = new Random();
	private String sizeJson = "";

	

	// 注入userService
	@Resource
	private StaffService staffService;
	// 接收session的map
	private Map<String, Object> sessionMap;

	private String affirmPassword;



	
	public String getAffirmPassword() {
		return affirmPassword;
	}

	public void setAffirmPassword(String affirmPassword) {
		this.affirmPassword = affirmPassword;
	}

	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	// 此方法会在每个方法前调用
	public void validate() {

		System.out.println(model.getUsername() + "--" + model.getPassword()
				+ "    :" + affirmPassword);

		if (!ValidateUtil.isValid(model.getUsername())) {
			addFieldError("userName", "用户名不能为空!");
		}

		if (ValidateUtil.isValid(model.getPassword())) {
			if (model.getPassword().trim().length() < 6
					|| model.getPassword().trim().length() > 18) {
				addFieldError("password", "密码6~18位");
			}
		} else {
			addFieldError("password", "密码不能为空");
		}

		if (hasErrors()) {
			return;
		}

		if (!affirmPassword.equals(model.getPassword())) {
			addFieldError("affirmPassword", "密码不一致");
			return;
		}

		if (staffService.isRegisted(model.getUsername())) {
			
			 * if (false) { response.getWriter().print("111"); error = true; }
			 
			addFieldError("userName", "用户名已注册!");
			error = true;
			return;
		}

	}

	*//**
	 * 注册用户
	 * 
	 * @param user
	 *//*
	public String doReg() {

		if (!error) {
			System.out.println("dodoReg");
			model.setLast_update(new java.sql.Timestamp(DateUtil.getDate()));

			byte[] bytes = IOUtils.toByteArray(new FileInputStream(
					staffImag));
			
				Blob taffimgBlob = new SerialBlob(bytes);
				model.setPicture(taffimgBlob);

			// 保存注册用户
			staffService.saveStaff(model);
			sessionMap.put("staff", model);
			// 统计注册用户数
			Integer usernumber = (Integer) servletContext
					.getAttribute("userCount");
			if (usernumber == null) {
				usernumber = 1;
			} else {
				usernumber++;
			}
			servletContext.setAttribute("userCount", usernumber);
		}

		error = false;

		return "goHompager";
	}

}
*/