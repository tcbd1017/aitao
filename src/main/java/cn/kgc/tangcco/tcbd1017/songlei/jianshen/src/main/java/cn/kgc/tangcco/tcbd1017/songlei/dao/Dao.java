package cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.pojo.JiaoLianInfo;




/**
 * @author sl
 * @version 1.0
 * @date 创建时间：2019年12月18日 上午11:04:47 
 */

public interface Dao {
	/**
	 * 添加
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	public abstract int add(JiaoLianInfo info) throws SQLException;
	/**
	 * 删除
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public int delete( Map<String, Object> map ) throws SQLException;
	/**
	 *  修改
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public int update(Map<String, Object> map) throws SQLException;
	/**
	 * 查询
	 * @return
	 * @throws SQLException
	 */
	public List<JiaoLianInfo> select(Map<String, Object> map)throws SQLException;
	/**
	 * 
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public List<JiaoLianInfo> selectAll(Map<String, Object> map)throws SQLException;
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public abstract int selectCount(Map<String,Object> map) throws SQLException;
	
}
