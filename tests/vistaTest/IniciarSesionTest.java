package vistaTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Test;

import modelo.DataDummy;
import modelo.Jugador;
import viewmodel.SingletonDataDummy;
import vista.IniciarSesion;

public class IniciarSesionTest {

	@Test
	public void iniciarSesion_esUnUsuarioValido() {
		DataDummy dataDummy = SingletonDataDummy.getInstance();
		
		JTextField nombre = new JTextField();
		nombre.setText("cosme fulanito");
		JPasswordField contrasenia = new JPasswordField();
		contrasenia.setText("1234");
		
		IniciarSesion iniciarSesion = new IniciarSesion();
		iniciarSesion.setTextUsuario(nombre);
		iniciarSesion.setTextContrasenia(contrasenia);
		
		assertTrue(dataDummy.esUnUsuarioValido(nombre, contrasenia));
		
	}
	
	@Test
	public void iniciarSesion_noEsUnUsuarioValido() {
		DataDummy dataDummy = SingletonDataDummy.getInstance();
		
		JTextField nombre = new JTextField();
		nombre.setText("yo el mas kapo");
		JPasswordField contrasenia = new JPasswordField();
		contrasenia.setText("no tengo tiempo");
		
		IniciarSesion iniciarSesion = new IniciarSesion();
		iniciarSesion.setTextUsuario(nombre);
		iniciarSesion.setTextContrasenia(contrasenia);
		
		assertFalse(dataDummy.esUnUsuarioValido(nombre, contrasenia));
		
	}
}
