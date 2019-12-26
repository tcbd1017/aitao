package cn.kgc.tcbd1017.lixin.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tcbd1017.lixin.dao.JianShenDao;
import cn.kgc.tcbd1017.lixin.pojo.JianShen;



/**
 * 
 * @author 李鑫
 * @version 1.0<br>
  * 创建时间：2019年12月18日 上午10:18:00<br>
  *类描述：<br>
 *
 */
public class JianShenDaoImpl implements JianShenDao{
			QueryRunner queryrunner = new QueryRunner();
	@Override
	public JianShen getJianShenByAccountAndPassword(JianShen jianShen) throws SQLException {
		StringBuffer sql = new StringBuffer("select id ,username,password from login ");
		sql.append(" where 1=1  ");
		sql.append(" and password = ? and username=? ");
		Object[] params = {jianShen.getPassword(),jianShen.getUsername()};
		JianShen query = queryrunner.query(BaseDBUtils.getConnection(), sql.toString(), new BeanHandler<JianShen>(JianShen.class), params);
		return query;
	}

}
