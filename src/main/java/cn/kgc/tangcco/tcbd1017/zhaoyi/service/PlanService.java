package cn.kgc.tangcco.tcbd1017.zhaoyi.service;

import java.util.Map;

/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月18日
 */

public interface PlanService {
	Map<String, Object> selectPlan(int dkid);
	Map<String, Object> addPlan(Map<String, Object> map);
	Map<String, Object>	addPlan_Plan(Map<String, Object> map);
	Map<String, Object>	addPlan_plan_plan_middle(Map<String, Object> map);
	
	Map<String, Object>	UpdatePlan(Map<String, Object> map);
	Map<String, Object>	UpdatePlan_Plan(Map<String, Object> map);
	Map<String, Object>	UpdatePlan_plan_plan_middle(Map<String, Object> map);
}
