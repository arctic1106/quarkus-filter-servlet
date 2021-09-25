package com.arcticsoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletFilter implements Filter
{
	public void init(FilterConfig filterConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException
	{
		String nombre = request.getParameter("nombre");

		if (nombre != null && !nombre.equals("") && nombre.equals("filtrame"))
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.write("Esta petición ha sido filtrada, tu nombre ha sido ignorado :) <br>");
			printWriter.write("<a href='/'>Volver al inicio</a>");
		} 
		else
		{
			filterChain.doFilter(request, response);
			return;
		}
	}

	public void destroy() {}
}