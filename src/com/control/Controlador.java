package com.control;
import java.sql.*;
import java.util.ArrayList;

import com.model.Pregunta;

public class Controlador {
    public Controlador(){
    }
        private final String url = "jdbc:postgresql://ec2-23-21-136-232.compute-1.amazonaws.com:5432/";
        private final String dbName = "dduesmt072cp7p";
        private final String driver = "org.postgresql.Driver";
        private final String userName = "dfggfitjgjvdsv";
        private final String password = "b863caeecf127af51dd521870a03e00100aaa069485408cac65e17aad503a564";
        private Connection conn=null;
        
        
    public ArrayList<Pregunta> Consulta() {
        try{
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName, userName,password);
        Statement st = conn.createStatement();
        String sql1 = "select P.QUESTION, P.ANSWER, R.ANSWER1, R.ANSWER2, R.ANSWER3, R.ANSWER4\n" +
                      "from RESPUESTA R, PREGUNTA P \n" +
                      "where P.IDRESPUESTA=R.IDANSWER ";
                
        ResultSet rs = st.executeQuery(sql1);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        
        
        while(rs.next()){
           
           Object asb;
		   asb=new String[]{rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
           
           Pregunta pregunta = new Pregunta(rs.getString(1),rs.getString(2),(String[]) asb);
           preguntas.add(pregunta);
           //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
        return preguntas;
        
        }catch(Exception e){
            System.err.println("Exception: "+e.getMessage());
            return null;
        }
        
        
    }  
    
    public void conexion(){
        try {
            Consulta();
            if (!conn.isClosed())
                System.out.println("Database connection working using TCP/IP...");
                
            } catch (Exception e){
                System.err.println("Exception: "+e.getMessage());
            }finally {
            try {
                if (conn != null)
                    conn.close();
            }catch(SQLException e){
                
            }
            
        }
    }
}
