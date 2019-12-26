package cn.kgc.tcbd1017.lixin.dao;

import java.sql.SQLException;

import cn.kgc.tcbd1017.lixin.pojo.JianShen;



/**
 * 
 * @author 梅许
 * @version  1.1 
 *  2019年12月19日下午2:53:38
 *	类描述：	
 */
public interface FaceDao {
	
	int inertFace(int id,String face)throws SQLException;
	
	JianShen selectByFace(String face)throws SQLException;
}
