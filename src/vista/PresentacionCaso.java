package vista;

import modelo.BaseDeDatos;
import modelo.Caso;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentacionCaso extends JFrame {
    private JPanel contentPane;
    private BaseDeDatos baseDeDatos;
    private Caso caso;


    public PresentacionCaso (){
        baseDeDatos = new BaseDeDatos();
        caso = baseDeDatos.obtenerCasoAlAzar();

        setTitle(caso.getObjeto());
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA
        setBounds(500, 500, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Label subTitulo = new Label("Detective [NOMBRE DETECTIVE], tenemos un caso para usted!" );
        subTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        subTitulo.setBounds(20, 20, 600, 22);
        contentPane.add(subTitulo);

        Label reporte = new Label(caso.getReporte());
        reporte.setFont(new Font("Arial", Font.BOLD, 14));

        reporte.setBounds(30, 60, 600, 25);
        contentPane.add(reporte);
        //TODO METER EN LAYOUT PARA CENTRAR
        JButton elegirOtro = new JButton("Elegir otro");
        elegirOtro.setBounds(30, 100,225,40);
        elegirOtro.setFont(new Font("Arial",Font.BOLD,12));
        elegirOtro.setHorizontalAlignment(SwingConstants.CENTER);
        elegirOtro.setVerticalAlignment(SwingConstants.CENTER);

        elegirOtro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PresentacionCaso presentacionCaso = new PresentacionCaso();
                setVisible(false);
                presentacionCaso.setVisible(true);
            }
        } );



        contentPane.add(elegirOtro);

        JButton aceptarCaso = new JButton("Aceptar el caso");
        aceptarCaso.setBounds(300, 100,225,40);
        aceptarCaso.setFont(new Font("Arial",Font.BOLD,12));
        aceptarCaso.setHorizontalAlignment(SwingConstants.CENTER);
        aceptarCaso.setVerticalAlignment(SwingConstants.CENTER);
        aceptarCaso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResolviendoCaso resolviendoCaso = new ResolviendoCaso(caso);
                setVisible(false);
                resolviendoCaso.setVisible(true);
            }
        });
        contentPane.add(aceptarCaso);


    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PresentacionCaso frame = new PresentacionCaso();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
