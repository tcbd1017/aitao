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
 * @version 2019年12月18日
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Plan_Plan {
	/**
	 * 运动规划子表id
	 */
	private int id;
	
	/**
	 * 运动阶段子名称
	 */
	private String planname_name;
	
	/**
	 * 运动阶段子别名称
	 */
	private String planname_ename;
	
//	private Plan_Plan plan_plan;
}

