<%-- 
    Document   : EditarColor
    Created on : 22/02/2022, 09:27:27 PM
    Author     : Rodrigo
--%>
<%@page import="com.utsjr.modelos.Color"%>
<%@page import="com.utsjr.dao.Conexion"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Color</title>
    </head>
    <body>
       
         <%
        
        Conexion bd=new Conexion();
        String id=request.getParameter("id");
        Color color = bd.bucarColor(id);
        //String json=conexion.bucarColorJson(request.getParameter("id"));
        %>
        
         <div class="row mt-5">
        <div class="col-2"></div>
        <div class="col-8">
            <form class="row g-3" action="ModificarColor" method="POST">
                <h1>Modificar Color</h1>
                <input type="hidden" name="id" value="<%= color.getId()%>" />
                <div class="col-12">
                    <label for="inputAddress" class="form-label">Nombre del Color</label>
                    <input type="text" class="form-control"  name="color" id="color" placeholder="Nombre del color" value="<%= color.getColor()%>" >
                </div>
                <div class="col-md-12">
                    <label for="inputAddress" class="form-label">Descripción</label>
                    <input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Descripción" value="<%= color.getDescripcion()%>" >
                </div>

                <div class="col-md-12">
                    <label for="inputPassword4" class="form-label">Imagen</label>
                    <input type="text" class="form-control" name="imagen" id="imagen" placeholder="Imagen" value="<%= color.getImagen()%>" >
                </div>

                <div class="col-12">
                    <button class="btn btn-primary col-12" type="submit">Guardar datos</button>
                </div>
                </form>
        </div>
        <div class="col-2"></div>
        </div>
    </body>
</html>
