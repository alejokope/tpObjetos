package vista;

import javax.swing.*;

public class PaginaDeInicio extends JFrame{
    private JPanel paginaDeInicioPanel;
    private JLabel preguntaLabel;
    private JButton resolverMisterioButton;
    private JButton expedientesButton;

    public static void main(String[] args) {
        PaginaDeInicio paginaDeInicio = new PaginaDeInicio();

    }

    public PaginaDeInicio(){
        setTitle("¿Dónde está Carmen Sandiego?");
        setContentPane(paginaDeInicioPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


}
