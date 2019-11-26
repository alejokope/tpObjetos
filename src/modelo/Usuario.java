package modelo;

import javax.swing.*;

public class Usuario {

    private Jugador jugador;
    private String contrasenia;

    public Usuario(Jugador jugador, String contrasenia) {
        this.jugador = jugador;
        this.contrasenia = contrasenia;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public String getContrasenia() {
        return contrasenia;
    }


    public boolean esElMismoUsuario(JTextField nombreIngresadoTextField, JPasswordField contraseniaIngresadaTextField) {
        return esElMismoNombre(nombreIngresadoTextField) && esLaMismaContrasenia(contraseniaIngresadaTextField);
    }

    public boolean esLaMismaContrasenia(JPasswordField contraseniaIngresadaTextField) {
        return new String(contraseniaIngresadaTextField.getPassword()).equals(contrasenia);
    }

    public boolean esElMismoNombre(JTextField nombreIngresadoTextField) {
        return nombreIngresadoTextField.getText().equals(jugador.getNombre());
    }
}
