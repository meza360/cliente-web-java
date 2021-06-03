/*
 * Copyright (C) 2021 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * @author Marvin Alonso Lemen Sanchez 090-17-99
 * @author GIOVANI DAVID MEZA POGGIO 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin 5990-18-4413
 * @author Byron Rosbin Antonio Orozco 9941-19-23685
 * @author Karina Aracely Sanchez Ixcot 9941-19-264
 */


package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GeneradorFactura.Cliente;
import GeneradorFactura.GeneradorPDF;
import ModeloCliente.OMedicamento;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import modeloservicio.InsertarArchivo;
import ModeloCliente.MedicamentoCliente;
import GeneradorFactura.GeneradorPDF;



@WebServlet(name = "ManejoPeticiones", urlPatterns = {"/ManejoPeticiones.do"})
public class ManejoPeticiones extends HttpServlet {

   String listarCodigo1 = "detalleMedicamentos.jsp";
   String insertarArchivo = "insercion.html";
   String venta = "facturacion.jsp";
   String venta2 = "index.html";
   
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");
            String acceso = "";
            
            if (accion.equals("listarcodigo")) {
                acceso = listarCodigo1;
                request.setAttribute("Codigo", request.getParameter("Codigo"));
                System.out.println("El metodo de la accion es: " + accion);
                System.out.println("Reenviando a la pagina: " + acceso);
            }
            else if(accion.equals("insertarArchivo"))
            {
                acceso = insertarArchivo;
                String ruta = request.getParameter("ruta");
                System.out.println("La ruta de el archivo en el web service:" + ruta);
                InsertarArchivo enlaceInsertar = new InsertarArchivo();
                enlaceInsertar.setRutaArchivo(ruta);
                MedicamentoCliente cl = new MedicamentoCliente();
                cl.insertarArchivo(enlaceInsertar.getRutaArchivo());
            }
            else if(accion.equals("venta")){
                acceso = venta;
                int codigo =  Integer.parseInt(request.getParameter("Codigo"));
                request.setAttribute("Codigo", codigo);
                String producto = request.getParameter("Medicamento");
                request.setAttribute("Medicamento", producto);
                int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                request.setAttribute("Cantidad", cantidad);
                double precio = Double.parseDouble(request.getParameter("Precio_unitario"));
                request.setAttribute("Precio_unitario", precio);
                
                
            }
            else if(accion.equals("facturar")){
                GeneradorPDF pdf = new GeneradorPDF();
                OMedicamento med = new OMedicamento();
                
                Cliente cl = new Cliente();
                String nombre = request.getParameter("txtNombre");
                System.out.println("El nombre para el cliente es: " + nombre);
                cl.setNombre(nombre);
                String nit = request.getParameter("txtNit");
                System.out.println("El nit para el cliente es: " + nit);
                cl.setNit(nit);
                
                acceso = venta2;
                int codigo =  Integer.parseInt(request.getParameter("Codigo"));
                request.setAttribute("Codigo", codigo);
                String producto = request.getParameter("Medicamento");
                request.setAttribute("Medicamento", producto);
                int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                request.setAttribute("Cantidad", cantidad);
                double precio = Double.parseDouble(request.getParameter("Precio_unitario"));
                request.setAttribute("Precio_unitario", precio);
                
                System.out.println("Los atributos en orden son: " + codigo + producto + cantidad + precio);
                
                MedicamentoCliente md = new MedicamentoCliente();
                md.ventaActualizar(codigo, cantidad);
                
                med.setCodigo(codigo);
                med.setCantidad(cantidad);
                med.setMedicamento(producto);
                med.setPrecio(precio);
                
                pdf.generatePdf(cl,med);
                
                System.out.println("La venta se realizo correctamente desde el cliente!");
   
            }
            else{
            accion = "index.html";
            }
            
            
            
            RequestDispatcher dispatcher =  request.getRequestDispatcher(acceso);
            dispatcher.forward(request, response);
        }catch(Exception error){
            System.out.println("Error en la peticion" + error);
            error.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        processRequest(request, response);
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
        try {
                //request.setAttribute("Codigo", request.getParameter("Codigo"));
                String ruta = request.getParameter("rutaArchivo");
                System.out.println("La ruta de el archivo en el web service:" + ruta);
                InsertarArchivo enlaceInsertar = new InsertarArchivo();
                enlaceInsertar.setRutaArchivo(ruta);
                MedicamentoCliente cl = new MedicamentoCliente();
                cl.insertarArchivo(enlaceInsertar.getRutaArchivo());
                System.out.println("Se logro insertar el archivo .csv");
                RequestDispatcher dispatcher = request.getRequestDispatcher(insertarArchivo);
                dispatcher.forward(request, response);
            
        } catch (Exception error) {
            System.out.println("Error en la ruta o archivo: " + error);
            error.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(insertarArchivo);
        processRequest(request, response);
    }
    
    protected void facturacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <OMedicamento> listaMedicamentos = new ArrayList<>();
        try {
            PrintWriter out = response.getWriter();
                    
            Cliente cl = new Cliente();
            cl.setNombre(request.getParameter("txtNombre"));
            cl.setNit(request.getParameter("txtNit"));
            
            OMedicamento medicina = new OMedicamento();
            medicina.setCodigo(Integer.parseInt(request.getParameter("Codigo")));
            medicina.setMedicamento(request.getParameter("Medicamento"));
            medicina.setCantidad(Integer.parseInt(request.getParameter("Cantidad")));
            medicina.setPrecio(Double.parseDouble(request.getParameter("Precio_unitario")));
            
            listaMedicamentos.add(medicina);
            
            
            out.println("La lista de medicina es: " + listaMedicamentos.toString());
            System.out.println("La lista de medicina es: " + listaMedicamentos.toString());
            
            
            GeneradorPDF facturacion = new GeneradorPDF();
            //facturacion.generatePdf();

            request.getRequestDispatcher("Index.html").forward(request,response);
        } catch (Exception error) {
            System.out.println("Error en la peticion de los datos: " + error);
            error.printStackTrace();
            request.getRequestDispatcher("Index.html").forward(request,response);
        }
        
        
        
       // processRequest(request, response);
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
