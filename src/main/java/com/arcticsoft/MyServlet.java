package com.arcticsoft;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        String nombre;
        String texto = ", esta petición ha pasado por un filtro sin ser modificada.<br>Para que se modifique escribe como nombre 'filtrame'<br>";
        if (request.getAttribute("texto") != null) {
            texto = (String) request.getAttribute("texto");
            nombre = "";
        } else {
            nombre = request.getParameter("nombre");
            if (nombre.equals("")) nombre = " Anónimo";
            else nombre = " " + nombre;
        }
        printWriter.println("Hola" + nombre + texto);
        printWriter.println("<br>Que tengas un buen día!<br><br>");
        printWriter.write("<a href='/'>Volver al inicio</a>");
    }
}