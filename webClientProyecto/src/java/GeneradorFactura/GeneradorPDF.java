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

package GeneradorFactura;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ModeloCliente.OMedicamento;




/**
 *
 * @author giova
 */
public class GeneradorPDF {

    
    
    private double total;
    
    public GeneradorPDF(){}
        
        public static void main(String[] args)  {
            //datos pára prueba
            List<OMedicamento> listaOMedicamento = new ArrayList<OMedicamento>();
            
            OMedicamento medicamento = new OMedicamento("Dolor", 10, 10.20);
            //double Cantidad = Double.parseDouble("10.20");
            //int Precio = Integer.parseInt("10");
            listaOMedicamento.add(medicamento);
            
            OMedicamento medicamento1 = new OMedicamento("gripe", 11, 13.50);
           // double Cantidad1 = Double.parseDouble("13.50");
            //int Precio1 = Integer.parseInt("11");
            listaOMedicamento.add(medicamento1);
            
            OMedicamento medicamento2 = new OMedicamento("fiebre", 5, 56.00);
            //double Cantidad2 = Double.parseDouble("56.00");
            //int Precio2 = Integer.parseInt("5");
            listaOMedicamento.add(medicamento2);
            
            System.out.println("lista tiene"+listaOMedicamento.size()+"agregado");
            
            
        
        }
    
    
    
        public void generatePdf(Cliente cliente, List<OMedicamento>lista) throws IOException, PdfException{
    
        try {
            // metodos de escritura del documento
            Document documento = new Document(PageSize.A4);
            PdfWriter.getInstance(documento, new FileOutputStream("Factura.pdf"));
            //imagen del encabezado
            Image encabezado = Image.getInstance(".\\src\\pdftest\\encabezado.png");
            encabezado.scaleToFit(595, 350);
            encabezado.setAlignment(Chunk.ALIGN_CENTER);
            
            //datos del cliente
            Paragraph datosCliente = new Paragraph();
            datosCliente.add("\nDatos del cliente");
            datosCliente.add("\nNombre: " + cliente.getNombre());
            datosCliente.add("\nNIT: " + cliente.getNit());
            datosCliente.setAlignment(Paragraph.ALIGN_LEFT);
            datosCliente.setFont(FontFactory.getFont("Times New Roman", 12, Font.NORMAL,BaseColor.BLACK));

            //creacion de la tabla
            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Codigo");
            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            
            for (int i = 0; i < lista.size(); i++) {
                tabla.addCell(""+ i);
                tabla.addCell(lista.get(i).getMedicamento());
                tabla.addCell(Double.toString(lista.get(i).getCantidad()));
                tabla.addCell(Double.toString(lista.get(i).getPrecio()));
           }
           
            //se crea el pie
            Image pie = Image.getInstance(".\\src\\pdftest\\pie.png");
            pie.scaleToFit(560, 300);
            pie.setAlignment(Chunk.ALIGN_BASELINE);
            
            //se escriben los cambios en el documento
            documento.open();
            
            documento.add(encabezado);
            documento.add(datosCliente);
            documento.add(tabla);
            documento.add(pie);
            
            documento.close();
            
            //BackgroundImage imagen = new BackgroundImage("");
            System.out.println("El documento ha sido creado exitosamente");   
            
        } catch (Exception error) {
            System.out.println("El error es el siguiente: " + error);
            error.printStackTrace();
        }
        
    }
    
}