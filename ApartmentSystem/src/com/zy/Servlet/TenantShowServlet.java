package com.zy.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.Service.TenantService;
import com.zy.ServiceImpl.TenantServiceImpl;
import com.zy.entity.Tenant;

import net.sf.json.JSONArray;

@WebServlet("/Tenant/ShowTenant")
public class TenantShowServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int t_id= Integer.valueOf(request.getParameter("t_id"));
		List<Tenant> list = new ArrayList<>();
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TenantService tenantImpl = (TenantService) ac.getBean("tenantService");
		
		list = tenantImpl.showTenantInfo(t_id);
		
		if(list != null) {
			JSONArray json = JSONArray.fromObject(list);
			response.getWriter().print(json.toString());
		}else {
			response.getWriter().print(0);
		}
	}

}
