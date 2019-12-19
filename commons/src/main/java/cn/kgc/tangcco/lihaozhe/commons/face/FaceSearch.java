package cn.kgc.tangcco.lihaozhe.commons.face;

import java.util.HashMap;
import java.util.Map;

import cn.kgc.tangcco.lihaozhe.commons.faceUtils.GsonUtils;
import cn.kgc.tangcco.lihaozhe.commons.faceUtils.HttpUtil;




/**
* 人脸搜索
*/
public class FaceSearch {

    public static String faceSearch(String img) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            //String byteConverterBASE64 = Base64Util.byteConverterBASE64(new File("111.jpg"));
            map.put("image", img);
            map.put("liveness_control", "NORMAL");
            map.put("group_id_list","admin");
            map.put("image_type", "BASE64");
            map.put("quality_control", "NORMAL");
            String param = GsonUtils.toJson(map);
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();
            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
