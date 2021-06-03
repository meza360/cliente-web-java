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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ManejoBusqueda", urlPatterns = {"/ManejoBusqueda.do"})
public class ManejoBusqueda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acceso = "busqueda.jsp";
        try {
            int metodo = Integer.parseInt(request.getParameter("selMed"));
         
            if (metodo == 1) {
                request.setAttribute("metodo", metodo);
                int codigo = Integer.parseInt(request.getParameter("buscador"));
                request.setAttribute("Codigo", codigo);
                
                acceso = "busqueda.jsp";
                System.out.println("El metodo seleccionado es: " + metodo);
                System.out.println("El parametro de busqueda es: " + codigo);
                System.out.println("Reenviando a la pagina: " + acceso);
         
            }else if(metodo == 2){
                request.setAttribute("metodo", metodo);
                String medicamento = request.getParameter("buscador");
                request.setAttribute("Medicamento", medicamento);
                
                acceso = "busqueda.jsp";
                System.out.println("El metodo seleccionado es: " + metodo);
                System.out.println("El parametro de busqueda es: " + medicamento);
                System.out.println("Reenviando a la pagina: " + acceso);
                
            }else if(metodo == 3){
                request.setAttribute("metodo", metodo);
                String laboratorio = request.getParameter("buscador");
                request.setAttribute("Laboratorio", laboratorio);
                
                acceso = "busqueda.jsp";
                System.out.println("El metodo seleccionado es: " + metodo);
                System.out.println("El parametro de busqueda es: " + laboratorio);
                System.out.println("Reenviando a la pagina: " + acceso);
               
            }else
            {
            acceso = "index.html";
            }
         
                RequestDispatcher dispatch = request.getRequestDispatcher(acceso);
                dispatch.forward(request, response);
                //processRequest(request,response);
        } catch (Exception error) {
            System.out.println("Error en la adquicision de metodos: " + error);
            acceso = "index.html";
            RequestDispatcher dispatch = request.getRequestDispatcher(acceso);
                dispatch.forward(request, response);
            //processRequest(request,response);
            error.printStackTrace();
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
       
           RequestDispatcher dispatcher = request.getRequestDispatcher("busqueda.jsp");
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
