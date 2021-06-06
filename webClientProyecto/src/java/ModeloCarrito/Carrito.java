
package ModeloCarrito;

/**
 *
 * @author Marvin Lemen
 */
public class Carrito {
    int item;
    int codigo;
    String Medicamento;
    int Cantidad;
    double Precio;
    double subTotal;
    
    
    
    public Carrito(int codigo, int item, String Medicamento, int Cantidad, double Precio, double subTotal){
            this.codigo = codigo;
            this.Medicamento = Medicamento;
            this.Cantidad = Cantidad;
            this.Precio = Precio;
            this.subTotal = subTotal;
            this.item = item;
            
    
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Carrito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMedicamento() {
        return Medicamento;
    }

    public void setMedicamento(String Medicamento) {
        this.Medicamento = Medicamento;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}
