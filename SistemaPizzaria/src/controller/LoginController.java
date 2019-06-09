package controller;

import dao.LoginDao;
import model.Usuario;

public class LoginController {
	LoginDao banco = new  LoginDao();
	
	
	public boolean validarLogin(String  usuario, String  senha) {
		Usuario u = new Usuario(usuario, senha);
		return banco.validarLogin(u);
	}
}
