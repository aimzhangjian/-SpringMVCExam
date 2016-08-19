package com.aim.filmStore.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aim.filmStore.dao.StaffDao;
import com.aim.filmStore.domain.Staff;
import com.aim.filmStore.service.StaffService;

/**
 * 业务层注解
 * 
 * @author aim
 * 
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffdao;

	@Override
	public void saveStaff(Staff t) {
		staffdao.saveStaff(t);
	}

	@Override
	public void updateStaff(Staff t) {
		staffdao.updateStaff(t);
	}

	@Override
	public void deleteStaff(Integer id) {
		staffdao.deleteStaff(id);
	}

	@Override
	public Staff getStaffById(Integer id) {
		return staffdao.getStaffById(id);
	}

	@Override
	public List<Staff> getStaffList() {
		return staffdao.getStaffList();
	}

	
	/**
	 * 校验用户是否存在
	 */
	@Override
	public Staff validateLoginInfo(String userName, String password) {
		Map<String,String> paramMap=new HashMap<String, String>();
		paramMap.put("username",userName);
		paramMap.put("password",password);
		return staffdao.getStaff(paramMap);
	}

	@Override
	public boolean isRegisted(String username) {
		Map<String,String> paramMap=new HashMap<String, String>();
		paramMap.put("username",username);
		Staff staff=staffdao.getStaff(paramMap);
		return staff!=null? true:false;
	}
	
	
	@Override
	public int getCount(Object... objects) {
		// TODO Auto-generated method stub
		return 0;
	}

}
