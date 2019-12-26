package cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.service;

import java.util.Map;

import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.pojo.JiaoLianInfo;




/**
 * @author sl
 * @version 1.0
 * @date 创建时间：2019年12月18日 上午11:00:09 
 */

public interface Service {
	
	
	/**
	 * 添加
	 * @param info
	 * @return
	 */
	public abstract Map<String , Object> add(JiaoLianInfo info);
	/**
	 * 删除
	 * @param map
	 * @return
	 */
	public abstract Map<String , Object> delete(Map<String,Object>map);
	/**
	 * 修改
	 * @param map
	 * @return
	 */
	public abstract Map<String, Object> update(Map<String, Object> map); 
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	public abstract  Map<String,Object> select(Map<String, Object> map);
}
