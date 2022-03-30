/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsjr.servlets;

import com.utsjr.dao.Conexion;
import com.utsjr.modelos.Color;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "InsertarDato", urlPatterns = {"/InsertarDato"})
public class InsertarDato extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
             try (PrintWriter out = response.getWriter()) {
           
         
             }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Color color=new Color();
            Conexion conexion=new Conexion();
              response.setHeader("Access-Control-Allow-Origin", "http://localhost:8090");
            response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,OPTIONS");
            response.setHeader("Access-Control-Allow-Credentials","true");

            color.setColor(request.getParameter("color"));
            color.setDescripcion(request.getParameter("descripcion"));
            color.setImagen(request.getParameter("imagen"));
            
            conexion.insertarColor(color);
             System.out.println("Datos insertados");
             String json=conexion.insertarColor(color);
            
            out.print(json);
            response.sendRedirect("mostrarColores.jsp");
            
            
        } catch(Exception ex){
            System.out.println("Error: "+ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
