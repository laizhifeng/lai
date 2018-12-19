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
import com.zy.entity.HouseInfo;

import net.sf.json.JSONArray;

@WebServlet("/House/ShowHouse")
public class HouseShowServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int h_id = Integer.valueOf(request.getParameter("h_id"));
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseService hs = (HouseService) ac.getBean("houseService");
		
		HouseInfo houseList = new HouseInfo();
		
		try {
			houseList = hs.ShowSouseInfo(h_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray  json = JSONArray.fromObject(houseList);   
		String str = json.toString();               
		response.getWriter().print(str);
	}

}
