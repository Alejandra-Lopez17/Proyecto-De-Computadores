package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Producto;
import connection.DBConnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProductoController implements IProductoController {

    @Override
    public String addProducto(String num_parte, String nombre, String categoria, int cantidad, String descripcion, Date fecha_in, double precio) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into producto values('" + num_parte + "', '" + nombre + "',  '" + categoria + "', '" + cantidad
                + "', '" + descripcion + "', '" + fecha_in + "', '" + precio + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Producto producto = new Producto(num_parte, nombre, categoria, cantidad, descripcion, fecha_in, precio);

            st.close();

            return gson.toJson(producto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from producto";

        if (ordenar == true) {
            sql += " order by nombre " + orden;
        }

        List<String> productos = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String num_parte = rs.getString("num_parte");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int cantidad = rs.getInt("cantidad");
                String descripcion = rs.getString("descripcion");
                Date fecha_in = rs.getDate("fecha_in");
                double precio = rs.getDouble("precio");

                Producto producto = new Producto(num_parte, nombre, categoria, cantidad, descripcion, fecha_in, precio);

                productos.add(gson.toJson(producto));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(productos);

    }

}
