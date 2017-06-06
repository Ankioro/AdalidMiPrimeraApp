

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dni.Dni;

/**
 * Servlet implementation class LetraDNI
 */
@WebServlet("/LetraDNI")
public class LetraDNI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetraDNI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ndni = request.getParameter("dni");
		
		//System.out.println("DNI = " + ndni);
		
		int dni = Integer.parseInt(ndni);
		char letra = Dni.calculaLetra(dni);
		
		DniBean dnibean = new DniBean();
		dnibean.setDni(ndni);
		dnibean.setLetra(letra);
		
		request.setAttribute("dnibean", dnibean);
		//Con esto referenciamos al html resultado.jsp
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
		
		//response.getWriter().print("Tu DNI completo es " + ndni + "-" + letra + "</ br>");
		
		//response.getWriter().print("<h1>Hola dni " + ndni + "</h1>" + "</ br>");
		//response.getWriter().print("<p>Hola dni " + ndni + " " + "esto es un párrafo" +  "</p>");
		response.setStatus(202);//Comprobar los status en google es buena idea.
		//append("Served at: ").append(request.getContextPath());
		
		//Con esto hacemos que se trate el html como texto plano
		//Consultar los tipos MIME en google
		//response.setContentType("text/plain");
	}
	
	//http://localhost:8080/MiAppWeb/LetraDNI?dni=05334488

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
