package cn.kgc.tcbd1017.lixin.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpResponse;
import cn.kgc.tangcco.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tcbd1017.lixin.pojo.JianShen;
import cn.kgc.tcbd1017.lixin.service.JianShenService;
import cn.kgc.tcbd1017.lixin.service.impl.JianShenServiceImpl;

/**
 * 
 * @author 李鑫
 * @version 1.0<br>
  * 创建时间：2019年12月18日 上午10:49:08<br>
  *类描述：<br>
 *
 */
@WebServlet(urlPatterns = "/login.action")
public class JianShenManager extends BaseServlet{


	
     /**
	 * 
	 */
	private static final long serialVersionUID = -1452628264436416294L;
	private static JianShenService jianShenService = new JianShenServiceImpl();
 
	
     public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	 String username = request.getParameter("account");
    	 String password = request.getParameter("password");
    	 System.out.println("账号"+username);
    	 System.out.println("密码"+password);
       //String md5Hex = DigestUtil.md5Hex(password);
    	 JianShen jis = new JianShen(username, password);
    	 Map<String, Object> jianShenByAccountAndPAssword = jianShenService.getJianShenByAccountAndPAssword(jis);
    	 if (jianShenByAccountAndPAssword!=null && jianShenByAccountAndPAssword.size()>0) {
			System.out.println("登录成功");
			System.out.println(jianShenByAccountAndPAssword);
		}else {
			System.out.println("失败");
		}
//    	 switch (jianShenByAccountAndPAssword.get("status").toString()) {
//		case "success":
//			request.getRequestDispatcher("/main.jsp").forward(request, response);
//			break;
//
//		default:
//			request.setAttribute("loginMessage", "账号或者密码错误登录失败！！！");
//			request.getRequestDispatcher("/login.html").forward(request, response);
//			break;
//		}
//    	 JianShen jianShen2 = (JianShen) jianShenByAccountAndPAssword.get("jis");
//    	 System.out.println(jianShen2);
    	 printJson(response, jianShenByAccountAndPAssword);
//    	 request.getSession().setAttribute("jis", jianShen2);
    	 
    	 
     }
     /**
      * 退出返回主界面
      * @param request
      * @param response
      * @throws ServletException
      * @throws IOException
      */
     public void logout(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
 		request.getRequestDispatcher("/login.html").forward(request, response);
 	}
}
