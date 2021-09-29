package com.arcticsoft;

import java.io.IOException;
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
		response.setContentType("text/html;charset=UTF-8");

		String nombre = request.getParameter("nombre");
		if ((nombre == null) || nombre.equals("filtrame")) request.setAttribute("texto", ", esta petición ha sido filtrada y/o los parámetros se han ignorado :)<br>");
		filterChain.doFilter(request, response);
		
		return;
	}

	public void destroy() {}
}