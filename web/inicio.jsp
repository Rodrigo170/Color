<%-- 
    Document   : inicio
    Created on : 14/03/2022, 07:18:26 PM
    Author     : Rodrigo
--%>
<%@page import="com.utsjr.dao.Conexion"%>
<%@page session="true"%>
<%@page import="com.utsjr.modelos.Admin"%>
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

    <title>Inicio</title>
    </head>
    <body>
         <%
            
            Conexion conexion=new Conexion();
         
            
            
            int n=conexion.contadorColores();
            int amarillo=conexion.contadorAmarillo();
            int rojo=conexion.contadorRojo();
            int azul=conexion.contadorAzul();
            int naranja=conexion.contadorNaranja();
            
            

            %>
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
        <div id="content" class="bg-grey w-100">

              <section class="bg-light py-3">
                  <div class="container">
                      <div class="row">
                          <div class="col-lg-9 col-md-8">
                            <h1 class="font-weight-bold mb-0">Bienvenido <%= session.getAttribute("usu")%></h1>
                            <p class="lead text-muted">Revisa la última información</p>
                          </div>
  
                      </div>
                  </div>
              </section>
           
             <section class="bg-mix py-3">
                <div class="container">
                    <div class="card rounded-0">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-lg-3 col-md-6 d-flex stat my-3" style="background-color: #34495E">
                                    <div class="mx-auto" style="color: white">
                                        <h6>Objetos Capturados</h6>
                                        
                                        <h3 class="font-weight-bold"><%= n%></h3>
                                        
                                    </div>
                                </div>
                                        <div class="col-lg-3 col-md-6 d-flex stat my-3" style="background-color: #FFC300">
                                    <div class="mx-auto" style="color: white">
                                        <h6>Color Amarrillo</h6>
                                        <h3 class="font-weight-bold"><%= amarillo%></h3>
                                        
                                    </div>
                                </div>
                                    <div class="col-lg-3 col-md-6 d-flex stat my-3" style="background-color: #E41111">
                                    <div class="mx-auto" style="color: white">
                                        <h6>Color Rojo</h6>
                                        <h3 class="font-weight-bold"><%= rojo%></h3>
                                        
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6 d-flex my-3" style="background-color: #11BEE4">
                                    <div class="mx-auto" style="color: white">
                                        <h6 >Color Azul</h6>
                                        <h3 class="font-weight-bold"><%= azul%></h3>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
              </section>
                                        
              <section>
                  <div class="container">
                      <div class="row">
                          <div class="col-lg-8 my-3">
                              <div class="card rounded-0">
                                  <div class="card-header bg-light">
                                    <h6 class="font-weight-bold mb-0">Número de colores capturados por la cámara</h6>
                                  </div>
                                  <div class="card-body">
                                    <canvas id="myChart" width="300" height="150"></canvas>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </section>
        </div>                             
              
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js" integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI=" crossorigin="anonymous"></script>
        <script>
            var ctx = document.getElementById('myChart').getContext('2d');
            var myChart = new Chart(ctx, { 
                type: 'bar',
                data: {
                    labels: ['Naranja', 'Amarillo', 'Rojo', 'Azul'],
                    datasets: [{
                        label: 'Colores',
                        data: [<%= naranja%>, <%= amarillo%>, <%= rojo%>, <%= azul%>],
                        backgroundColor: [
                            '#FF950E',  
                            '#FFDA0E',
                            '#FF0E0E',
                            '#0EE2FF'
                        ],
                        maxBarThickness: 30,
                        maxBarLength: 2
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
            </script>

        
        
    </body>
    
    
</html>
