package cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.lihaozhe.commons.jdbc.Laypage;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.pojo.JiaoLianInfo;
import cn.kgc.tangcco.tcbd1017.songlei.jianshen.src.main.java.cn.kgc.tangcco.tcbd1017.songlei.service.impl.ServiceImpl;


/**
 * Servlet implementation class Action
 */
@WebServlet(urlPatterns = "/jiaolian.action")
public class Action extends BaseServlet {

	private static final long serialVersionUID = 5533589509340681707L;
//	private static Service service;
//	static {
//		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		try {
//			service = (Service) classPathXmlApplicationContext.getBean(Service.class.getSimpleName());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	ServiceImpl service=new ServiceImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) {
			//String id = request.getParameter("id");
			String headimg = request.getParameter("headimg");
			String name = request.getParameter("name");
			String jlbname = request.getParameter("jlbname");
			String jlbaddress = request.getParameter("jlbaddress");
			String info = request.getParameter("info");
			String zhengshuname = request.getParameter("zhengshuname");
			String zhengshuimg = request.getParameter("zhengshuimg");
			String zhengshubanfadanwei = request.getParameter("zhengshubanfadanwei");
			String zhengshujieshao = request.getParameter("zhengshujieshao");
			Map<String, Object> map=service.add(new JiaoLianInfo("1",headimg, name, jlbname, jlbaddress, info, zhengshuname, zhengshuimg,zhengshubanfadanwei, zhengshujieshao));
			//request.setAttribute("add", map);
			printJson(response, map);

			
	}
	/**
	 * 删除
	 * @param request
	 * @param response
	 */
	public void delete(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map=new HashMap<String, Object>();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Map<String, Object> map1=new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map1=service.delete(map);
		printJson(response, map1);
	}
	/**
	 * 修改
	 * @param request
	 * @param response
	 */
	public void update(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map=new HashMap<String, Object>();
		String jiaolianid = request.getParameter("jiaolianid");
		String jiaolianname = request.getParameter("jiaolianname");
		String headimg = request.getParameter("headimg");
		String name = request.getParameter("name");
		String jlbname = request.getParameter("jlbname");
		String jlbaddress = request.getParameter("jlbaddress");
		String info = request.getParameter("info");
		String zhengshuname = request.getParameter("zhengshuname");
		String zhengshuimg = request.getParameter("zhengshuimg");
		String zhengshubanfadanwei = request.getParameter("zhengshubanfadanwei");
		String zhengshujieshao = request.getParameter("zhengshujieshao");
		map.put("id", jiaolianid);
		map.put("name",	 jiaolianname);
		map.put("headimg", headimg);
		map.put("newname", name);
		map.put("jlbname", jlbname);
		map.put("jlbaddress", jlbaddress);
		map.put("info", info);
		map.put("zhengshuimg", zhengshuimg);
		map.put("zhengshuname", zhengshuname);
		map.put("zhengshubanfadanwei", zhengshubanfadanwei);
		map.put("zhengshujieshao", zhengshujieshao);
		
		Map<String, Object> map2 = service.update(map);
		printJson(response, map2);
	}
	/**
	 * 查询
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map=new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		int limit =Integer.parseInt(request.getParameter("limit"));
		map.put("laypage", new Laypage(page, limit));
		Map<String, Object> map1=service.select(map);
//		request.setAttribute("select", list);
//		request.getRequestDispatcher("/jianshen.jsp").forward(request, response);
//		request.setCharacterEncoding("UTF-8");
		System.out.println(map1.toString());
		printJson(response, map1);
	}
}
