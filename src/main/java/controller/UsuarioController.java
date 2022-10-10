package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String password) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where username = '" + username
                + "' and password = '" + password + "'";
        System.out.println(sql);
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                String correo = rs.getString("correo");
                Date fecha_nac = rs.getDate("fecha_nac");
                Integer celular = rs.getInt("celular");
                String rol = rs.getString("rol");

                Usuario usuario
                        = new Usuario(username, password, cedula, nombre, apellidos, correo, fecha_nac, celular, rol);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String addUsers(String username, String password,
            String cedula, String nombre, String apellidos,
            String correo, Date fecha_nac, Integer celular, String rol) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "', '" + password + "',  '" + cedula + "', '" + nombre
                + "', '" + apellidos + "', '" + correo + "', '" + fecha_nac + "',  '" + celular + "', '" + rol + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, password, cedula, nombre, apellidos, correo, fecha_nac, celular, rol);

            st.close();

            return gson.toJson(usuario);
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
        String sql = "Select * from pelicula";

        if (ordenar == true) {
            sql += " order by genero " + orden;
        }

        List<String> Usuario = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                
                String username = rs.getString("username");
                 String password = rs.getString("password");
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                String correo = rs.getString("correo");
                Date fecha_nac = rs.getDate("fecha_nac");
                Integer celular = rs.getInt("celular");
                String rol = rs.getString("rol");

                Usuario usuario
                        = new Usuario(username, password, cedula, nombre, apellidos, correo, fecha_nac, celular, rol);
                return gson.toJson(usuario);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(Usuario);

    }

}
