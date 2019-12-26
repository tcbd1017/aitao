package cn.kgc.tcbd1017.lixin.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tcbd1017.lixin.dao.FaceDao;
import cn.kgc.tcbd1017.lixin.pojo.JianShen;



/**
 * 
 * @author 梅许
 * @version  1.1 
 *  2019年12月19日下午2:54:20
 *	类描述：	
 */
public class FaceDaoImpl implements FaceDao{
	QueryRunner runner = new QueryRunner();
	@Override
	public int inertFace(int id, String face) throws SQLException {
			StringBuilder sql = new StringBuilder("update login set   ");
			sql.append(" face = ? ");
			sql.append(" where id = ? ");
			Object[] params = {face,id};
			return runner.update(BaseDBUtils.getConnection(), sql.toString(), params);	
	}
	@Override
	public JianShen selectByFace(String face) throws SQLException {
		StringBuffer sql = new StringBuffer("select id ,username,password,power from login ");
		sql.append(" where 1=1  ");
		sql.append(" and face = ? ");
		Object[] params = {face};
		JianShen query = runner.query(BaseDBUtils.getConnection(), sql.toString(), new BeanHandler<JianShen>(JianShen.class), params);
		return query;
	}

}
