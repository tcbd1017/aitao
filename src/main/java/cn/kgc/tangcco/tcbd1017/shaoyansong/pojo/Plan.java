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
	
	/**
	 * 运动阶段子名称
	 */
	private String planname_name;
	
	/**
	 * 运动阶段子别名称
	 */
	private String planname_ename;
	
	/**
	 * 运动方法孙子中间表id
	 */
	private int plan_plan_plan_middle_id;
	
	private Plan_Plan_Plan_Middle plan_plan_plan_middle;
	
	private Rsdz rsdz;
	private Xldz xldz;
	private Lsdz lsdz;
	private Jhdz jhdz;
	private Yydz yydz;
	/**
	 * @param id
	 * @param planname
	 * @param plantime
	 * @param exercisef
	 * @param dksum
	 * @param accout
	 */
	public Plan(int id, String planname, String plantime, String exercisef, int dksum, String accout) {
		super();
		this.id = id;
		this.planname = planname;
		this.plantime = plantime;
		Exercisef = exercisef;
		this.dksum = dksum;
		this.accout = accout;
	}
	
	
	
}
