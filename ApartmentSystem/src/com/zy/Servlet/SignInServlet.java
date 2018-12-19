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

import com.zy.Service.UserService;
import com.zy.ServiceImpl.UserServiceImpl;
import com.zy.entity.User;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String pw_second = request.getParameter("pw_second");
		
		User user = new User(username, password);
		int rs;
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService flag = (UserService) ac.getBean("userService");
		
		if (password.equals(pw_second)) {
			rs = flag.SignIn(user);
		}else{
			rs = 2;
		}
		if(rs==1){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("status", "0");
		}
		response.getWriter().print(rs);
	}
}
