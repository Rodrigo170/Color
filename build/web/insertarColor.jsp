<%-- 
    Document   : inicio
    Created on : 14/03/2022, 07:18:26 PM
    Author     : Rodrigo
--%>
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

    <title>Insertar Color</title>
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
                                <h1 class="font-weight-bold mb-0">Insertar Nuevo Color</h1>
                                <p class="lead text-muted">Registro de un nuevo color</p>
                              </div>

                          </div>
                      </div>
                  </section>

                 <section class="bg-light py-3">
                    <div class="container">
                        <div class="row mt-5">
            <div class="col-2"></div>
            <div class="col-8">
                <form class="row g-3" action="InsertarDato" method="POST">
                    <h1>Registrar Color</h1>
                    <div class="col-12">
                        <label for="inputAddress" class="form-label">Nombre del Color</label>
                        <input type="text" class="form-control" name="color" id="color" placeholder="Nombre del color">
                    </div>
                    <div class="col-md-12">
                        <label for="inputAddress" class="form-label">Descripción</label>
                        <input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Descripción">
                    </div>

                    <div class="col-md-12">
                        <label for="inputPassword4" class="form-label">Imagen</label>
                        <input type="text" class="form-control" name="imagen" id="imagen" placeholder="Imagen">
                    </div>

                    <div class="col-12">
                        <button class="btn btn-primary col-12" type="submit">Guardar datos</button>
                    </div>
                    </form>
            </div>
            <div class="col-2"></div>
            </div>
                </div>
              </section>
                                        
             
        </div>                             
             
        
        
    </body>
    
    
</html>
