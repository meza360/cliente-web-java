/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCliente;

import javax.xml.ws.WebServiceRef;
import java.util.List;
import modeloservicio.Medicamento;
import modeloservicio.Servicios_Service;


/**
 *
 * @author Marvin Alonso Lemen Sanchez 090-17-99
 * @author GIOVANI DAVID MEZA POGGIO 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin 5990-18-4413
 * @author Byron Rosbin Antonio Orozco 9941-19-23685
 * @author Karina Aracely Sanchez Ixcot 9941-19-264
 */

public class MedicamentoCliente {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/webServiceProyecto.wsdl")
    private Servicios_Service service;

    //@WebServiceRef(wsdlLocation = "WEB-INF/wsdl/webServiceProyecto.wsdl")
    //private Servicios_Service service;

    public MedicamentoCliente(){}

    public List<modeloservicio.Medicamento> listarMedicamentos() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        modeloservicio.Servicios_Service service = new modeloservicio.Servicios_Service();
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarMedicamentos();
    }

    private java.util.List<modeloservicio.Medicamento> listarLaboratorio(java.lang.String laboratorioFarmaceutico) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarLaboratorio(laboratorioFarmaceutico);
    }

    private java.util.List<modeloservicio.Medicamento> listarNombre(java.lang.String nombreMedicamento) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarNombre(nombreMedicamento);
    }

    private Medicamento listarcodigo(int codigo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        modeloservicio.Servicios port = service.getServiciosPort();
        return port.listarcodigo(codigo);
    }



 



    
    
}
