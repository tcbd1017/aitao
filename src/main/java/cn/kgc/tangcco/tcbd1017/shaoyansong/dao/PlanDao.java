package cn.kgc.tangcco.tcbd1017.shaoyansong.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan_Middle;


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
	 * 根据父表id和子表id查询孙中间表id
	 * @param plan_id
	 * @param plan_plan_id
	 * @return
	 * @throws SQLException
	 */
	int selectPlan_Plan_Plan_Middle_id(int plan_id, int plan_plan_id)throws SQLException;
	
	/**
	 * 根据孙中间表id查询所有运动方法表id
	 * @param plan_plan_plan_middle_id
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> Plan_Plan_Plan_Middle(int plan_plan_plan_middle_id)throws SQLException;
	
	/**
	 * 根据运动方法表id查询运动方法
	 * @param jhid
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> Jhdz(int jhid) throws SQLException;
	
	/**
	 * 根据运动方法表id查询运动方法
	 * @param lsid
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> Lsdz(int lsid) throws SQLException;
	
	/**
	 * 根据运动方法表id查询运动方法
	 * @param rsid
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> Rsdz(int rsid) throws SQLException;
	
	/**
	 * 根据运动方法表id查询运动方法
	 * @param xlid
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> Xldz(int xlid) throws SQLException;

	/**
	 * 根据运动方法表id查询运动方法
	 * @param yyid
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> Yydz(int yyid) throws SQLException;
	
	
	
	/**
	 * 查询父表
	 * @param planname
	 * @return
	 * @throws SQLException
	 */
	List<Plan> selectPlan() throws SQLException;
	
	
	/**
	 * 查询子表
	 * @param planname
	 * @return
	 * @throws SQLException
	 */
	List<Plan_Plan> selectPlan_Plan() throws SQLException;
	
	
	/**
	 * 查询父子中间表
	 * @param planname
	 * @return
	 * @throws SQLException
	 */
	List<Plan_Plan_Middle> selectPlan_Plan_Middle() throws SQLException;
	
	
	
}
