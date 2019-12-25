package cn.kgc.tangcco.tcbd1017.shaoyansong.action;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.lihaozhe.commons.servlet.BaseServlet;
import cn.kgc.tangcco.lihaozhe.commons.spring.ClassPathXmlApplicationContext;
import cn.kgc.tangcco.tcbd1017.shaoyansong.service.PlanService;
import cn.kgc.tangcco.tcbd1017.shaoyansong.service.impl.PlanServiceImpl;

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

	public void getAll(HttpServletRequest request, HttpServletResponse response) {
		int dkid = Integer.parseInt(request.getParameter("dkid"));
		
		Map<String, Object> map = service.selectAll(dkid);
		printJson(response, map);
	}
	
	
	
	
	

	/**
	 * 查询运动规划父表
	 * @param request
	 * @param response
	 */
	public void selectPlan(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = service.selectPlan();
		printJson(response, map);
	}
	/**
	 * 查询运动规划子表
	 * @param request
	 * @param response
	 */
	public void selectPlan_Plan(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = service.selectPlan_Plan();
		printJson(response, map);
	}
	/**
	 * 查询运动规划父子中间表
	 * @param request
	 * @param response
	 */
	public void selectPlan_Plan_Middle(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = service.selectPlan_Plan_Middle();
		printJson(response, map);
	}
}
