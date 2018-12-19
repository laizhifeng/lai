package com.zy.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class setCharacterEncodingFilter extends HttpServlet implements Filter{
	
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//拦截客户端请求
		//设置客户端请求参数内容编码，针对post请求
		String encode = filterConfig.getInitParameter("encode");
		if(encode == null || "".equals(encode.toString().trim())){
			encode = "UTF-8";
		}
		request.setCharacterEncoding(encode);
		//设置服务器相应内容编码
		response.setContentType("text/html;charset=" + encode);
		chain.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}