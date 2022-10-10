package beans;

import java.sql.Date;

public class HistorialActividad {

    private int id;
    private Date fecha;
    private String proceso;
    private String num_parte;
    private String username;

    public HistorialActividad(int id, Date fecha, String proceso, String num_parte, String username) {
        this.id = id;
        this.fecha = fecha;
        this.proceso = proceso;
        this.num_parte = num_parte;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getNum_parte() {
        return num_parte;
    }

    public void setNum_parte(String num_parte) {
        this.num_parte = num_parte;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "HistorialdeActividad{" + "id=" + id + ", fecha=" + fecha + ", proceso=" + proceso + ", num_parte=" + num_parte + ", username=" + username + '}';
    }

}
