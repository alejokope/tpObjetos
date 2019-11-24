package modelo;

import javax.swing.*;
import java.util.Arrays;

public class Usuario {

    private String nombre;
    private String contrasenia;

    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean esElMismoUsuario(JTextField nombreIngresadoTextField, JPasswordField contraseniaIngresadaTextField) {
        return nombreIngresadoTextField.getText().equals(nombre) && new String(contraseniaIngresadaTextField.getPassword()).equals(contrasenia);
    }
}
