import java.util.ArrayList;

public class Local {
    private String nombre;
    private String direccion;
    private ArrayList<Producto> inventario;

    public Local(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.inventario = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Producto> getInventario() {
        return inventario;
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public void quitarProducto(Producto producto) {
        inventario.remove(producto);
    }

    public String toString() {
        return "Nombre: " + nombre + " | Dirección: " + direccion;
    }
}
