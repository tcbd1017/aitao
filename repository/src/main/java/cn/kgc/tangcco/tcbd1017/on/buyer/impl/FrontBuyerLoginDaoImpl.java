package cn.kgc.tangcco.tcbd1017.on.buyer.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1017.on.buyer.FrontBuyerLoginDaoIns;

/** 
* @author 作者 Your-Name: 刘煜
* @version 创建时间：2019年12月11日 下午6:36:27 
*    类说明 : 买家用户登录实现
*/
public class FrontBuyerLoginDaoImpl implements FrontBuyerLoginDaoIns {

	@Override
	public Map<String, Object> select_Buyer_Login_Account_Token( Map<String, Object> maps) throws SQLException {
		Connection connection = BaseDBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		Map<String, Object> map= new HashMap<>();
		map.put("buyer_uuid",null);
		List <Object> list=new ArrayList<>();
		StringBuilder sql = new StringBuilder(" SELECT * FROM `0101_buyer` ");
		sql.append(" INNER JOIN `0102_buyer_login` INNER JOIN  `010101_buyer_info` ON 1=1 AND `buyer_status`='2' AND `buyer_login_status`='2' AND `010101_buyer_info`.buyer_info_status='2' ");
		sql.append(" AND `0101_buyer`.`buyer_uuid`=`0102_buyer_login`.`buyer_uuid` ");
		sql.append(" and 0101_buyer.buyer_id = 010101_buyer_info.buyer_id ");
		// 账户密码登录
		if (maps.get("buyer_login_account") != null && maps.get("buyer_login_password") != null) {
			sql.append(" AND `buyer_login_account`=? AND `buyer_login_password`=? ");
			list.add(maps.get("buyer_login_account"));
			list.add(maps.get("buyer_login_password"));
			preparedStatement = BaseDBUtils.getPreparedStatement(connection, sql.toString());
		}
		//人脸注册
		if(maps.get("buyer_login_face_token")!=null) {
			sql.append(" AND `buyer_login_face_token`=? ");
			list.add(maps.get("buyer_login_face_token"));
			preparedStatement = BaseDBUtils.getPreparedStatement(connection, sql.toString());
		}
		ResultSet executeQuery = BaseDBUtils.executeQuery(preparedStatement,list.toArray());
		map = rsToMap(executeQuery);
		return map;
	}
	//手机号登录
	@Override
	public Map<String, Object> select_Buyer_Login_buyer_mobile(Map<String, Object> maps) throws SQLException {
		Connection connection = BaseDBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		Map<String, Object> map= new HashMap<>();
		map.put("buyer_uuid",null);
		StringBuilder sql = new StringBuilder(" SELECT * FROM `0101_buyer` ");
		sql.append(" INNER JOIN `0102_buyer_login` INNER JOIN  `010101_buyer_info` ON 1=1 AND `buyer_status`='2' AND `buyer_login_status` ='2' ");
		sql.append(" AND `0101_buyer`.`buyer_uuid`=`0102_buyer_login`.`buyer_uuid` ");
		sql.append(" and 0101_buyer.buyer_id = 010101_buyer_info.buyer_id ");
		sql.append(" AND `0101_buyer`.`buyer_mobile`=? ");
		Object[] param= {maps.get("buyer_mobile")};
		preparedStatement = BaseDBUtils.getPreparedStatement(connection, sql.toString());
		ResultSet executeQuery = BaseDBUtils.executeQuery(preparedStatement,param);
		map = rsToMap(executeQuery);
		return map;
	}
	private Map<String, Object> rsToMap(ResultSet rs) {
		Map<String, Object> info = null;
		try {
			if (rs.first()) {
				rs.previous();
				info = new HashMap<String, Object>();
				// 获取总列数
				int columnCount = rs.getMetaData().getColumnCount();
				while (rs.next()) {
					// 遍历每一列,拿出列名和数据
					for (int i = 1; i <= columnCount; i++) {
						String columnLabel = rs.getMetaData().getColumnLabel(i);
						Object value = rs.getObject(i);
						info.put(columnLabel, value);
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return info;
	}
}
