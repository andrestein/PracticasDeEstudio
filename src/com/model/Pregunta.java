package com.model;

public class Pregunta {
    private String question; // ¿ Quien escribio la odisea ?
    private String answer; // Homero
    private String[] answers; // ["Homero","Pitagoras","Uribe","Duque"]

    public Pregunta (String question,String answer,String[] answers){
        this.question = question;
        this.answer = answer;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
