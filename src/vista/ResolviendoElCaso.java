package vista;

import modelo.*;
import modelo.lugarInteres.*;
import viewmodel.ResolviendoElCasoViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResolviendoElCaso extends JFrame{

    private JPanel resolviendoElCasoPanel;
    private JButton bibliotecaButton;
    private JButton clubButton;
    private JButton embajadaButton;
    private JButton ordenDeArrestoButton;
    private JButton viajarButton;
    private JButton expedientesButton;
    private JList recorridoCriminalList;
    private JList destinosFallidosList;
    private JLabel paisActualLabel;
    private JPanel paisActualPanel;
    private JPanel viajesPanel;
    private JPanel separadorHorizontalPanel;
    private JPanel opcionesPanel;
    private JPanel lugaresPanel;
    private JPanel separadorVerticalPanel;
    private JPanel accionesPanel;
    private JLabel lugaresLabel;
    private JLabel ordenDeArrestoLabel;
    private JSeparator separadorHorizontalSeparator;
    private JSeparator separadorVerticalSeparator;
    private JButton bancoButton;

    private ResolviendoElCasoViewModel modelo;
    private CarmenSanDiegoMaster carmenSanDiegoMaster;
    private Caso caso;
    private Jugador jugador;
    private Villano villano;
    private LugarInteres lugarInteresActual;
    private Pais paisActual;

    private void crearModelo(DataDummy dataDummy) {
        modelo = new ResolviendoElCasoViewModel();

        caso = dataDummy.getCasoAsignado();
        jugador = dataDummy.getJugadorAsignado();
        villano = dataDummy.getVillanoAsignado();

        jugador.asignarPaisDelCaso(caso);

        carmenSanDiegoMaster = new CarmenSanDiegoMaster(caso, jugador, villano);
        modelo.setCarmenSanDiegoMaster(carmenSanDiegoMaster);
    }

    private void chequearExistenciaDeLugarInteres(LugarInteres otroLugarInteres) {
        lugarInteresActual = modelo.obtenerLugarDeInteres(otroLugarInteres);
        if(lugarInteresActual.informacion() == otroLugarInteres.informacion()){
            modelo.jugadorIngresarA(lugarInteresActual);
            VisitandoLugar visitandoLugar = new VisitandoLugar(carmenSanDiegoMaster, lugarInteresActual);
        }
        else{
            JOptionPane.showMessageDialog(resolviendoElCasoPanel,"Este Lugar de interes no existe en este pais. Intenta otro!");
        }
    }

    public ResolviendoElCaso(DataDummy dataDummy){
        crearModelo(dataDummy);
        setContentPane(resolviendoElCasoPanel);
        setLocation(350,150);
        setSize(650,600);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        setTitle("Resolviendo: " + dataDummy.obtenerTituloDelCasoAsignado());
        dataDummy.setearCasoAsignadoAJugadorAsignado();
        paisActualLabel.setText("Estas en: " + dataDummy.obtenerNombreDelPaisActualDelJugadorAsignado());

        bibliotecaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Biblioteca());

            }
        });

        clubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Club());
            }

        });

        embajadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Embajada());
            }
        });

        bancoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chequearExistenciaDeLugarInteres(new Banco());
            }
        });
    }




}
