package vista;

import modelo.BaseDeDatos;
import modelo.CarmenSanDiegoMaster;
import modelo.Caso;
import modelo.Jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;


public class PresentacionCaso extends JFrame {
    private JPanel contentPane;
    private BaseDeDatos baseDeDatos;
    private Caso caso;
    private CarmenSanDiegoMaster carmenSanDiegoMaster;


    public PresentacionCaso (){
    	setIconImage(Toolkit.getDefaultToolkit().getImage(PresentacionCaso.class.getResource("/imagenes/iconosombrero.png")));
        baseDeDatos = new BaseDeDatos();
        caso = baseDeDatos.obtenerCasoAlAzar();
        carmenSanDiegoMaster = new CarmenSanDiegoMaster();
        carmenSanDiegoMaster.setJugador(new Jugador(caso));
        carmenSanDiegoMaster.setVillano(caso.getResponsable());
        carmenSanDiegoMaster.setCaso(caso);
        
        setTitle(caso.getObjeto());
        //TODO FIJARSE FORMA DE CENTRAR EN EL MEDIO DE LA PANTALLA
        setBounds(500, 500, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel pTitulo = new JPanel();
        pTitulo.setBounds(5, 5, 672, 38);
        contentPane.add(pTitulo);
                pTitulo.setLayout(null);
        
                Label subTitulo = new Label("Detective [NOMBRE DETECTIVE], tenemos un caso para usted!" );
                subTitulo.setForeground(new Color(255, 204, 0));
                subTitulo.setBackground(new Color(102, 51, 153));
                subTitulo.setBounds(88, 5, 495, 28);
                pTitulo.add(subTitulo);
                subTitulo.setFont(new Font("Arial", Font.BOLD, 16));
                
                JLabel labelP = new JLabel("");
                labelP.setBounds(0, 0, 750, 200);
                pTitulo.add(labelP);
                labelP.setIcon(new ImageIcon(PresentacionCaso.class.getResource("/imagenes/fondo3.png")));
                labelP.setPreferredSize(new Dimension(500, 1000));
        
        JPanel pCentro = new JPanel();
        pCentro.setBounds(5, 43, 672, 274);
        pCentro.setBorder(null);
        contentPane.add(pCentro);
                pCentro.setLayout(new BorderLayout(0, 0));
                
                JPanel pReporte = new JPanel();
                pReporte.setForeground(Color.WHITE);
                pReporte.setBorder(new EmptyBorder(10, 10, 10, 10));
                pCentro.add(pReporte, BorderLayout.CENTER);
                pReporte.setLayout(null);
                
                JLabel lReporte = new JLabel(caso.getReporte());
                lReporte.setForeground(Color.CYAN);
                lReporte.setBorder(new EmptyBorder(10, 10, 10, 10));
                lReporte.setBounds(-1559, 5, 3770, 16);
                pReporte.add(lReporte);
                pReporte.setFont(new Font("Arial", Font.BOLD, 14));
                
                
                /*Label reporte = new Label(caso.getReporte());
                contentPane.add(reporte, BorderLayout.WEST);
                reporte.setFont(new Font("Arial", Font.BOLD, 14));*/
        
        JLabel lFondo= new JLabel("");
        lFondo.setPreferredSize(new Dimension(1000, 1000));
        lFondo.setSize(new Dimension(1000, 1000));
        lFondo.setBounds(0, 0,684,343);
        pReporte.add(lFondo);
        lFondo.setIcon(new ImageIcon(PresentacionCaso.class.getResource("/imagenes/fondo6.png")));
        
        JPanel pPie = new JPanel();
        pPie.setBounds(5, 317, 672, 33);
        contentPane.add(pPie);
        pPie.setLayout(null);
        //TODO METER EN LAYOUT PARA CENTRAR
        JButton elegirOtro = new JButton("Elegir otro");
        elegirOtro.setBounds(227, 5, 91, 23);
        pPie.add(elegirOtro);
        elegirOtro.setFont(new Font("Arial",Font.BOLD,12));
        elegirOtro.setHorizontalAlignment(SwingConstants.CENTER);
        elegirOtro.setVerticalAlignment(SwingConstants.CENTER);
        
                JButton aceptarCaso = new JButton("Aceptar el caso");
                aceptarCaso.setBounds(323, 5, 121, 23);
                pPie.add(aceptarCaso);
                aceptarCaso.setFont(new Font("Arial",Font.BOLD,12));
                aceptarCaso.setHorizontalAlignment(SwingConstants.CENTER);
                aceptarCaso.setVerticalAlignment(SwingConstants.CENTER);
                
                JLabel lfondoabajo = new JLabel("");
                lfondoabajo.setPreferredSize(new Dimension(1000, 1000));
                lfondoabajo.setBounds(0, 0, 681, 79);
                pPie.add(lfondoabajo);
                lfondoabajo.setIcon(new ImageIcon(PresentacionCaso.class.getResource("/imagenes/fondo3.png")));
     
                aceptarCaso.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ResolviendoCaso resolviendoCaso = new ResolviendoCaso(carmenSanDiegoMaster);
                        setVisible(false);
                        resolviendoCaso.setVisible(true);
                    }
                });
        
                elegirOtro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        PresentacionCaso presentacionCaso = new PresentacionCaso();
                        setVisible(false);
                        presentacionCaso.setVisible(true);
                    }
                } );
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
