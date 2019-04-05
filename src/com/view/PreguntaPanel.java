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

    private void startComponents(JPanel panel){
        panel.setLayout(new GridLayout(5,1));
        lbQuestion = new JLabel(pregunta.getQuestion());
        lbQuestion.setFont(new Font("Helvetica", Font.BOLD,18));
        lbQuestion.setBounds(10,190,400,25);
        panel.add(lbQuestion);
        radBtnAnswer1=new JRadioButton(pregunta.getAnswers()[0]);
        panel.add(radBtnAnswer1);
        radBtnAnswer2=new JRadioButton(pregunta.getAnswers()[1]);
        panel.add(radBtnAnswer2);
        radBtnAnswer3=new JRadioButton(pregunta.getAnswers()[2]);
        panel.add(radBtnAnswer3);
        radBtnAnswer4=new JRadioButton(pregunta.getAnswers()[3]);
        panel.add(radBtnAnswer4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
