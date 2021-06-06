
<%@page import="java.util.List"%>
<%@page import="ModeloCliente.MedicamentoCliente" %>
<%@page import="modeloservicio.ListarMedicamentos" %>
<%@page import="modeloservicio.Medicamento" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmacia UMG</title>
</head>

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
<script src="js/main.js"></script>
<body>
    
  
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
            <li class="list-inline-item nav-item"> <a href="sesiones.html" class="nav-link">Administracion</a> </li>
            <li class="list-inline-item nav-item"> <a href="productos.jsp" class="nav-link">Productos</a></li>
            <li class="list-inline-item nav-item"> <a href="carrito.html" class="nav-link">Carrito de compras</a> </li>
        </ul>
    </nav>


<section class="carrito">
   
    
        <div>
            <img src="images/med.png" alt="medicamento" class="carta med"> 
        </div>
            
        <div class="carta informacion">
            <h2>Informacion</h2>
           
            <% 
                int codigo = Integer.parseInt((String)request.getAttribute("Codigo"));
                System.out.println("El codigo en detalle.jsp es: " + codigo);
                
                Medicamento med = new MedicamentoCliente().listarcodigo(codigo);
            %>
            <ul>
               <li>Codigo: <%= med.getCodigo()%></li>
               <li>Medicamento: <%= med.getMedicamento()%></li>
               <li>Dosis: <%= med.getDosis()%></li>
               <li>Precio unitario: <%= med.getPrecioUnitario()%></li>
               <li>Cantidad Existencia: <%= med.getCantidadExistencia()%></li>
               <li>Laboratorio: <%= med.getLaboratorioFarmaceutico()%></li>
               <li>Vencimiento: <%= med.getVencimiento()%></li>
               <li>Presentacion: <%= med.getPresentacion()%></li>
           </ul>
        </div>
    
        <div class="carta checkout">
            <div>
                <form action="" method="">
                        <label for="cantidad">Cantidad</label>
                        <input type="number" name="cantidad" value="3">
                        <button class="btn btn-light btn-outline-dark"><a href="ManejoPeticiones.do?accion=venta&Codigo=<%= med.getCodigo()%>&Medicamento=<%= med.getMedicamento()%>&Cantidad=1&Precio_unitario=<%= med.getPrecioUnitario()%>">Comprar ahora</a></button>
                </form>
            </div>
            
        <div class="botones">
            <button class="boton"> <a href="./carrito.html">Agregar al carrito</a> </button>
            <button class="boton"><a href="./productos.jsp" class="link">Regresar a navegacion</a> </button>
        </div>
        
        <div class="pagos">
            <ul>
                <h3>Opciones de pago</h3>
                <li >Tarjeta de debito</li>
                <li >Tarjeta de credito</li>
                <li >Pago contra entrega</li>
            </ul>
        </div>
            
        </div>

  
</section>

<footer class="footer-1">
    <!-- Brand Start -->
 <div class="brand">

    <div class="container-fluid">
        <div class="brand-slider">
            <div class="brand-item"><img src="images/bayer.png" alt=""></div>
            <div class="brand-item"><img src="images/bonin.png" alt=""></div>
            <div class="brand-item"><img src="images/eurofarma.png" alt=""></div>
            <div class="brand-item"><img src="images/lamfer.png" alt=""></div>
            <div class="brand-item"><img src="images/lancasco.jpg" alt=""></div>
            <div class="brand-item"><img src="images/medpharma.png" alt=""></div>
            <div class="brand-item"><img src="images/pfizer.png" alt=""></div>
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

<script src="lib/slick.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>
</html>