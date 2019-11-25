package vista;

import modelo.DataDummy;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesion extends JFrame {

    private DataDummy dataDummy = new DataDummy();
    private JPanel iniciarSesionPanel;
    private JPasswordField contraseniaIngresadaTextField;
    private JButton aceptarButton;
    private JTextField nombreIngresadoTextField;

    public static void main(String[] args) {
        IniciarSesion iniciarSesion = new IniciarSesion();

    }

    public IniciarSesion(){
        setTitle("Ingrese sus datos, detective.");
        setContentPane(iniciarSesionPanel);
        setLocation(400,300);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if(dataDummy.esUnUsuarioValido(nombreIngresadoTextField, contraseniaIngresadaTextField)){
                    dataDummy.setJugadorAsignado(dataDummy.obtenerJugadorAsignado(nombreIngresadoTextField));
                    PantallaDeInicio pantallaDeInicio = new PantallaDeInicio(dataDummy.getJugadorAsignado());
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(iniciarSesionPanel,"Debe ingresar un usuario valido!");
                }
            }
        });
    }
}
