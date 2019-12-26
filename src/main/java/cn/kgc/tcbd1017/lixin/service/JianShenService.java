package cn.kgc.tcbd1017.lixin.service;

import java.sql.SQLException;
import java.util.Map;

import cn.kgc.tcbd1017.lixin.pojo.JianShen;







/**
 * 
 * @author 李鑫
 * @version 1.0<br>
  * 创建时间：2019年12月18日 上午10:22:27<br>
  *类描述：<br>
 *
 */
public interface JianShenService {
	/**
	   * 根据账号密码获取员工信息
	 * @return
	 * @throws SQLException
	 */
	public abstract Map<String, Object> getJianShenByAccountAndPAssword(JianShen jianshen);
}
