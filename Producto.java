package sistema.inventarios;

public class Producto {
    private String tipo;
    private String nombre;
    private double precio; // Asegurar que el precio es de tipo double

    public Producto(String tipo, String nombre, double precio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() { // Método correctamente implementado
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
