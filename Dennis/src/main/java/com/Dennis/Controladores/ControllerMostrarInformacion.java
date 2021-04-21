package com.Dennis.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dennis.DAO.clsUsuarios;
import com.Dennis.Entidades.Usuario;
import com.google.gson.Gson;

/**
 * Servlet implementation class ControllerMostrarInformacion
 */
@WebServlet("/ControllerMostrarInformacion")
public class ControllerMostrarInformacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerMostrarInformacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String Evaluar = request.getParameter("Eliminar");

		String Agregar = request.getParameter("Guardar");

		String IdUsuario = request.getParameter("IdUsuario");
		String Usuario = request.getParameter("Usuario");
		String Password = request.getParameter("Pass");

		Usuario usu = new Usuario();
		clsUsuarios clsusuario = new clsUsuarios();

		if (Evaluar != null) {
			if (Evaluar.equals("btne")) {
				usu.setIdUsuario(Integer.parseInt(IdUsuario));
				clsusuario.EliminarUsuario(usu);
				response.sendRedirect("Saludo.jsp");
			}
		}
		else if(Agregar.equals("btna")) {
			usu.setUsuario(Usuario);
			usu.setPass(Password);
			usu.setIdTipoUsuario(2);
			System.out.println(IdUsuario);
			
			if(IdUsuario == "" || IdUsuario == null) {			
				clsusuario.AgregarUsuario(usu);
				response.sendRedirect("Saludo.jsp");
			}
			else {
				usu.setIdUsuario(Integer.parseInt(IdUsuario));
				clsusuario.ActualizarUsuario(usu);
				response.sendRedirect("Saludo.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		Gson json = new Gson();

		clsUsuarios clsusuario = new clsUsuarios();
		response.getWriter().append(json.toJson(clsusuario.ListadoUSUARIOS()));
	}

}

