package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.database.StudentDataBase;
import com.student.data.HodPojo;

public class HodService {
	
	static Map<Integer, HodPojo> hodDataInfo= StudentDataBase.getAllHodData();
	
	public List<HodPojo> getHodData() {
		return new ArrayList<>(hodDataInfo.values());
	}
	
	public HodPojo removeHod(int deptId) {
		return hodDataInfo.remove(deptId);
	}
	
	public HodPojo updateHod(HodPojo h1) {
		if(h1.getDeptId()<0) 
			return null;
		else 
			hodDataInfo.put(h1.getDeptId(), h1);
		return h1;
	}
	
	public HodPojo addAnotherHod(HodPojo h1) {
		h1.setDeptId(hodDataInfo.size()+1);
		hodDataInfo.put(h1.getDeptId(), h1);
		return h1;
	}
	
	public HodPojo getParticularHod(int deptId) {
		return hodDataInfo.get(deptId);
	}

}
