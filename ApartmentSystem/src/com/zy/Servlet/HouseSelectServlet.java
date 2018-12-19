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

import com.zy.Service.HouseService;
import com.zy.ServiceImpl.HouseServiceImpl;
import com.zy.entity.HouseSelect;

import net.sf.json.JSONArray;

@WebServlet("/House/HouseSelect")
public class HouseSelectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filed = request.getParameter("filed");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseService hs = (HouseService) ac.getBean("houseService");
		
		List<HouseSelect> houseList = new ArrayList<>();
		if (filed != "") {
			houseList = hs.HouseSelectByField(filed);
		} else {
			houseList = hs.HouseSelectAll();
		}
		if(houseList !=null){			
			JSONArray  json = JSONArray.fromObject(houseList);   
			String str = json.toString();               
			response.getWriter().print(str);
		}else{
			response.getWriter().print(0);
		}
	}

}
