package cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.test;

import java.sql.SQLException;
import java.util.HashMap;

import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.dao.Dao;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.dao.impl.DaoImpl;



/**
 * @author sl
 * @version 1.0
 * @date 创建时间：2019年12月18日 下午2:45:20
 */

public class Test {
	public static void main(String[] args) {
		
		
//		Service service = new ServiceImpl();
//
//		JiaoLianInfo info1 = new JiaoLianInfo("时间简史", "刘", "我来自星星球", "宋磊", "", "最佳格斗奖", "11", "星星健身会所", "非常厉害");
//		if (service.add(info1).size() > 0) {
//			System.out.println("666");
//		} else {
//			System.out.println("111");
//		}

		/*
		 * Service service = new ServiceImpl(); Map<String, Object> map = new
		 * HashMap<String, Object>(); map.put("name", "熊"); Map<String, Object> map1 =
		 * new HashMap<String, Object>(); map1 = service.select(map); if
		 * (map1.get("list") != null && map1.size() > 0) {
		 * System.out.println(map1.get("list")); }
		 */
		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); JiaoLianInfo newinfo
		 * = new JiaoLianInfo("null", "小熊", "", "", "我来自星星", "最佳格斗奖", "null", "行行好",
		 * "assas"); map.put("id", "3"); map.put("name", "大熊"); map.put("newname",
		 * "二狗子"); map.put("zhengshuname", newinfo.getZhengshuname());
		 * map.put("headimg", "dsad"); map.put("info", "我来自小星"); map.put("jlbname",
		 * "ggbo"); map.put("jlbaddress", "dsasd"); map.put("zhengshuname", "最强格斗");
		 * map.put("zhengshuimg", "gaga"); map.put("zhengshubanfadanwei", "dada");
		 * map.put("zhengshujieshao", "牛逼就完了"); Map<String, Object> map1 =
		 * service.update(map); if (map1.get("status").equals("success") &&
		 * map1.get("status") != null) { System.out.println("成功了"); } else {
		 * System.out.println("失败了"); }
		 */
		/*
		 * Service service = new ServiceImpl(); Map<String, Object> map = new
		 * HashMap<String, Object>(); map.put("id", "3"); map.put("name", "二狗子");
		 * Map<String, Object> newmap = new HashMap<String, Object>(); newmap =
		 * service.delete(map); if (newmap.get("status").equals("success") &&
		 * newmap.get("status") != null) { System.out.println("删除成功了"); } else {
		 * System.out.println("删除失败"); }
		 */
		
		Dao dao = new DaoImpl();
		try {
			int i = dao.selectCount(new  HashMap<String, Object>());
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
