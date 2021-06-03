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

package ModeloCliente;

import javax.xml.ws.WebServiceRef;
import java.util.List;
import modeloservicio.Medicamento;
import modeloservicio.Servicios_Service;



public class MedicamentoCliente {

//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/webServiceProyecto.wsdl")
//    private Servicios_Service service;


    public MedicamentoCliente(){}

    public List<modeloservicio.Medicamento> listarMedicamentos() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        modeloservicio.Servicios_Service service = new modeloservicio.Servicios_Service();
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarMedicamentos();
    }

    public java.util.List<modeloservicio.Medicamento> listarLaboratorio(java.lang.String laboratorioFarmaceutico) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        System.out.println("El nombre del laboratorio a buscar es: " + laboratorioFarmaceutico);
        modeloservicio.Servicios_Service service = new modeloservicio.Servicios_Service();
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarLaboratorio(laboratorioFarmaceutico);
    }

    public java.util.List<modeloservicio.Medicamento> listarNombre(java.lang.String nombreMedicamento) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        System.out.println("El nombre del medicamento a buscar es: " + nombreMedicamento);
        modeloservicio.Servicios_Service service = new modeloservicio.Servicios_Service();
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarNombre(nombreMedicamento);
    }

    public modeloservicio.Medicamento listarcodigo(int codigo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        
        System.out.println("El codigo recibido en la clase listarCodigo es: " + codigo);
        modeloservicio.Servicios_Service service = new modeloservicio.Servicios_Service();
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarcodigo(codigo);
    }

    public Integer insertarArchivo(java.lang.String rutaArchivo) {
        System.out.println("La ruta indicada para el archivo es:" + rutaArchivo);
        modeloservicio.Servicios_Service service = new modeloservicio.Servicios_Service();
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.insertarArchivo(rutaArchivo);
    }

    public Integer ventaActualizar(int codigo, int cantidad) {
        modeloservicio.Servicios_Service service = new modeloservicio.Servicios_Service();
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.ventaActualizar(codigo, cantidad);
    }
    
    
    
    

}
