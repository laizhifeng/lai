package com.zy.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ReourceFilter  implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//拦截客户端请求
		//对请求与相应对象进行类型转换，参考HttpServlet的service()方法
		HttpServletRequest request;
		HttpServletResponse response;
		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;
		} catch (Exception e) {
			throw new ServletException("non-HTTP request or response");
		}
		
		//获取请求url地址
		String uri = request.getRequestURI();//应用名+资源访问路径
		
		if(request.getSession().getAttribute("status") == "0"){
			if(uri.contains("Show") || uri.contains("Select")){
				chain.doFilter(request, response);
			}else{
				JSONObject json = new JSONObject();
	            json.accumulate("message", "false");
	            response.getWriter().print(json.toString()); 
			}
		}	
		if(request.getSession().getAttribute("status") == "1"){
			
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
	}
}

