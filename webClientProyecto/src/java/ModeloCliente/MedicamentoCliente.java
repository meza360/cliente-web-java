/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloCliente;

import javax.xml.ws.WebServiceRef;
import java.util.List;
import modeloservicio.Servicios_Service;


/**
 *
 * @author giova
 */
public class MedicamentoCliente {

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



 



    
    
}
