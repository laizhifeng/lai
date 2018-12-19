package com.zy.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.Service.TenantService;
import com.zy.ServiceImpl.TenantServiceImpl;

@WebServlet("/Tenant/DeleteTenant")
public class TenantDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int t_id = Integer.valueOf(request.getParameter("delete_t_id"));
		int h_id = Integer.valueOf(request.getParameter("delete_h_id"));
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TenantService tenantImpl = (TenantService) ac.getBean("tenantService");
		
		int rs = tenantImpl.deleteTenant(t_id, h_id);
		response.getWriter().print(rs);
	}
}
