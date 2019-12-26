package cn.kgc.tcbd1017.lixin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 李鑫
 * @version 1.0<br>
  * 创建时间：2019年12月18日 上午10:14:05<br>
  *类描述：<br>
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JianShen {
       private int id;
       private String username;
       private String password;
       private int power;
       
       public JianShen(String username, String password) {
   		super();
   		this.username = username;
   		this.password = password;
   	}
}
