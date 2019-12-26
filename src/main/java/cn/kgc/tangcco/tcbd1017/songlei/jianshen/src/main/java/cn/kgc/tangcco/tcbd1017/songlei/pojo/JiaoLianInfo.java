package cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sl
 * @version 1.0
 * @date 创建时间：2019年12月18日 上午10:54:24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JiaoLianInfo {
	/**
	 * 教练id
	 */
	private String id;
	/**
	 * 教练头像
	 */
	private String headimg;
	/**
	 * 教练姓名
	 */
	private String name;
	/**
	 * 教练介绍
	 */
	private String info;
	/*
	 * 俱乐部名字
	 */
	private String jlbname;
	/**
	 * 俱乐部地址
	 */
	private String jlbaddress;
	/**
	 * 证书名字
	 */
	private String zhengshuname;
	/**
	 * 证书图片
	 */
	private String zhengshuimg;
	/**
	 * 证书颁发单位
	 */
	private String zhengshubanfadanwei;
	/**
	 * 证书介绍
	 */
	private String zhengshujieshao;
}
