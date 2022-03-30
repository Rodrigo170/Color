<%-- 
    Document   : inicio
    Created on : 14/03/2022, 07:18:26 PM
    Author     : Rodrigo
--%>
<%@page import="java.util.List"%>
<%@page import="com.utsjr.modelos.Color"%>
<%@page import="com.utsjr.dao.Conexion"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Styles -->
    <link rel="stylesheet" href="css/menu.css">

    <!-- Google fonts -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,700&display=swap" rel="stylesheet">

    <!-- Ionic icons -->
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

    <title>Mostrar Colores</title>
    </head>
    <body>
        
     <div class="d-flex" id="content-wrapper">

        <!-- Sidebar -->
        <div id="sidebar-container" class="bg-primary">
            <div class="logo">
                <h4 class="text-light font-weight-bold mb-0">Color Sorter</h4>
                <h4 class="text-light font-weight-bold mb-0">Machine</h4>
            </div>
            <div class="menu">
                 <a href="inicio.jsp" class="d-block text-light p-3 border-0"><ion-icon name="stats-chart-outline"></ion-icon>
                    Estadísticas</a>

                <a href="mostrarColores.jsp" class="d-block text-light p-3 border-0"><ion-icon name="list-outline"></ion-icon>
                    Lista de colores</a>

                <a href="insertarColor.jsp" class="d-block text-light p-3 border-0"><ion-icon name="add-circle-outline"></ion-icon>
                    Insertar nuevo color</a>
               
                <a href="index.jsp?cerrar=true" class="d-block text-light p-3 border-0"><ion-icon name="lock-closed-outline"></ion-icon>
                    Cerrar Sessión</a>
            </div>
        </div>
        <div id="content" class="bg-light w-100">
            
            <section class="bg-light py-3">
                  <div class="container">
                      <div class="row">
                          <div class="col-lg-9 col-md-8">
                            <h1 class="font-weight-bold mb-0">Lista de Colores Registrados</h1>
                            <p class="lead text-muted">Información de los colores</p>
                          </div>
  
                      </div>
                  </div>
              </section>
              
          
             <section class="bg-light py-3">
                <div class="container">
                    <table class="table table-striped"> 
                    <thead>
                                    <th>Id</th>
                                    <th>Color</th>
                                    <th>Descripción</th>
                                    <th>Imagen</th>
                                    <th>Modificar</th>

                                    <th>Eliminar</th>
                                </thead>
                                <tbody>
                                    <%
                                        Conexion conexion=new Conexion();
                                        //Producto producto=new Producto();
                                        List<Color> lista=conexion.mostrarColores();
                                        for(int i=0; i<lista.size(); i++){
                                    %>
                                    <tr>
                                        <td><%= i+1%></td>
                                        <td><%= lista.get(i).getColor() %></td>
                                        <td><%= lista.get(i).getDescripcion() %></td>
                                        <td><img src="<%= lista.get(i).getImagen() %>" height="100"></td>
                                        <td><a type="button" class="btn btn-success" href="EditarColor.jsp?id=<%= lista.get(i).getId()%>">Editar</a></td>
                                        <td><a type="button" class="btn btn-danger" href="BorrarDato?id=<%= lista.get(i).getId()%>">Borrar</a></td>

                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody> 
                            </table>
                </div>
              </section>
                                        
             
        </div>                             
              
   
        
        
    </body>
    
    
</html>
