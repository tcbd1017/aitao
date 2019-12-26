package cn.kgc.tangcco.tcbd1017.zhaoyi.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1017.zhaoyi.pojo.Plan;




/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月18日
 */

public interface PlanDao {
	
	/**
	 * 根据打卡次数查询对应的运动规划
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public  List<Plan> selectPlan(int dkid) throws SQLException;
	
	public	int addPlan(Map<String, Object> map)  throws SQLException;
	
	public	int addPlan_plan(Map<String, Object> map)  throws SQLException;
	
	public	int addPlan_plan_Middle(Map<String, Object> map)  throws SQLException;
	
	public int updatePlan(Map<String, Object> map)  throws SQLException;
	
	public int updatePlan_plan(Map<String, Object> map)  throws SQLException;
	
	public int updatePlan_plan_Middle(Map<String, Object> map)  throws SQLException;
}
