package com.control;
import java.sql.*;


public class Controlador {
    public Controlador(){
        
    }
    Connection conn=null;
    public void Consulta() {
        try{
        Statement st = conn.createStatement();
        String sql1 = "SELECT * FROM pregunta";
        ResultSet rs = st.executeQuery(sql1);
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        }catch(Exception e){

        }

    }
    public void conexion(){
        
        final String url = "jdbc:postgresql://ec2-23-21-136-232.compute-1.amazonaws.com:5432/";
        final String dbName = "dduesmt072cp7p";
        final String driver = "org.postgresql.Driver";
        final String userName = "dfggfitjgjvdsv";
        final String password = "b863caeecf127af51dd521870a03e00100aaa069485408cac65e17aad503a564";
        
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName,password);
            
            if (!conn.isClosed())
                System.out.println("Database connection working using TCP/IP...");
                Statement st = conn.createStatement();
                String sql1 = "SELECT * FROM pregunta";
                ResultSet rs = st.executeQuery(sql1);
                while(rs.next()){
                    System.out.println(rs.getString(2)+rs.getString(3)+rs.getInt(4));
                }
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
