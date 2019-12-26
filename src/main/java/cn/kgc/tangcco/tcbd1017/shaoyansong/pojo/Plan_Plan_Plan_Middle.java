package cn.kgc.tangcco.tcbd1017.shaoyansong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月20日
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Plan_Plan_Plan_Middle {
	/**
	 *运动方法孙子中间表id
	 */
	private int id;
	
	/**
	 * 打卡次数id
	 */
	private int dkid;
	
	/**
	 * 热身动作id
	 */
	private int rsid;
	
	/**
	 * 激活动作id
	 */
	private int jhid;
	
	/**
	 * 训练动作id
	 */
	private int xlid;
	
	/**
	 * 拉伸动作id
	 */
	private int lsid;
	
	/**
	 * 有氧动作id
	 */
	private int yyid;

	/**
	 * @param rsid
	 * @param jhid
	 * @param xlid
	 * @param lsid
	 * @param yyid
	 */
	public Plan_Plan_Plan_Middle(int rsid, int jhid, int xlid, int lsid, int yyid) {
		super();
		this.rsid = rsid;
		this.jhid = jhid;
		this.xlid = xlid;
		this.lsid = lsid;
		this.yyid = yyid;
	}
	

}
