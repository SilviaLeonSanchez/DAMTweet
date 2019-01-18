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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class DBHelper {

    // this.pathCarpetaPrograma = System.getProperty("user.home")+File.separator+"." + pathCarpetaPrograma;
    String pathCarpetaPrograma;
    String dbName;
    String urlDBFile;

    public DBHelper(String pathCarpetaPrograma, String dbName) {
        this.pathCarpetaPrograma = pathCarpetaPrograma;
        this.dbName = dbName;
        this.urlDBFile = "jdbc:sqlite:" + pathCarpetaPrograma + File.separator + dbName;
        crearTablas();
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urlDBFile);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void crearTablas() {

        /* Instruciones SQL para crear la tabla usuarios, posiblemente en el futuro 
        habra que crear mas tablas y normaliuzarlas, crear relaciones etc..               
         */
        String sql = "CREATE TABLE IF NOT EXISTS USERS (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	user_name text NOT NULL UNIQUE,\n"
                + "     token text NOT NULL,\n"
                + "     secret_token text NOT NULL\n"
                + ");";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertarUsuario(String name, String user_name, String token, String secret_token) {

        String sql = "INSERT INTO USERS(name, user_name, token, secret_token) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
        String sql = "SELECT * FROM USERS WHERE user_name=?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, user_name);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("name") + "\t"
                        + rs.getDouble("user_name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
