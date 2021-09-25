package com.arcticsoft;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MyServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();

		String nombre = request.getParameter("nombre");
		if (nombre != null && !nombre.equals("")) printWriter.print("Hola " + nombre + ", esta petición no ha sido filtrada. <br> Para que pase por el filtro escribe como nombre 'filtrame' <br>");
		else printWriter.print("Hola 'Anónimo', esta petición no ha sido filtrada. Para que pase por el filtro escribe como nombre 'filtrame' <br>");
		printWriter.print("Que tengas un buen día <br>");
		printWriter.write("<a href='/'>Volver al inicio</a>");
	}
}