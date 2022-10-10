package beans;

import java.sql.Date;

public class Usuario {

    private String username;
    private String password;
    private String cedula;
    private String nombre;
    private String apellidos;
    private String correo;
    private Date fecha_nac;
    private int celular;
    private String rol;

    //Constructor

    public Usuario(String username, String password, String cedula, String nombre, String apellidos, String correo, Date fecha_nac, int celular, String rol) {
        this.username = username;
        this.password = password;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", password=" + password + ", cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", fecha_nac=" + fecha_nac + ", celular=" + celular + ", rol=" + rol + '}';
    }
    
}