package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;
import java.sql.Date;

/**
 * Servlet implementation class ServletUsuarioRegister
 */
@WebServlet("/ServletUsuarioRegister")
public class ServletUsuarioRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        UsuarioController usuario = new UsuarioController();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        Date fecha_nac = Date.valueOf(request.getParameter("fecha_nac"));
        Integer celular = Integer.parseInt(request.getParameter("celular"));
        String rol = request.getParameter("rol");

        String result = usuario.addUsers(username, password, cedula, nombre, apellidos, correo, fecha_nac, celular, rol);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}