package cn.kgc.tangcco.lihaozhe.face;

import java.io.File;
import java.util.*;



/**
* 人脸注册
*/
public class FaceAdd {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String add(String image,String image_type,String username) {
        // 请求url
    	UUID uuid = UUID.randomUUID();
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<>();
            String string = Base64Util.byteConverterBASE64(new File("i.jpg"));
            map.put("image", image);
            map.put("group_id", "faceLogin");
            map.put("user_id", "group01");
            map.put("user_info", username);
            map.put("liveness_control", "NORMAL");
            map.put("image_type", image_type);
            map.put("quality_control", "LOW");

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
   

}