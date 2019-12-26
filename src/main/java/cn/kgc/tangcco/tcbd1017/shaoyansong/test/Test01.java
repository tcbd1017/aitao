package cn.kgc.tangcco.tcbd1017.shaoyansong.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.kgc.tangcco.tcbd1017.shaoyansong.dao.PlanDao;
import cn.kgc.tangcco.tcbd1017.shaoyansong.dao.impl.PlanDaoImpl;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan;
import cn.kgc.tangcco.tcbd1017.shaoyansong.service.PlanService;
import cn.kgc.tangcco.tcbd1017.shaoyansong.service.impl.PlanServiceImpl;

/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月18日
 */

public class Test01 {
	private PlanDao dao = new PlanDaoImpl();
	private PlanService service = new PlanServiceImpl();
	Plan plan = new Plan();
	
	
	@Test
	public void testselectAllPlanname_Name() {
		try {
			int i = dao.selectPlan_Plan_Plan_Middle_id(2, 1);
			if (i > 0) {
				System.out.println(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testselectPlan() {
		try {
			List<Plan> list = dao.selectPlan();
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testselectPlan01() {
		Map<String, Object> map = service.selectPlan();
		System.out.println(map);
	}
	
}
