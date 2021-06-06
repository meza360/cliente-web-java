<%-- 
    Document   : carrito
    Created on : 5/06/2021, 11:05:57 PM
    Author     : Marvin Lemen
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmacia UMG</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-grid.css.map">
    <link rel="stylesheet" href="css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="css/bootstrap-grid.min.css.map">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap.css.map">
    <link rel="stylesheet" href="css/bootstrap-utilities.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="lib/slick.css">
    

   <script src="js/bootstrap.js"></script>
   <script src="js/bootstrap.bundle.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/bootstrap.esm.js"></script>
    </head>
    <body background="" class="">
  
    <header class="container header">
        <div class="container text-center" >
            <h1 class="h1 text-center">Farmacia Universidad Mariano Galvez de Guatemala</h1>
        </div>
       
        <div class="container">
            <img src="images/umg.png" alt="logo_umg" width="300" height="300" class="float-start">
            
            <img src="images/umg3.jpg" alt="farmacia" width="300" height="300" class="float-end">
        </div>
    </header>
        <footer class="footer-1">
    <!-- Brand Start -->
    <nav class=" container nav">
        <ul class="nav list-inline">
            <li class="list-inline-item nav-item"> <a href="index.html" class="nav-link">Inicio</a> </li>
            <li class="list-inline-item nav-item"> <a href="sesiones.jsp" class="nav-link">Administracion</a> </li>
            <li class="list-inline-item nav-item"> <a href="productos.jsp" class="nav-link">Productos</a></li>
            <li class="list-inline-item nav-item"> <a href="productos.jsp" class="nav-link">Seguir comprando</a> </li>
        </ul>
    </nav>
    <div class="container mt-4">
         <h3>Carrito</h3>
          <br>
        <div class="row">
            <div class="col-sm-8">
                <table class="table table-hover">
                 <thead>
                      <tr>
                           <th>ITEM</th>
                           <th>CODIGO</th>
                           <th>MEDICAMENTO</th>
                           <th>PRECIO</th>
                           <th>CANTIDAD</th>
                           <th>SUBTOTAL</th>
                           <th>ACCION</th>
                     </tr>
                </thead>
                <tbody>
                     <c:forEach var ="car" items ="${Carrito}">
                       <tr>
                         <td>${car.getItem()}</td>
                         <td>${car.getCodigo()}</td>
                         <td></td>
                         <td></td>
                         <td></td>
                         <td></td>
                         <td></td>
                       </tr>
                     </c:forEach>   
                   
                </tbody>
                    
                </table>
            </div>
            <br>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-header">
                        <h3>Generar Compra</h3>
                    </div>
                    <div class="card-body">
                        <label>Subtotal:</label>
                        <input type="text" readonly="" class="form-control">
                         <label>Descuento:</label>
                        <input type="text" readonly="" class="form-control">
                         <label>Total a pagar:</label>
                        <input type="text" readonly="" class="form-control">
                    </div>
                    <div class="card-footer">
                        <a href="#" class="btn btn-info btn-block">Realizar pago</a>
                        <a href="#" class="btn btn-danger btn-block">Generar compra</a>
                    </div>
                </div>
                
            </div>
        </div>  
    </div>  
   


<!-- Brand End --> 
</footer>

        <div class=" footer text-center">
    <div class="row footer-sintetico">
        <div class="col-lg-4 mb-5 mb-lg-0"><h2>Ubicanos</h2><p>Zona Portales<br>Zona 17<br>Guatemala</p></div>
        <div class="col-lg-4 mb-5 mb-lg-0"><h2>Nosotros en internet</h2><img src="images/face.png" alt="" class="social"><img src="images/insta.png" alt="" class="social"><img src="images/tw.png" alt="" class="social"><img src="images/whats.png" alt="" class="social"></div>
        <div class="col-lg-4 mb-5 mb-lg-0"><h2>Empresa</h2><p><a href="contacto.html" class="nav-link">Contacto</a> <br><a href="nosotros.html" class="nav-link">Quienes Somos</a></p></div>
    </div>
</div>
<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://java.sun.com/jstl/core"></script>
<script src="lib/slick.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
    </body>
</html>
