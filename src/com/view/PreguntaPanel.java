package com.view;

import com.model.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreguntaPanel extends JPanel implements ActionListener {

    private Pregunta pregunta;
    private JLabel lbQuestion;
    private JRadioButton radBtnAnswer1;
    private JRadioButton radBtnAnswer2;
    private JRadioButton radBtnAnswer3;
    private JRadioButton radBtnAnswer4;

    public PreguntaPanel(Pregunta pregunta){
        this.pregunta = pregunta;
        this.startComponents(this);
    }

    /**
     * Inicia el componente con sus preguntas
     * @param panel
     */
    private void startComponents(JPanel panel){
        panel.setLayout(new GridLayout(5,1));
        lbQuestion = new JLabel(pregunta.getQuestion());
        lbQuestion.setFont(new Font("Helvetica", Font.BOLD,18));
        lbQuestion.setBounds(10,190,400,25);
        panel.add(lbQuestion);
        radBtnAnswer1=new JRadioButton(pregunta.getAnswers()[0]);
        panel.add(radBtnAnswer1);
        radBtnAnswer1.addActionListener(this);
        radBtnAnswer2=new JRadioButton(pregunta.getAnswers()[1]);
        panel.add(radBtnAnswer2);
        radBtnAnswer2.addActionListener(this);
        radBtnAnswer3=new JRadioButton(pregunta.getAnswers()[2]);
        panel.add(radBtnAnswer3);
        radBtnAnswer3.addActionListener(this);
        radBtnAnswer4=new JRadioButton(pregunta.getAnswers()[3]);
        panel.add(radBtnAnswer4);
        radBtnAnswer4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String respuesta = e.getActionCommand();
        if(respuesta.equals(pregunta.getAnswer())){
            System.out.println("Respuesta correcta");
            try {
                seleccionado(respuesta).setBackground(Color.GREEN);
                this.repaint();
            }catch (Exception err){
                System.out.println("Controlando error");
            }
            setStateAnswers(false);
        }else{
            System.out.println("Respuesta incorrecta");
            try {
                seleccionado(respuesta).setBackground(Color.RED);
                this.repaint();
            }catch (Exception err){
                System.out.println("Controlando error");
            }
            setStateAnswers(false);
        }
    }

    private JRadioButton seleccionado(String answer){
        if(radBtnAnswer1.getText().equals(answer)){
            return radBtnAnswer1;
        }
        if(radBtnAnswer2.getText().equals(answer)){
            return radBtnAnswer2;
        }
        if(radBtnAnswer3.getText().equals(answer)){
            return radBtnAnswer3;
        }
        if(radBtnAnswer4.getText().equals(answer)){
            return radBtnAnswer4;
        }
        return null;
    }

    /**
     * Setea el estado de los botones
     * @param state
     */
    private void setStateAnswers(boolean state){
        radBtnAnswer1.setEnabled(state);
        radBtnAnswer2.setEnabled(state);
        radBtnAnswer3.setEnabled(state);
        radBtnAnswer4.setEnabled(state);
    }
}
