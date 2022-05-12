/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import Db.User;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 *
 * @author yBlackSpider
 */
public class DbListener implements ServletContextListener {
    public static final String URL = "jdbc:sqlite:\\C:\\BdChadrez\\chadrez.db";
    
    public static String exceptionMessage = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String step = "Starting database";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(URL);
            Statement stmt = con.createStatement();
            step = "'users' table creation";
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users("                   
                    + "login VARCHAR(20) UNIQUE NOT NULL, "
                    + "name VARCHAR(200) NOT NULL, "
                    + "password_hash LONG NOT NULL, "
                    + "victory LONG, "
                    + "lose LONG "
                    + ")");
            if(User.getList().isEmpty()){
                step = "default users creations";
                stmt.executeUpdate("INSERT INTO users VALUES("
                        + "'antonio', 'Antonio Carlos', "+"1234".hashCode()+", 0"+", 0"+")");
                stmt.executeUpdate("INSERT INTO users VALUES("
                        + "'allan', 'Allan', "+"123".hashCode()+ ", 0"+", 0"+")");
                stmt.executeUpdate("INSERT INTO users VALUES("
                        + "'admin', 'Administrador', "+"123456".hashCode()+", 0"+", 0"+")");
            }
        }catch(Exception ex){
            exceptionMessage = step + ": " + ex.getMessage();
        }
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}