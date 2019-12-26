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

public class Plan_Plan_Middle {
	/**
	 * 运动规划_中间表id
	 */
	private int id;
	
	/**
	 * 运动规划父表id
	 */
	private int plan_id;
	
	/**
	 * 运动规划子表id
	 */
	private int plan_plan_id;
	
	/**
	 * 运动方法孙子中间表id
	 */
	private int plan_plan_plan_middle_id;
	
//	private Plan_Plan plan_plan;
}
