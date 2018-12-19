package com.zy.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zy.Service.HouseService;
import com.zy.Service.UserService;
import com.zy.ServiceImpl.UserServiceImpl;
import com.zy.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		int rs = 0;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService flag = (UserService) ac.getBean("userService");
		
		rs = flag.Login(user);
		if (rs == 2 || rs == 3) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			if(rs == 2){
				session.setAttribute("status", "0");
			}
			if(rs == 3){
				session.setAttribute("status", "1");
			}
		}

		response.getWriter().print(rs);

	}

}
