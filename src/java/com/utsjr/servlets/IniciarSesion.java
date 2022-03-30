/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsjr.servlets;

import com.utsjr.dao.Conexion;
import com.utsjr.modelos.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            
            HttpSession session=request.getSession();
            
            Conexion conexion=new Conexion();
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8090");
            response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,OPTIONS");
            response.setHeader("Access-Control-Allow-Credentials","true");
            
             String param1 = request.getParameter("usuario"),
                   param2 = request.getParameter("password");
             
            
             boolean isDataValid = conexion.isValidData(param1, param2);
			if(!isDataValid){
                                out.println("<script> alert('Error en el usuario o password'); </script>");
                                out.println("<a href='http://localhost:8090/ProyectoIOT/index.jsp'>Regresar</a>");
				//response.sendRedirect("index.html");
				//return;
			} else {
                            session.setAttribute("usu", param1);
                            response.sendRedirect("inicio.jsp");
                        }
               
            
                        if(request.getParameter("cerrar")!=null){
                            session.invalidate();
                        }
                        
                        
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
