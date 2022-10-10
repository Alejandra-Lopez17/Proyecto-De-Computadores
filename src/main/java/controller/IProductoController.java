package controller;

import java.util.Map;
import java.sql.Date;

public interface IProductoController {

    public String addProducto(String num_parte, String nombre, String categoria, int cantidad, String descripcion, Date fecha_in, double precio);
    public String listar(boolean ordenar, String orden);

}
