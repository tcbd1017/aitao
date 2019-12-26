package cn.kgc.tangcco.tcbd1017.zhaoyi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.SortingFocusTraversalPolicy;

import org.apache.commons.dbutils.QueryRunner;import org.apache.commons.net.nntp.NewGroupsOrNewsQuery;

import cn.hutool.db.handler.BeanListHandler;
import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1017.zhaoyi.dao.PlanDao;
import cn.kgc.tangcco.tcbd1017.zhaoyi.pojo.Plan;


/**
 * <p>
 * Title:pes-befiron-app
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright:Copyright (c)2019
 * </p>
 * <p>
 * Company:sgai
 * </p>
 * 
 * @author 邵岩松
 * @version 2019年12月18日
 */

public class PlanDaoImpl implements PlanDao {
	QueryRunner qr = new QueryRunner();

	@Override
	public List<Plan> selectPlan(int dkid) throws SQLException {
		List list = new ArrayList<>();
		List<Plan> list1 = new ArrayList<Plan>();
		StringBuilder sql = new StringBuilder("select * from paln a inner join plan_plan_middle b \n"
				+ "on a.id=b.plan_id inner join plan_plan c on b.plan_plan_id=c.id where 1=1 ");
		if (dkid < 30) {
			sql.append(" and a.planname='基础期'");
		} else if (30 < dkid && dkid <= 60) {
			sql.append(" and a.planname='进阶期'");
		} else if (60 < dkid && dkid <= 90) {
			sql.append(" and a.planname='巩固期'");
		} else if (90 < dkid && dkid <= 120) {
			sql.append(" and a.planname='??期'");
		} else if (120 < dkid && dkid <= 150) {
			sql.append(" and a.planname='??期'");
		}
		Object[] array = list.toArray();
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, array);
		while (rs.next()) {
			Plan plan = new Plan();
			
			plan.setId(rs.getInt("id"));
			plan.setPlanname(rs.getString("planname"));
			plan.setPlantime(rs.getString("plantime"));
			plan.setExercisef(rs.getString("Exercisef"));
			plan.setDksum(rs.getInt("dksum"));
			plan.setAccout(rs.getString("accout"));
			plan.setPlanname_name(rs.getString("planname_name"));
			plan.setPlanname_ename(rs.getString("palnname_ename"));
			plan.setPlan_plan_plan_middle_id(rs.getInt("plan_plan_plan_middle_id"));
			list1.add(plan);
		}

		return list1;
	}
	//Plan运动规划父表的增加
	
	@Override
	public int   addPlan(Map<String, Object> map) throws SQLException {
			
		StringBuilder sql =  new  StringBuilder();
			sql.append(" INSERT INTO paln (planname,plantime,Exercisef,dksum,accout) ");
			sql.append("value (?,?,?,?,?)");
			
			System.out.println(sql.toString());
			Object[] sObjects = {map.get("planname"),map.get("plantime"),map.get("Exercisef"),map.get("dksum"),map.get("accout")};
			return qr.update(BaseDBUtils.getConnection(),sql.toString(),sObjects);
	}
	
	
	//Plan_plan运动规划子表的增加
	@Override
	public int addPlan_plan(Map<String, Object> map) throws SQLException {
		StringBuilder sql =  new  StringBuilder();
		
		sql.append(" INSERT INTO plan_plan (planname_name,palnname_ename) ");
		sql.append("value (?,?);");
		Object[] b = {map.get("planname_name"),("palnname_ename")};
		System.out.println(sql.toString());
		return qr.update(BaseDBUtils.getConnection(), sql.toString(),b);
	}
	
	
	//Plan_plan_Middle运动规划中间表的增加
	@Override
	public int addPlan_plan_Middle(Map<String, Object> map) throws SQLException {
		StringBuilder sql =  new  StringBuilder();
		
		sql.append(" INSERT INTO plan_plan_middle(plan_id,plan_plan_id,plan_plan_plan_middle_id) ");
		sql.append("value (?,?,?)");
		System.out.println(sql.toString());
		Object[] c = {map.get("plan_id"),map.get("plan_plan_id"),map.get("plan_plan_plan_middle_id")};
		return qr.update(BaseDBUtils.getConnection(), sql.toString(),c);
	}
	
	
	//Plan运动规划父表的修改
	@Override
	public int updatePlan(Map<String, Object> map) throws SQLException {
		StringBuffer sql= new StringBuffer(" update paln set planname=?,plantime=?,Exercisef=?,dksum=?,accout=? ");
		sql.append(" where id=? ");
		Object[] parmes= {map.get("planname"),map.get("plantime"),map.get("Exercisef"),map.get("dksum"),map.get("accout"),map.get("id")};
		return qr.update(BaseDBUtils.getConnection(),sql.toString(),parmes);
	}
	
	
	//Plan_plan运动规划子表的修改
	@Override
	public int updatePlan_plan(Map<String, Object> map) throws SQLException {
		StringBuffer sql= new StringBuffer(" update paln set planname=?,plantime=?,Exercisef=?,dksum=?,accout=? ");
		sql.append(" where id=? ");
		Object[] parmes= {map.get("planname_name"),map.get("palnname_ename")};
		return qr.update(BaseDBUtils.getConnection(),sql.toString(),parmes);
	}
	
	
	
	
	//Plan_plan_Middle运动规划中间表的修改
	@Override
	public int updatePlan_plan_Middle(Map<String, Object> map) throws SQLException {
		StringBuffer sql= new StringBuffer(" update paln set planname=?,plantime=?,Exercisef=?,dksum=?,accout=? ");
		sql.append(" where id=? ");
		Object[] parmes= {map.get("plan_id"),map.get("plan_plan_id"),map.get("plan_plan_plan_middle_id")};
		return qr.update(BaseDBUtils.getConnection(),sql.toString(),parmes);
		
	}

}
