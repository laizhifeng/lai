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

@WebServlet("/House/HouseAdd")
public class HouseAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String h_region = request.getParameter("h_region_add");
		String h_estate = request.getParameter("h_estate_add");
		String h_unitNumber = request.getParameter("h_unitNumber_add");
		String h_roomNo = request.getParameter("h_roomNo_add");
		String h_area = request.getParameter("h_area_add");
		String h_orientation = request.getParameter("h_orientation_add");
		String h_fitment = request.getParameter("h_fitment_add");
		Byte h_isDoubleAir = Byte.valueOf(request.getParameter("h_isDoubleAir_add"));
		int h_limit = Integer.valueOf(request.getParameter("h_limit_add"));
		String h_facility =request.getParameter("h_facility_add");
		double h_price = Double.valueOf(request.getParameter("h_price_add"));
		int h_status = Integer.valueOf(request.getParameter("h_status_add"));
		String h_img = request.getParameter("h_img_add");
		String h_address = request.getParameter("h_address_add");

		HouseInfo house = new HouseInfo();
		
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
			rs = hs.HouseInsert(house);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			response.getWriter().print(rs);
		}	
	}
}
