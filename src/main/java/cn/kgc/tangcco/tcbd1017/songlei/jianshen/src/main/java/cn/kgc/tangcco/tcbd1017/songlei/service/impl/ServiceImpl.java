package cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.dao.impl.DaoImpl;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.pojo.JiaoLianInfo;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.service.Service;




/**
 * @author sl
 * @version 1.0
 * @date 创建时间：2019年12月18日 上午11:00:45 ；
 * 
 */

public class ServiceImpl implements Service{
//	private static Dao dao;
//	static {
//		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		try {
//			dao = (Dao) classPathXmlApplicationContext.getBean(Dao.class.getSimpleName());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	DaoImpl dao=new DaoImpl();
	/**
	 * 添加
	 */
	@Override
	public Map<String, Object> add(JiaoLianInfo info) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		int add;
		try {
			BaseDBUtils.startTransaction();
			add = dao.add(info);
			if (add >0) {
				map.put("code", 1);
				map.put("status", "success");
				BaseDBUtils.commitAndClose();
			}
		} catch (SQLException e) {
			try {
				BaseDBUtils.rollbackAndClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return map;
	}
	/**
	 * 删除
	 */
	@Override
	public Map<String, Object> delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "	");
		result.put("status", "failed");
		try {
			int del = dao.delete(map);
			if (del>0) {
				result.put("code", 1);
				result.put("status", "success");
				BaseDBUtils.closeAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
		/**
		 * 修改
		 */
	@Override
	public Map<String, Object> update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "failed");
		try {
			BaseDBUtils.startTransaction();
			int upd = dao.update(map);
			if (upd==1) {
				result.put("status", "success");
				BaseDBUtils.commitAndClose();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 查询
	 */
	@Override
	public Map<String, Object> select(Map<String, Object> map) {
		Map<String, Object> empMap = new LinkedHashMap<String, Object>();
		// layui初始化参数
		empMap.put("code", 0);
		empMap.put("msg", "");
		empMap.put("count", 0);
		empMap.put("data", new ArrayList<JiaoLianInfo>());
		try {
			int count = dao.selectCount(map);
			if (count > 0) {
				// 如果员工总数大于零，则将员工总数存储在map中返回
				empMap.put("count", count);
				// 如果员工总数大于零则调用持久层方法查询员工简略信息列表
				List<JiaoLianInfo> data = dao.select(map);
				if (data != null) {
					// 如果该部门下员工简略信息列表部位空则将员工简略信息列表存储在map中返回
					empMap.put("data", data);
				}
			}}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return empMap;
	}
}



