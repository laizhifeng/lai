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

import com.zy.Service.HouseService;
import com.zy.ServiceImpl.HouseServiceImpl;

@WebServlet("/House/HouseDeleteBatch")
public class HouseDeleteBatchServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr = request.getParameterValues("h_delete_batch");
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseService hs = (HouseService) ac.getBean("houseService");
	
		int rs = 0;
		try {
			rs = hs.HouseDeleteBatch(arr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			response.getWriter().print(rs);
		}
	}

}
