package test;

import beans.Producto;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;//Para acceder a la base de datos 
import java.sql.Statement;//Para identidicar sentencias SQL

public class OperacionesDB {

    public static void main(String[] args) {
        actualizarProductos("'BLI357'", 150090);  //llamo la funcion para ejecutar el codigo y que se traiga los datos de la BD
        listarProductos();  //llamo la funcion para ejecutar el codigo y que se traiga los datos de la BD

    }

    public static void actualizarProductos(String num_parte, double precio) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE  producto SET  precio ='" + precio + "'WHERE num_parte =" + num_parte; //Sentencia que se guarda en el atributo sql
        try {

            Statement st = con.getConnection().createStatement();
            //Aqui esta linea esta diferente, le falta el Update (st.executeUpdate(sql);)
            st.executeUpdate(sql);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    }

    public static void listarProductos() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM producto";
        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String num_parte = rs.getString("num_parte");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int cantidad = rs.getInt("cantidad");
                String descripcion = rs.getString("descripcion");;
                Date fecha_in = rs.getDate("fecha_in");
                double precio = rs.getDouble("precio");

                Producto producto = new Producto(num_parte, nombre, categoria, cantidad, descripcion, fecha_in, precio);

                System.out.println(producto.toString());

            }
            //Aqui esta linea no esta
            st.executeQuery(sql);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    }

}
