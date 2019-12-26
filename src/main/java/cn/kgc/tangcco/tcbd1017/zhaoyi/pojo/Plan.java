package cn.kgc.tangcco.tcbd1017.zhaoyi.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title:pes-befiron-app</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c)2019</p>
 * <p>Company:sgai</p>
 * @author 邵岩松
 * @version 2019年12月18日
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Plan {
	/**
	 * 运动规划父表id
	 */
	private int id;
	
	/**
	 * 运动阶段名称
	 */
	private String planname;
	
	/**
	 * 运动阶段的时间周期
	 */
	private String plantime;
	
	/**
	 * 每周的运动频率
	 */
	private String Exercisef;
	
	/**
	 * 完成阶段运动的打卡总次数
	 */
	private int dksum;
	
	/**
	 * 友情提示
	 */
	private String accout;
	
//	private Plan_Plan plan_plan;
	private String planname_name;
	private String planname_ename;
	
	private int plan_plan_plan_middle_id;
}
