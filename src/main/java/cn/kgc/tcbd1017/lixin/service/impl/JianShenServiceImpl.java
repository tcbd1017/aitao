package cn.kgc.tcbd1017.lixin.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tcbd1017.lixin.dao.JianShenDao;
import cn.kgc.tcbd1017.lixin.dao.impl.JianShenDaoImpl;
import cn.kgc.tcbd1017.lixin.pojo.JianShen;
import cn.kgc.tcbd1017.lixin.service.JianShenService;

/**
 * 
 * @author 李鑫
 * @version 1.0<br>
  * 创建时间：2019年12月18日 上午10:23:32<br>
  *类描述：<br>
 *
 */
public class JianShenServiceImpl implements JianShenService{
          private static JianShenDao jianshen1 = new JianShenDaoImpl();
       
		@Override
		public Map<String, Object> getJianShenByAccountAndPAssword(JianShen jianshen) {
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("status", "failed");
			JianShen jianShenByAccountAndPassword = null;
		try {
			jianShenByAccountAndPassword = jianshen1.getJianShenByAccountAndPassword(jianshen);
		      if (jianShenByAccountAndPassword!=null) {
				map.put("status", "success");
				map.put("JianShen", jianShenByAccountAndPassword);
			}
		      BaseDBUtils.closeAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return map;
		}
	
  

}
