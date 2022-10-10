package controller;

import java.util.Map;
import java.sql.Date;

public interface IUsuarioController {
    
    public String login(String username, String password);
    
    public String addUsers(String username, String password,
            String cedula, String nombre, String apellidos,
            String correo, Date fecha_nac, Integer celular, String rol);
    
     public String listar(boolean ordenar, String orden);
    
}
