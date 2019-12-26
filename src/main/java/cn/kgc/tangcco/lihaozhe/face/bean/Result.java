/**
  * Copyright 2019 bejson.com 
  */
package cn.kgc.tangcco.lihaozhe.face.bean;
import java.util.List;

/**
 * Auto-generated: 2019-12-19 16:34:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result {

    private String face_token;
    private List<User_list> user_list;
    public void setFace_token(String face_token) {
         this.face_token = face_token;
     }
     public String getFace_token() {
         return face_token;
     }

    public void setUser_list(List<User_list> user_list) {
         this.user_list = user_list;
     }
     public List<User_list> getUser_list() {
         return user_list;
     }

}