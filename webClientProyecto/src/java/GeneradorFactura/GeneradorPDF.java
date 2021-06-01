/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneradorFactura;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author giova
 */
public class GeneradorPDF {
    
    public GeneradorPDF(){}
    
        public static void generatePdf() throws IOException, PdfException{
    
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
            datosCliente.add("\nDatos del cliente: ");
            datosCliente.add("\nNombre: ");
            datosCliente.add("\nNIT: ");
            datosCliente.setAlignment(Paragraph.ALIGN_LEFT);
            datosCliente.setFont(FontFactory.getFont("Times New Roman", 12, Font.NORMAL,BaseColor.BLACK));

            //creacion de la tabla
            PdfPTable tabla = new PdfPTable(3);
            
            //tabla.setPaddingTop(20);
            tabla.setSpacingBefore(20);
            tabla.setSpacingAfter(20);
            tabla.addCell("Codigo");
            tabla.addCell("Producto");
            tabla.addCell("Precio");
            tabla.setKeepTogether(false);
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            tabla.addCell("122");tabla.addCell("Acetaminofen");tabla.addCell("54.24");
            
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
