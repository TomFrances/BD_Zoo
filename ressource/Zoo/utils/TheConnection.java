package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.DatabaseAccessProperties;

public class TheConnection{

    private static Connection connect;

    private TheConnection(){
      try {
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	DatabaseAccessProperties p = new DatabaseAccessProperties("Zoo/BD.properties");
	connect = DriverManager.getConnection(p.getDatabaseUrl(), p.getUsername(), p.getPassword());
	connect.setAutoCommit(false);}
      catch (SQLException e) { e.printStackTrace(); }
    }

   public static Connection getInstance(){
      if(connect == null){
        new TheConnection();
        if(connect!=null) System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
      }
      return connect;   
    }

   public static void close() {
	 try {
	   if(connect != null){
        connect.close();
        System.out.println("FERMETURE DE LA CONNEXION SQL ! "); } 
	   }
	   catch (SQLException e) { e.printStackTrace(); }
    }   

}