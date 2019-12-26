package cn.kgc.tangcco.tcbd1017.shaoyansong.service;

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
	/**
	 * 根据dkid查询所有
	 * @param dkid
	 * @return
	 */
	Map<String, Object> selectAll(int dkid);
	
	
	/**
	 * 查询运动规划父表
	 * @return
	 */
	Map<String, Object> selectPlan();
	/**
	 * 查询运动规划子表
	 * @return
	 */
	Map<String, Object> selectPlan_Plan();
	/**
	 * 查询运动规划父子中间表
	 * @return
	 */
	Map<String, Object> selectPlan_Plan_Middle();
}
