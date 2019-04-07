package com.view;

import com.model.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PreguntaUI extends JFrame {

    public static void main(String[] args) {
//        Este fragmento Genera la vista inicial
        PreguntaUI vist = new PreguntaUI();
        vist.setVisible(true);
    }

    public PreguntaUI(){
        System.out.println("Jose Medina");
        this.startJFrame(this);
    }

    /**
     *  Este metodo controla las caracteristicas del jFrame
     * @param vista Se pasa como parametro la vista actual
     */
    private void startJFrame(JFrame vista){
        //Este codigo Genera una pregunta
        String[] answers = new String[]{"Homero", "Uribe", "Tromp", "Jose"};
        Pregunta pregunta = new Pregunta("¿Quien escribio la odisea?", "Homero", answers);
        String[] answers2 = new String[]{"Colombia", "Italia", "Francia", "No se :V"};
        Pregunta pregunta2 = new Pregunta("¿Donde esta la torre eiffel?", "No se :V", answers2);
        //Desde aqui se configura la interfaz
        vista.setBounds(320,90,800,600);
        vista.setLayout(new GridLayout());
        vista.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        PreguntaPanel panel = new PreguntaPanel(pregunta);
        PreguntaPanel panel2 = new PreguntaPanel(pregunta2);
        vista.add(panel);
        vista.add(panel2);
    }
}
