package beans;

import java.sql.Date;

public class Producto {

    private String num_parte;
    private String nombre;
    private String categoria;
    private int cantidad;
    private String descripcion;
    private Date fecha_in;
    private double precio;

    //Consstructor
    public Producto(String num_parte, String nombre, String categoria, int cantidad, String descripcion, Date fecha_in, double precio) {
        this.num_parte = num_parte;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fecha_in = fecha_in;
        this.precio = precio;
    }

    public String getNum_parte() {
        return num_parte;
    }

    public void setNum_parte(String num_parte) {
        this.num_parte = num_parte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_in() {
        return fecha_in;
    }

    public void setFecha_in(Date fecha_in) {
        this.fecha_in = fecha_in;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "num_parte=" + num_parte + ", nombre=" + nombre + ", categoria=" + categoria + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", fecha_in=" + fecha_in + ", precio=" + precio + '}';
    }

}
