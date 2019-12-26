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

public class Xldz {
	/**
	 * 热身动作表id
	 */
	private int id;
	
	/**
	 * 动作名称（3到5个动作）
	 */
	private String dzname;
	
	/**
	 * 动作说明
	 */
	private String dzjieshao;
	
	/**
	 * 动作图片或者视频
	 */
	private String url;
	
	/**
	 * 注意事项编号id
	 */
	private int did;

	/**
	 * @param dzname
	 * @param dzjieshao
	 * @param url
	 * @param did
	 */
	public Xldz(String dzname, String dzjieshao, String url, int did) {
		super();
		this.dzname = dzname;
		this.dzjieshao = dzjieshao;
		this.url = url;
		this.did = did;
	}
	
}
