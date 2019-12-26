package cn.kgc.tangcco.tcbd1017.shaoyansong.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1017.shaoyansong.dao.PlanDao;
import cn.kgc.tangcco.tcbd1017.shaoyansong.dao.impl.PlanDaoImpl;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Jhdz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Lsdz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan_Middle;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan_Plan_Middle;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Rsdz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Xldz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Yydz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.service.PlanService;

/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月18日
 */

public class PlanServiceImpl implements PlanService{
	Random rd = new Random();
	
	private static PlanDao dao = new PlanDaoImpl();
	static {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		try {
			dao = (PlanDao) context.getBean(PlanDao.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 查询所有运动方法
	 */
	@Override
	public Map<String, Object> selectAll(int dkid) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		int plan_id=0;
		String planname = "";
		String planname_name = "";
		int plan_plan_id = 0;
		if(dkid<=25) {
			plan_id = 1;
			planname="基础期'";
			plan_plan_id = rd.nextInt(5)+1;
		}else if(dkid <=50) {
			plan_id = 2;
			planname="进阶期";
			plan_plan_id = rd.nextInt(6)+6;
		}else if(dkid<=100) {
			plan_id = 3;
			planname="巩固期'";
			plan_plan_id = rd.nextInt(6)+12;
		}
		map.put("planname", planname);
		map.put("planname_name", planname_name);
		try {
			int plan_plan_plan_middle_id = dao.selectPlan_Plan_Plan_Middle_id(plan_id, plan_plan_id);
			Map<String, Object> plan_Plan_Plan_MiddleMap = dao.Plan_Plan_Plan_Middle(plan_plan_plan_middle_id);
			Object object = plan_Plan_Plan_MiddleMap.get("plan_plan_plan_middle");
			if (object!=null) {
				map.put("status", "failed");
				Plan_Plan_Plan_Middle plan_plan_plan_middle =(Plan_Plan_Plan_Middle) object;
				Jhdz jhdz = (Jhdz) dao.Jhdz(plan_plan_plan_middle.getJhid()).get("jhdz");
				map.put("jhdz", jhdz);
				Lsdz lsdz = (Lsdz) dao.Lsdz(plan_plan_plan_middle.getLsid()).get("Lsdz");
				map.put("lsdz", lsdz);
				Rsdz rsdz = (Rsdz) dao.Rsdz(plan_plan_plan_middle.getRsid()).get("rsdz");
				map.put("rsdz", rsdz);
				Xldz xldz = (Xldz) dao.Xldz(plan_plan_plan_middle.getXlid()).get("xldz");
				map.put("xldz", xldz);
				Yydz yydz = (Yydz) dao.Yydz(plan_plan_plan_middle.getYyid()).get("yydz");
				map.put("yydz", yydz);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}


	/**
	 * 运动规划父表查询
	 */
	@Override
	public Map<String, Object> selectPlan() {
		Map<String,Object> map2 = new LinkedHashMap<String, Object>();
		map2.put("code", 0);
		map2.put("msg", "");
		map2.put("count", 0);
		map2.put("data", new ArrayList<Plan>());
		try {
			List<Plan> planlist = dao.selectPlan();
			if (planlist != null && planlist.size() > 0) {
				map2.put("data", planlist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map2;
	}


	/**
	 * 运动规划子表查询
	 */
	@Override
	public Map<String, Object> selectPlan_Plan() {
		Map<String,Object> map2 = new LinkedHashMap<String, Object>();
		map2.put("code", 0);
		map2.put("msg", "");
		map2.put("count", 0);
		map2.put("data", new ArrayList<Plan_Plan>());
		try {
			List<Plan_Plan> planlist = dao.selectPlan_Plan();
			if (planlist != null && planlist.size() > 0) {
				map2.put("data", planlist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map2;
	}


	/**
	 * 运动规划父子中间表查询
	 */
	@Override
	public Map<String, Object> selectPlan_Plan_Middle() {
		Map<String,Object> map2 = new LinkedHashMap<String, Object>();
		map2.put("code", 0);
		map2.put("msg", "");
		map2.put("count", 0);
		map2.put("data", new ArrayList<Plan_Plan_Middle>());
		try {
			List<Plan_Plan_Middle> planlist = dao.selectPlan_Plan_Middle();
			if (planlist != null && planlist.size() > 0) {
				map2.put("data", planlist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map2;
	}
	
	
	
	


	
}
