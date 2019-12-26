package cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.lihaozhe.commons.jdbc.Laypage;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.dao.Dao;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.pojo.JiaoLianInfo;


/**
 * @author sl
 * @version 1.0
 * @date 创建时间：2019年12月18日 上午11:05:03 
 */

public class DaoImpl implements Dao{
	QueryRunner runner = new QueryRunner();
	/**
	 * 添加
	 */
	@Override
	public int add(JiaoLianInfo info) throws SQLException {
		StringBuilder sql=new StringBuilder("Insert into jiaolianinfo (headimg,name,jlbname,jlbaddress,info,zhengshuname,zhengshuimg,zhengshubanfadanwei,zhengshujieshao)");
		sql.append(" values (?,?,?,?,?,?,?,?,?)");
		Object [] params = {info.getHeadimg(),info.getName(),info.getJlbname(),info.getJlbaddress(),info.getInfo(),info.getZhengshuname(),info.getZhengshuimg(),info.getZhengshubanfadanwei(),info.getZhengshujieshao()};
		// TODO Auto-generated method stub
		return runner.update(BaseDBUtils.getConnection(), sql.toString(),params);
	}
	/**
	 * 删除
	 */
	@Override
	public int delete(Map<String, Object> map) throws SQLException {
		StringBuilder sql=new StringBuilder("DELETE FROM jiaolianinfo ");
		sql.append(" WHERE id = ? AND name = ? ");
		Object [] params= {map.get("id").toString(),map.get("name").toString()};
		Connection connection = BaseDBUtils.getConnection();
		PreparedStatement preparedStatement = BaseDBUtils.getPreparedStatement(connection, sql.toString());
		int executeUpdate = BaseDBUtils.executeUpdate(preparedStatement, params);
		// TODO Auto-generated method stub
		return executeUpdate;
	}
	/**
	 * 修改
	 */
	@Override
	public int update(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql =new StringBuilder("update JiaoLianInfo set headimg = ? , name = ? , jlbname = ? , jlbaddress = ? , info = ? , zhengshuname = ? , zhengshuimg = ? , zhengshubanfadanwei = ? , zhengshujieshao = ?");
		sql.append(" where id = ? and  name=? ");
		Object[] params= {map.get("headimg").toString(),map.get("newname").toString(),map.get("jlbname").toString(),map.get("jlbaddress").toString(),map.get("info").toString(),map.get("zhengshuname").toString(),map.get("zhengshuimg").toString(),map.get("zhengshubanfadanwei").toString(),map.get("zhengshujieshao").toString(),map.get("id").toString(),map.get("name").toString()};
		Connection connection = BaseDBUtils.getConnection();
		PreparedStatement preparedStatement = BaseDBUtils.getPreparedStatement(connection, sql.toString());
		int executeUpdate = BaseDBUtils.executeUpdate(preparedStatement, params);
		return executeUpdate;
	}
	/**
	 * 查询
	 */
	@Override
	public List<JiaoLianInfo> select(Map<String, Object> map) throws SQLException {
		StringBuilder sql = new StringBuilder("select * from jiaolianinfo ");
		
		//if(map.containsKey("name") && map.get("name")!=null) {
//			Object[] param = {map.get("name").toString()};
//			System.out.println(param);
		//}
		
		Object[] param = null;
		Connection conn = BaseDBUtils.getConnection();
		// 预编译SQL语句
		PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString(), (Laypage) map.get("laypage"));
		// 执行查询获取结果集
		ResultSet rs = BaseDBUtils.executeQuery(pst, param);
		List<JiaoLianInfo> list = new ArrayList<JiaoLianInfo>();
		while (rs.next()) {
			list.add(new JiaoLianInfo(rs.getString("id"),rs.getString("headimg"), rs.getString("name"),rs.getString("jlbname"),rs.getString("jlbaddress"),rs.getString("info"),rs.getString("zhengshuname"),rs.getString("zhengshuimg"),rs.getString("zhengshubanfadanwei"),rs.getString("zhengshujieshao")));
		}
		return list;
	
	}
	@Override
	public List<JiaoLianInfo> selectAll(Map<String, Object> map) throws SQLException {
StringBuilder sql = new StringBuilder("select * from jiaolianinfo ");
		
		//if(map.containsKey("name") && map.get("name")!=null) {
//			Object[] param = {map.get("name").toString()};
//			System.out.println(param);
		//}
		Object[] param = null;
		List<JiaoLianInfo> list = new ArrayList<JiaoLianInfo>();
		Connection connection = BaseDBUtils.getConnection();
		connection.setAutoCommit(false);
		PreparedStatement preparedStatement = BaseDBUtils.getPreparedStatement(connection, sql.toString());
		ResultSet rs = BaseDBUtils.executeQuery(preparedStatement,param);
		while (rs.next()) {
			list.add(new JiaoLianInfo(rs.getString("id"),rs.getString("headimg"), rs.getString("name"),rs.getString("jlbname"),rs.getString("jlbaddress"),rs.getString("info"),rs.getString("zhengshuname"),rs.getString("zhengshuimg"),rs.getString("zhengshubanfadanwei"),rs.getString("zhengshujieshao")));
		}
		return list;
	}
	@Override
	public int selectCount(Map<String, Object> map) throws SQLException {
		int count = 0;
		StringBuilder sql = new StringBuilder(" SELECT COUNT(id) as count from jiaolianinfo ");
		 Connection conn = BaseDBUtils.getConnection();
			// 预编译SQL语句
			 PreparedStatement pst = BaseDBUtils.getPreparedStatement(conn, sql.toString());
			// 执行查询获取结果集
			 ResultSet rs = BaseDBUtils.executeQuery(pst, null);
			// 结果集游标向下移动判断第一位位置上有没有值
			if (rs.next()) {
				// 结果集游标向下移动判断第一位位置上有没有值,如果值将数据库中的数据获取并复制给总记录数count
				count = rs.getInt("count");
			}
			return count;
	}
	
	

}
