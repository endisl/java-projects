/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pimeco;

/**
 *
 * @author Endi
 */

import java.sql.*;
import javax.swing.*;
import java.awt.HeadlessException;


public class ConectaBancoPerfis {
    
    
     Connection conn = null;
     
     public static Connection ConnecrDb(){
         
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Windows\\perfis.sqlite");            
            //JOptionPane.showMessageDialog(null, "Conexão Estabelecida!");
            return conn;
        }
            
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
            
        } 
         
         
     }
     
     
        
     
     
    
    
    
    
}
