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

@WebServlet("/House/HouseUpdate")
public class HouseUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int h_id = Integer.valueOf(request.getParameter("update_h_id"));
		String h_region = request.getParameter("update_h_region");
		String h_estate = request.getParameter("update_h_estate");
		String h_unitNumber = request.getParameter("update_h_unitNumber");
		String h_roomNo = request.getParameter("update_h_roomNo");
		String h_area = request.getParameter("update_h_area");
		String h_orientation = request.getParameter("update_h_orientation");
		String h_fitment = request.getParameter("update_h_fitment");
		byte h_isDoubleAir = Byte.valueOf(request.getParameter("update_h_isDoubleAir"));
		int h_limit = Integer.valueOf(request.getParameter("update_h_limit"));
		String h_facility =request.getParameter("update_h_facility");
		double h_price = Double.valueOf(request.getParameter("update_h_price"));
		int h_status = Integer.valueOf(request.getParameter("update_h_status"));
		String h_img = request.getParameter("update_h_img");
		String h_address = request.getParameter("update_h_address");
		HouseInfo house = new HouseInfo();
		house.setH_id(h_id);
		house.setH_region(h_region);
		house.setH_estate(h_estate);
		house.setH_unitNumber(h_unitNumber);
		house.setH_roomNo(h_roomNo);
		house.setH_area(h_area);
		house.setH_orientation(h_orientation);
		house.setH_fitment(h_fitment);
		house.setH_isDoubleAir(h_isDoubleAir);
		house.setH_limit(h_limit);
		house.setH_facility(h_facility);
		house.setH_price(h_price);
		house.setH_status(h_status);
		house.setH_img(h_img);
		house.setH_address(h_address);
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseService hs = (HouseService) ac.getBean("houseService");
		
		int rs = 0;
		try {
			rs = hs.HouseUpdata(house);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			response.getWriter().print(rs);
		}	
	}

}
