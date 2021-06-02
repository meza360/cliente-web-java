/*
 * Copyright (C) 2021 giova
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


public class ManejoPeticiones extends HttpServlet {

   String listarCodigo1 = "DetalleMedicamentos.jsp";
   
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = " ";String acceso = "";
            
            if (accion.equals("listarCodigo")) {
                acceso = listarCodigo1;
                request.setAttribute("Codigo", request.getParameter("Codigo"));
            }
        
            
            RequestDispatcher dispatcher =  request.getRequestDispatcher(acceso);
            dispatcher.forward(request, response);
        }catch(Exception error){
            
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
