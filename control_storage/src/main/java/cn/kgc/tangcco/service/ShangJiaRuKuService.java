 package cn.kgc.tangcco.service;

import java.sql.SQLException;
import java.util.Map;

public interface ShangJiaRuKuService {
	
	
	/**
	 * 商家查看 自家仓库的货物               GoodsDaoImpl        selectgoods() 
	 */
	public Map<String,Object> ChaKanGoods(Map<String,Object>map);

	/**
	 * 开始检测入库    把所填信息 添加到 JianceDaoImpl表              insertChuKu           insertJianCeBiao（）
	 * @param map
	 * @return
	 * @throws SQLException 
	 */
	public Map<String, Object> KaiShiRuKu(Map<String,Object>map);
}