package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ProductoController;
import java.sql.Date;

/**
 * Servlet implementation class ServletUsuarioRegister
 */
@WebServlet("/ServletProductoRegister")
public class ServletProductoRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductoRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        ProductoController producto = new ProductoController();

        String num_parte = request.getParameter("num_parte");
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String descripcion = request.getParameter("descripcion");
        Date fecha_in = Date.valueOf(request.getParameter("fecha_in"));
        double precio = Double.parseDouble(request.getParameter("precio"));      
        
        


        String result = producto.addProducto(num_parte, nombre, categoria, cantidad, descripcion, fecha_in, precio);

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