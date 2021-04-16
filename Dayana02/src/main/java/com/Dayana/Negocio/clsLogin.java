package com.Dayana.Negocio;

import com.Dayana.Entidades.*;
import com.Dayana.DAO.*;

public class clsLogin {

	public int acceso(Usuario log) {
		int acceso = 0;
		clsLoginBD clsLoginBD = new clsLoginBD();
		Usuario user = new Usuario();
		
		user = clsLoginBD.ValidarLogin(log);
		if (user != null) {
			if (user.getTipoUsuario() == 1) {
				acceso = 1;
				System.out.println(user.getTipoUsuario());
			} else if (user.getTipoUsuario() == 2) {
				acceso = 2;
				System.out.println(user.getTipoUsuario());
			}
		} else {
			System.out.println("El usuario no existe");
		}
		return acceso;
	}
}
