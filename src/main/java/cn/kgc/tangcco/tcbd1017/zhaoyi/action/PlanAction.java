package cn.kgc.tangcco.tcbd1017.zhaoyi.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1017.zhaoyi.service.PlanService;
import cn.kgc.tangcco.tcbd1017.zhaoyi.service.impl.PlanServiceImpl;


/**
 * Servlet implementation class PlanAction
 */
@WebServlet("/plan.action")
public class PlanAction extends BaseServlet {
	private static final long serialVersionUID = -6664135964773991778L;
	
	
	private static PlanService service = new PlanServiceImpl();
	
	static {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		try {
			service = (PlanService) context.getBean(PlanService.class.getSimpleName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PlanAction() {
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//前台form表单里面的输入框 name = dkid
//		int dkid = (int)request.getAttribute("dkid");
//		System.out.println(dkid);
		Map<String, Object> map = service.selectPlan(23);
		request.setAttribute("map", map);
		request.setAttribute("dkid", 23);
		forword(request, response, subfix("/index"));
		
	}
	
	protected void addPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planname = request.getParameter("planname");
		String plantime = request.getParameter("plantime");
		String Exercisef = request.getParameter("Exercisef");
		String dksum = request.getParameter("dksum");
		String accout = request.getParameter("accout");
		
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("planname", planname);
		map.put("plantime", plantime);
		map.put("Exercisef", Exercisef);
		map.put("dksum", dksum);
		map.put("accout", accout);
		Map<String, Object> addPlan = service.addPlan(map);
		printJson(response,addPlan );
		
	}

	
	protected void addPlan_Plan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planname_name = request.getParameter("planname_name");
		String palnname_ename = request.getParameter("palnname_ename");

		Map<String, Object> map =new HashMap<String, Object>();
		map.put("planname_name", planname_name);
		map.put("palnname_ename", palnname_ename);
		Map<String, Object> addPlan_Plan = service.addPlan_Plan(map);
		printJson(response,addPlan_Plan );
		
	}
	
	
	protected void addPlan_plan_plan_middle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plan_id = request.getParameter("plan_id");
		String plan_plan_id = request.getParameter("plan_plan_id");
		String plan_plan_plan_middle_id = request.getParameter("plan_plan_plan_middle_id");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("plan_id", plan_id);
		map.put("plan_plan_id", plan_plan_id);
		map.put("plan_plan_plan_middle_id", plan_plan_plan_middle_id);
		Map<String, Object> addPlan_plan_plan_middle = service.addPlan_plan_plan_middle(map);
		printJson(response,addPlan_plan_plan_middle );
		
	}
	protected void UpdatePlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planname = request.getParameter("planname");
		String plantime = request.getParameter("plantime");
		String Exercisef = request.getParameter("Exercisef");
		String dksum = request.getParameter("dksum");
		String accout = request.getParameter("accout");
		
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("planname", planname);
		map.put("plantime", plantime);
		map.put("Exercisef", Exercisef);
		map.put("dksum", dksum);
		map.put("accout", accout);
		Map<String, Object> addPlan = service.UpdatePlan(map);
		printJson(response,addPlan );
	}
}
