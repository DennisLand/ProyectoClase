package com.Dennis.DAO;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Dennis.Conexion.ConexionBD;
import com.Dennis.Entidades.Usuario;

public class clsUsuarios {

	ConexionBD conexion = new ConexionBD();
	Connection con = conexion.RetornarConexion();
	
public ArrayList<Usuario> ListadoUSUARIOS() {
	ArrayList<Usuario> Lista = new ArrayList<>();

	try {

		CallableStatement consulta = con.prepareCall("call SP_S_SOLOUSUARIOS()");
		ResultSet rs = consulta.executeQuery();
		while (rs.next()) {
			Usuario user = new Usuario();
			user.setIdUsuario(rs.getInt("idUsuario"));
			user.setUsuario(rs.getString("Usuario"));
			user.setPass(rs.getString("PassWord"));
			user.setIdTipoUsuario(rs.getInt("tipoUsuario"));
			Lista.add(user);
		}
	} catch (Exception e) {
		// JOptionPane.showMessageDialog(null, "Ha ocurrido un error en: \n\n\n\n" + e);
	}

	return Lista;
}

public void EliminarUsuario(Usuario user) {
	try {
		CallableStatement consulta = con.prepareCall("call SP_D_USER(?)");
		consulta.setInt("PidUsuario", user.getIdUsuario());
		consulta.executeQuery();
		System.out.println("Eliminado Exitoso");
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}

public void ActualizarUsuario(Usuario user) {
	try {
		CallableStatement consulta = con.prepareCall("call SP_U_USUARIO(?,?,?)");
		consulta.setString("PUsuario", user.getUsuario());
		consulta.setString("PPass", user.getPass());
		consulta.setInt("PidUsuario", user.getIdUsuario());
		consulta.executeQuery();
		System.out.println("Actualizado Exitoso");
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}

public void AgregarUsuario(Usuario user) {
	try {
		CallableStatement consulta = con.prepareCall("call SP_I_USUARIO(?,?,?)");
		consulta.setString("PUsuario", user.getUsuario());
		consulta.setString("PPass", user.getPass());
		consulta.setInt("PTipoUsuario", user.getIdTipoUsuario());
		consulta.executeQuery();
		System.out.println("Agregado Exitoso");
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}
}
