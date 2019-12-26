package cn.kgc.tcbd1017.lixin.service.impl;
/**
 * 
 * @author 梅许
 * @version  1.1 
 *  2019年12月19日下午3:00:31
 *	类描述：	
 */

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.kgc.tangcco.lihaozhe.commons.jdbc.BaseDBUtils;
import cn.kgc.tcbd1017.lixin.dao.FaceDao;
import cn.kgc.tcbd1017.lixin.dao.impl.FaceDaoImpl;
import cn.kgc.tcbd1017.lixin.pojo.JianShen;
import cn.kgc.tcbd1017.lixin.service.FaceService;

public class FaceServiceImpl implements FaceService {
	private static FaceDao faceDao = new FaceDaoImpl();
	@Override
	public Map inertFace(int id, String face){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("status", "failed");
		try {
			int i = faceDao.inertFace(id, face);
			if (i>0) {
				map.put("status", "success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> getJianShenByFace(String face) {
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("status", "failed");
		JianShen jianShenByFace = null;
	try {
		jianShenByFace = faceDao.selectByFace(face);
	      if (jianShenByFace!=null) {
			map.put("status", "success");
			map.put("JianShen", jianShenByFace);
		}
	      BaseDBUtils.closeAll();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return map;
	}

}
