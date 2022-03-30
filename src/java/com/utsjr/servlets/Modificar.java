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
@WebServlet(name = "Modificar", urlPatterns = {"/Modificar"})
public class Modificar extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Color color=new Color();
            Conexion conexion=new Conexion();
            
          response.setHeader("Access-Control-Allow-Origin", "http://localhost:8090");
           response.setContentType("aplication/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,OPTIONS");
            response.setHeader("Access-Control-Allow-Credentials","true");
             //System.out.println("hola ");
             
             
             String json=conexion.bucarColorJson(request.getParameter("id"));
             
             out.print(json);
             
            
            
            /* String json2=conexion.editarColor(color);
             out.print(json2);*/
             
            
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
             response.setContentType("aplication/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,OPTIONS");
            response.setHeader("Access-Control-Allow-Credentials","true");
            
            color.setId(request.getParameter("idModificar"));
            color.setColor(request.getParameter("colorModificar"));
            color.setDescripcion(request.getParameter("descripcionModificar"));
            color.setImagen(request.getParameter("imagenModificar"));
            
            
             String json=conexion.editarColor(color);
             System.out.println("COLOR: "+request.getParameter("color"));
             System.out.println(json);
            
             //System.out.println("Datos editados");
           // response.sendRedirect("mostrarColores.jsp");
            out.print(json);
            
          
            
        }
         catch(Exception e){
            System.out.println("Error al modi: "+e);
        }
            
    }
    

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
