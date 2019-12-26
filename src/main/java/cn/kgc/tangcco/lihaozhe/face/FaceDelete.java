package cn.kgc.tangcco.lihaozhe.face;

import java.io.File;
import java.util.*;


/**
* 人脸注册
*/
public class FaceDelete {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String delete() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/delete";
        try {
            Map<String, Object> map = new HashMap<>();
            String string = Base64Util.byteConverterBASE64( new File("i.jpg"));
            map.put("user_id", "group01");
            map.put("group_id", "faceLogin");
           map.put("face_token", "2dcd5bcb514c4f8201e8bffc20ef892e");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.58d3fadbed59129dfe556a5998961a4d.2592000.1579489701.282335-18021981";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println("add"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
   	 String string = delete();
   	 System.out.println(string);
   	
   }

}