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
import com.zy.entity.TenantList;

import net.sf.json.JSONArray;

@WebServlet("/Tenant/SelectTenant")
public class TenantSelectServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field = request.getParameter("field");

		List<TenantList> list= new ArrayList<>();
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TenantService tenantImpl = (TenantService) ac.getBean("tenantService");
		
		if(field == "") {
			list = tenantImpl.selectAll();
		}else {
			list = tenantImpl.selectByField(field);
		}
		if(list != null) {
			JSONArray json = JSONArray.fromObject(list);
			response.getWriter().print(json.toString());
		}else {
			response.getWriter().print(0);
		}
	}
}
