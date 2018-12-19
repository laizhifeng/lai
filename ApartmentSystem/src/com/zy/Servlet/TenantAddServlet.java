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
import com.zy.Service.UserService;
import com.zy.ServiceImpl.TenantServiceImpl;
import com.zy.entity.Tenant;

@WebServlet("/Tenant/AddTenant")
public class TenantAddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t_name = request.getParameter("add_t_name");
		String t_phone = request.getParameter("add_t_phone");
		String t_sex = request.getParameter("add_t_sex");
		String t_native = request.getParameter("add_t_native");
		String t_IDnumber = request.getParameter("add_t_IDnumber");
		int h_id = Integer.valueOf(request.getParameter("add_h_id"));
		
		Tenant tenant = new Tenant();
		tenant.setT_name(t_name);
		tenant.setT_phone(t_phone);
		tenant.setT_sex(t_sex);
		tenant.setT_native(t_native);
		tenant.setT_IDnumber(t_IDnumber);
		tenant.setH_id(h_id);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TenantService tenantImpl = (TenantService) ac.getBean("tenantService");
		
		int rs = tenantImpl.addTenant(tenant);
		response.getWriter().print(rs);
	}
	
}
