package cn.kgc.tangcco.tcbd1017.shaoyansong.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1017.shaoyansong.dao.PlanDao;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Jhdz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Lsdz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan_Middle;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Plan_Plan_Plan_Middle;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Rsdz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Xldz;
import cn.kgc.tangcco.tcbd1017.shaoyansong.pojo.Yydz;

/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月21日
 */

public class PlanDaoImpl implements PlanDao{
	
	public int selectPlan_Plan_Plan_Middle_id(int plan_id, int plan_plan_id)throws SQLException {
		StringBuilder sql = new StringBuilder(" select plan_plan_plan_middle_id from plan_plan_middle  ");
		sql.append(" WHERE plan_plan_id = ? AND plan_id = ? ");
		Object[] param = {plan_id,plan_plan_id};
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		int plan_plan_plan_middle_id=0;
		if (rs.first()) {
			rs.previous();
			while (rs.next()) {
				plan_plan_plan_middle_id = rs.getInt("plan_plan_plan_middle_id");
			}
		}
		return plan_plan_plan_middle_id;
		
	}
	


	@Override
	public Map<String, Object> Plan_Plan_Plan_Middle(int plan_plan_plan_middle_id) throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from plan_plan_plan_middle  ");
		sql.append(" where id = ? ");
		Object[] param = {plan_plan_plan_middle_id};
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		Map<String,Object> map = new HashMap<String, Object>();
		if (rs.first()) {
			rs.previous();
			Plan_Plan_Plan_Middle plan_plan_plan_middle = new Plan_Plan_Plan_Middle();
			while (rs.next()) {
				plan_plan_plan_middle.setJhid(rs.getInt("jhid"));
				plan_plan_plan_middle.setLsid(rs.getInt("lsid"));
				plan_plan_plan_middle.setRsid(rs.getInt("rsid"));
				plan_plan_plan_middle.setXlid(rs.getInt("xlid"));
				plan_plan_plan_middle.setYyid(rs.getInt("yyid"));
				map.put("plan_plan_plan_middle", plan_plan_plan_middle);
			}
		}
		return map;
	}



	@Override
	public Map<String, Object> Jhdz(int jhid) throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from jhdz ");
		sql.append(" where id = ? ");
		Object[] param = {jhid};
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		Map<String,Object> map = new HashMap<String, Object>();
		if (rs.first()) {
			rs.previous();
			Jhdz jhdz = new Jhdz();
			while (rs.next()) {
				jhdz.setDzname(rs.getString("dzname"));
				jhdz.setDzjieshao(rs.getString("dzjieshao"));
				jhdz.setUrl(rs.getString("url"));
				jhdz.setDid(rs.getInt("did"));
				map.put("jhdz", jhdz);
			}
		}
		return map;
	}



	@Override
	public Map<String, Object> Lsdz(int lsid) throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from lsdz ");
		sql.append(" where id = ? ");
		Object[] param = {lsid};
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		Map<String,Object> map = new HashMap<String, Object>();
		if (rs.first()) {
			rs.previous();
			Lsdz lsdz = new Lsdz();
			while (rs.next()) {
				lsdz.setDzname(rs.getString("dzname"));
				lsdz.setDzjieshao(rs.getString("dzjieshao"));
				lsdz.setUrl(rs.getString("url"));
				lsdz.setDid(rs.getInt("did"));
				map.put("lsdz", lsdz);
			}
		}
		return map;
	}



	@Override
	public Map<String, Object> Rsdz(int rsid) throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from rsdz ");
		sql.append(" where id = ? ");
		Object[] param = {rsid};
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		Map<String,Object> map = new HashMap<String, Object>();
		if (rs.first()) {
			rs.previous();
			Rsdz rsdz = new Rsdz();
			while (rs.next()) {
				rsdz.setDzname(rs.getString("dzname"));
				rsdz.setDzjieshao(rs.getString("dzjieshao"));
				rsdz.setUrl(rs.getString("url"));
				rsdz.setDid(rs.getInt("did"));
				map.put("rsdz", rsdz);
			}
		}
		return map;
	}



	@Override
	public Map<String, Object> Xldz(int xlid) throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from xldz ");
		sql.append(" where id = ? ");
		Object[] param = {xlid};
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		Map<String,Object> map = new HashMap<String, Object>();
		if (rs.first()) {
			rs.previous();
			Xldz xldz = new Xldz();
			while (rs.next()) {
				xldz.setDzname(rs.getString("dzname"));
				xldz.setDzjieshao(rs.getString("dzjieshao"));
				xldz.setUrl(rs.getString("url"));
				xldz.setDid(rs.getInt("did"));
				map.put("xldz", xldz);
			}
		}
		return map;
	}



	@Override
	public Map<String, Object> Yydz(int yyid) throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from yydz ");
		sql.append(" where id = ? ");
		Object[] param = {yyid};
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		Map<String,Object> map = new HashMap<String, Object>();
		if (rs.first()) {
			rs.previous();
			Yydz yydz = new Yydz();
			while (rs.next()) {
				yydz.setDzname(rs.getString("dzname"));
				yydz.setDzjieshao(rs.getString("dzjieshao"));
				yydz.setUrl(rs.getString("url"));
				yydz.setDid(rs.getInt("did"));
				map.put("yydz", yydz);
			}
		}
		return map;
	}


	/**
	 * 查询父表
	 */
	@Override
	public List<Plan> selectPlan() throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from paln where 1 = 1 ");
		Object[] param = null;
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		List<Plan> list = new ArrayList<Plan>();
		while (rs.next()) {
			list.add(new Plan(rs.getInt("id"), rs.getString("planname"), rs.getString("plantime"), rs.getString("Exercisef"), rs.getInt("dksum"), rs.getString("accout")));
		}
		
		return list;
	}


	/**
	 * 查询子表
	 */
	@Override
	public List<Plan_Plan> selectPlan_Plan() throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from plan_plan where 1 = 1 ");
		Object[] param = null;
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		List<Plan_Plan> list = new ArrayList<Plan_Plan>();
		while (rs.next()) {
			list.add(new Plan_Plan(rs.getInt("id"), rs.getString("planname_name"), rs.getString("planname_ename")));
		}
		
		return list;
	}


	/**
	 * 查询父子中间表
	 */
	@Override
	public List<Plan_Plan_Middle> selectPlan_Plan_Middle() throws SQLException {
		StringBuilder sql = new StringBuilder(" select * from plan_plan_middle where 1 = 1 ");
		Object[] param = null;
		Connection conn = BaseDBUtils.getConnection();
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		List<Plan_Plan_Middle> list = new ArrayList<Plan_Plan_Middle>();
		while (rs.next()) {
			list.add(new Plan_Plan_Middle(rs.getInt("id"), rs.getInt("plan_id"), rs.getInt("plan_plan_id"), rs.getInt("plan_plan_plan_middle_id")));
		}
		
		return list;
	}
	
	
	
	
	
	
}
