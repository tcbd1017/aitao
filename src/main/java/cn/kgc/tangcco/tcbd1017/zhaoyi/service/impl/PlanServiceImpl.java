package cn.kgc.tangcco.tcbd1017.zhaoyi.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1017.zhaoyi.dao.PlanDao;
import cn.kgc.tangcco.tcbd1017.zhaoyi.pojo.Plan;
import cn.kgc.tangcco.tcbd1017.zhaoyi.service.PlanService;

/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月18日
 */

public class PlanServiceImpl implements PlanService{
	private static PlanDao dao;
	static {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		try {
			dao = (PlanDao) context.getBean(PlanDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Map<String, Object> selectPlan(int dkid) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		try {
			List<Plan> list = dao.selectPlan(dkid);
			if (list != null && list.size() > 0) {
				map.put("status", "success");
				map.put("list", list);
			}else {
				System.out.println("空！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}


	@Override
	public Map<String, Object> addPlan(Map<String, Object> map) {
		Map<String, Object> map1 = new  HashMap<String, Object>();
		map1.put("status", "failed");
		try {
			int a =dao.addPlan(map);
			if (a>0) {
				map1.put("status","success");
			}
			return map1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return map1;  
		}
	}


	@Override
	public Map<String, Object> addPlan_Plan(Map<String, Object> map) {
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("status", "failed");
		try {
			int b=dao.addPlan_plan(map);
			
			
			if (b>0) {
					
					map2.put("status", "success");
			}
			return map2;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map2 ;
	}
	public Map<String, Object> addPlan_plan_plan_middle(Map<String, Object> map) {
		
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("status", "failed");
		try {
		int	addPlan_plan_Middle = dao.addPlan_plan_Middle(map);
			if(addPlan_plan_Middle>0) {
				
				info.put("status", "success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return info;
	}


	@Override
	public Map<String, Object> UpdatePlan(Map<String, Object> map) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("status", "failed");
		try {
			int updatePlan = dao.updatePlan(map);
			if(updatePlan>0) {
				info.put("status", "success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info ;
	}


	@Override
	public Map<String, Object> UpdatePlan_Plan(Map<String, Object> map) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("status", "failed");
		try {
			int UpdatePlan_Plan = dao.updatePlan_plan(map);
			if(UpdatePlan_Plan>0) {
				info.put("status", "success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info ;
	}


	@Override
	public Map<String, Object> UpdatePlan_plan_plan_middle(Map<String, Object> map) {
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("status", "failed");
		try {
			int UpdatePlan_plan_plan_middle = dao.updatePlan_plan_Middle(map);
			if(UpdatePlan_plan_plan_middle>0) {
				info.put("status", "success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info ;
	}
	
}
