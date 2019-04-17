package com.view;

import com.control.Controlador;
import com.model.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class PreguntaUI extends JFrame {

    public static void main(String[] args) {
//      Este fragmento Genera la vista inicial
        
        
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
        Controlador control = new Controlador();
        control.conexion();
        ArrayList<Pregunta> question;
        question=control.Consulta();
        if (question != null) {
        for(Pregunta objeto: question) {
        	PreguntaPanel panel = new PreguntaPanel(objeto);
        	vista.add(panel);
        }
        }
        
        
        
        
    }
}
