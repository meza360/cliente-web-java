<%-- 
    Document   : productos
    Created on : May 27, 2021, 11:48:20 PM
    Author     : giova
--%>

<%@page import="java.util.List" %>
<%@page import="ModeloCliente.MedicamentoCliente" %>
<%@page import="modeloservicio.Medicamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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

   <script src="js/bootstrap.js"></script>
   <script src="js/bootstrap.bundle.js"></script>
   <script src="js/bootstrap.bundle.min.js.map"></script>
   <script src="js/bootstrap.min.js"></script>
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



    <nav class=" container nav">
        <ul class="nav list-inline">
            <li class="list-inline-item nav-item"> <a href="index.html" class="nav-link">Inicio</a> </li>
            <li class="list-inline-item nav-item"> <a href="" class="nav-link">Quienes Somos</a> </li>
            <li class="list-inline-item nav-item"> <a href="productos.jsp" class="nav-link">Productos</a></li>
            <li class="list-inline-item nav-item"> <a href="contacto.html" class="nav-link">Contacto</a> </li>
            <li class="list-inline-item nav-item"> <a href="" class="nav-link">Carrito de compras</a> </li>
        </ul>
    </nav>


<section class="">

    <table class="table table-striped table-light container">
        <tr>
        <th>Codigo</th>
        <th>Medicamento</th>
        <th>Dosis</th>
        <th>Precio unitario</th>
        <th>Cantidad Existencia</th>
        <th>Laboratorio farmaceutico</th>
        <th>Vencimiento</th>
        <th>Presentacion</th>
        <th>Imagen</th>
        </tr>
        
        <%
            MedicamentoCliente medicamento_i = new MedicamentoCliente();
            List<Medicamento> medicamentos = new ModeloCliente.MedicamentoCliente().listarMedicamentos();
            for(Medicamento a:medicamentos) {
            
        %>

        <tr>
            <td><%= a.getCodigo() %> </td>
            <td><%= a.getMedicamento() %></td>
            <td><%= a.getDosis() %></td>
            <td><%= a.getPrecioUnitario() %></td>
            <td><%= a.getCantidadExistencia() %></td>
            <td><%= a.getLaboratorioFarmaceutico() %></td>
            <td><%= a.getVencimiento() %></td>
            <td><%= a.getPresentacion() %></td>
            <td> <img src="images/med.png" alt="fotografia_medicamento" width="50" height="50"> </td>
        </tr>
        <% } %>
    </table>

</section>
</body>
</html>