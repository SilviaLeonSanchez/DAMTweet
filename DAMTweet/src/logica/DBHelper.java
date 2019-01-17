/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sebas
 */
public class DBHelper {

    // this.pathCarpetaPrograma = System.getProperty("user.home")+File.separator+"." + pathCarpetaPrograma;
    String pathCarpetaPrograma;
    String dbName;
    Connection conn;
    
    

    public DBHelper(String pathCarpetaPrograma, String dbName) {
        this.pathCarpetaPrograma = pathCarpetaPrograma;
        this.dbName = dbName;
        this.conn = null;
        crearConexionDb();

    }

    private void crearConexionDb() {
        try {
            

            String url = "jdbc:sqlite:" + pathCarpetaPrograma + File.separator + dbName;
            System.out.println(url);

            this.conn = DriverManager.getConnection(url);

            System.out.println("Connexiuon SQLite establecida.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void cerrarConexionDb() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void crearTablas() {

        /* Instruciones SQL para crear la tabla usuarios, posiblemente en el futuro 
        habra que crear mas tablas y normaliuzarlas, crear relaciones etc..               
         */
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	user_name text NOT NULL,\n"
                + "     token text NOT NULL\n"
                + "     secret_token text NOT NULL\n"
                + ");";

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void insertarUsuario(String name, String user_name, String token, String secret_token) {
        
        String sql = "INSERT INTO users(name, user_name, token, secret_token) VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, user_name);
            pstmt.setString(3, token);
            pstmt.setString(4, secret_token);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet getUserData(String user_name) {
        String sql = "SELECT * FROM users WHERE user_name=?";
      
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the value
            pstmt.setString(1, user_name);
            ResultSet rs = pstmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
