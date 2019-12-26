package cn.kgc.tcbd1017.lixin.service;

import java.sql.SQLException;
import java.util.Map;



/**
 * 
 * @author 梅许
 * @version  1.1 
 *  2019年12月19日下午2:57:31
 *	类描述：	
 */
public interface FaceService {
	
	
	Map inertFace(int id,String face);
	public abstract Map<String, Object> getJianShenByFace(String face);
}
