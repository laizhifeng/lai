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
@WebServlet("/Tenant/TenantDeleteBatch")
public class TenantDeleteBatchServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr = request.getParameterValues("t_delete_batch");
		for(String i:arr){
			System.out.println(i);
		}
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TenantService tenantImpl = (TenantService) ac.getBean("tenantService");
		
		int rs = 0;
		try {
			rs = tenantImpl.deleteTenantBatch(arr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			response.getWriter().print(rs);
		}
	}

}
