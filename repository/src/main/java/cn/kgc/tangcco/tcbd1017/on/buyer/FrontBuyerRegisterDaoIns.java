package cn.kgc.tangcco.tcbd1017.on.buyer;

import java.sql.SQLException;
import java.util.Map;

/** 
* @author 作者 Your-Name: 刘煜
* @version 创建时间：2019年12月10日 下午2:40:16 
*    类说明  : 买家用户注册
*/
public interface FrontBuyerRegisterDaoIns {
	/**
	  * 买家用户- 账户密码
	  * @return 影响的数据行数
	  * @throws SQLException 
	  */
	int insert_Account_Password_Byyer(Map<String, Object> map) throws SQLException;
	/**
	 * 账户  买家表新增
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	int insert_Account_Password(Map<String, Object> map) throws SQLException;
	
	/**
	 * 人脸注册
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	int insert_Face(Map<String, Object> map) throws SQLException;
	/**
	 * 买家用户-手机号注册
	 * @return  影响的数据行数
	 * @throws SQLException 
	 */
	int insert_Mobile_Byyer(Map<String, Object> map) throws SQLException;
	
	/**
	 * 买家用户-手机号注册 表二 买家登陆表
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	int insert_Mobile_Boyer_Login(Map<String, Object> map) throws SQLException;
	/**
	 * 买家用户   买家信息表的添加
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	int insert_Boyer_Info(Map<String, Object> map) throws SQLException;
	
	/**
	 * 根据uuid查询buyer_id
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	int select_Buyer_Id(Map<String, Object> map) throws SQLException;
	/**
	 * 查询买家uuid 
	 * @param map
	 * @return false
	 * @throws SQLException
	 */
	boolean select_Byyer_Uuid(Map<String, Object> map) throws SQLException;
	/**
	 * 判断手机号是否被注册
	 * @param map
	 * @return true
	 * @throws SQLException
	 */
	public boolean select_buyer_mobile(Map<String, Object> map) throws SQLException ;
	/**
	 * 判断账号是否被注册
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public boolean select_buyer_login_account(Map<String, Object> map) throws SQLException;
}
