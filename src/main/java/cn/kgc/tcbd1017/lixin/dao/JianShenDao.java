package cn.kgc.tcbd1017.lixin.dao;

import java.sql.SQLException;

import cn.kgc.tcbd1017.lixin.pojo.JianShen;



/**
 * 
 * @author 李鑫
 * @version 1.0<br>
  * 创建时间：2019年12月18日 上午10:15:51<br>
  *类描述：<br>
 *
 */
public interface JianShenDao {


	/**
	 * 通过账号密码查询账户信息
	 * @param jianShen
	 * @return
	 * @throws SQLException
	 */
	public abstract JianShen getJianShenByAccountAndPassword(JianShen jianShen) throws SQLException;
}
