package cn.kgc.tcbd1017.lixin.action;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.lihaozhe.face.FaceAdd;
import cn.kgc.tangcco.lihaozhe.face.FaceDetect;
import cn.kgc.tangcco.lihaozhe.face.FaceSearch;
import cn.kgc.tangcco.lihaozhe.face.bean.JsonRootBean;
import cn.kgc.tcbd1017.lixin.service.FaceService;
import cn.kgc.tcbd1017.lixin.service.impl.FaceServiceImpl;


/**
 * 
 * @author 李鑫
 * @version  1.1 
 *  2019年12月19日下午2:06:03
 *	类描述：	
 */
@WebServlet(urlPatterns = "face.action")
public class FaceAction extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5397290936725139331L;
	private static FaceDetect faceDetect = new FaceDetect();
	private static FaceAdd faceAdd = new FaceAdd();
	private static FaceSearch faceSearch = new FaceSearch();
	private static FaceService faceService = new FaceServiceImpl();

		
	public void faceDetect(HttpServletRequest request,HttpServletResponse response) {
		String img = request.getParameter("img");
		System.out.println("第一句话");
		System.out.println("******************"+img+"+++++++++++++++++++++++++++");
		System.out.println("第二句话");
		System.out.println(img);
		String string = faceDetect.faceDetect(img, "BASE64");
		System.out.println(string);
		System.out.println("det"+string);
		printJson(response, string);
	}
	 public void faceAdd(HttpServletRequest request,HttpServletResponse response) {
		 String img = request.getParameter("img");
		 String username = request.getParameter("username");
		 int id = Integer.parseInt(request.getParameter("id"));
//			System.out.println(img);
			String string = faceAdd.add(img, "BASE64",""+id);
			if (string.indexOf("\"error_code\":0")!=-1) {
				Map map = faceService.inertFace(id, ""+id);
				printJson(response, map);
			}
	}	
	 
	 public void faceSearch(HttpServletRequest request,HttpServletResponse response) {
		 String img = request.getParameter("img");
		 String string = faceSearch.faceSearch(img, "BASE64");
		 System.out.println("查询结果"+string);
		 JsonRootBean bean = JSON.parseObject(string, JsonRootBean.class);
		 String info = bean.getResult().getUser_list().get(0).getUser_info();
		 System.out.println("info"+info);
		 Map<String, Object> map = faceService.getJianShenByFace(info);
		 printJson(response, map);
	 }
	 
	 
}
