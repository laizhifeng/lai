package com.zy.Servlet;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/Tenant/UpdateTenant")
public class TenantUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int t_id = Integer.valueOf(request.getParameter("update_t_id"));
		String t_name = request.getParameter("update_t_name");
		String t_phone = request.getParameter("update_t_phone");
		String t_sex = request.getParameter("update_t_sex");
		String t_native = request.getParameter("update_t_native");
		String t_IDnumber = request.getParameter("update_t_IDnumber");
		int h_id = Integer.valueOf(request.getParameter("update_h_id"));
		
		Tenant tenant = new Tenant();
		tenant.setT_id(t_id);
		tenant.setT_name(t_name);
		tenant.setT_phone(t_phone);
		tenant.setT_sex(t_sex);
		tenant.setT_native(t_native);
		tenant.setT_IDnumber(t_IDnumber);
		tenant.setH_id(h_id);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TenantService tenantImpl = (TenantService) ac.getBean("tenantService");
		
		int rs = 0;
		try {
			rs = tenantImpl.updateTenant(tenant);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().print(rs);

	}
}
