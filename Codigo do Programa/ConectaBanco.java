/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author KOCH
 */
public class ConectaBanco {
    
    public  Statement stm;
    public  ResultSet rs;
    
    public  Connection conn;
    
    private final String driver = "org.mysql.Driver";
    private final String root = "jdbc:mysql://127.0.0.1/facial_recognition";
    private final String user = "root";
    private final String pass = "";
    
    public void conexao(){
        
        try {
            System.setProperty("jdbc.Driver", driver);
            conn = DriverManager.getConnection(root, user, pass);
            System.out.println("OK!");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        }
    }
    
    public void executaSQL(String SQL){
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
            System.out.println("olha aí: "+rs);
        } catch (Exception e) {
            System.out.println("Error: "+ e);
        }
    }
   
}
