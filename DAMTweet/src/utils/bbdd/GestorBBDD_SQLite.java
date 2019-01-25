package utils.bbdd;

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
 * @author Silvia Leon
 */
public class GestorBBDD_SQLite {

    // ATRIBUTOS
    protected VistaGestorBBDD vista;
    protected Connection conexion;
    protected Statement consulta;
    protected String url;
    protected String rutaBBDD;
    protected String nombreBBDD;

    // METODOS
    // CONSTRUCTORES
    public GestorBBDD_SQLite(String pathCarpetaPrograma, String dbName) {
        this.url = "jdbc:sqlite:" + pathCarpetaPrograma + File.separator + dbName;
        this.rutaBBDD = pathCarpetaPrograma;
        this.nombreBBDD = dbName;
        this.vista = new VistaGestorBBDD();
        conectarBBDD();
    }

    public Statement getConsulta() {
        return consulta;
    }

    // GETTER Y SETTER
    public String getUrl() {
        return url;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setVista(VistaGestorBBDD vista) {
        this.vista = vista;
    }

    public VistaGestorBBDD getVista() {
        return vista;
    }

    // CONEXION BBDD
    private boolean conectarBBDD() {
        try {
            this.conexion = DriverManager.getConnection(url);
            this.consulta = this.conexion.createStatement();
            return true;
        } catch (SQLException ex) {
            vista.errorConexion();
            System.out.print("Mensaje error: " + ex.getMessage() + "\n" + "Seguimiento: ");
            ex.printStackTrace();
            return false;
        }
    }

    public boolean reconectarBBDD() {
        if (isClosed()) {
            conectarBBDD();
        }
        return true;
    }

    public boolean desconectarBBDD() {
        try {
            this.conexion.close();
            this.consulta.close();
            return true;
        } catch (SQLException ex) {
            vista.errorDesconexion();
            return false;
        }
    }

    public boolean isClosed() {
        try {
            return this.conexion.isClosed();
        } catch (SQLException ex) {
            vista.errorComprobarConexion();
            System.out.print("Mensaje error: " + ex.getMessage());
            return true;
        }
    }

    // COMMITS Y ROLLBACK
    public boolean autocommit(boolean autocommit) {
        try {
            this.conexion.setAutoCommit(autocommit);
            return true;
        } catch (SQLException ex) {
            vista.errorAutocommit();
            return false;
        }
    }

    public boolean rollback() {
        try {
            this.conexion.rollback();
            return true;
        } catch (SQLException ex) {
            vista.errorRollback();
            return false;
        }
    }

    public boolean commit() {
        try {
            this.conexion.commit();
            return true;
        } catch (SQLException ex) {
            vista.errorCommit();
            return false;
        }
    }

    // SENTENCIAS
    public ResultSet ejecutarSELECT(String sentencia) {
        try {
            return consulta.executeQuery(sentencia);
        } catch (SQLException ex) {
            vista.errorConsulta();
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public int ejecutarUPDATE(String sentencia) {
        try {
            return consulta.executeUpdate(sentencia);
        } catch (SQLException ex) {
            vista.errorUpdate();
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    public boolean ejecutar(String sentencia) {
        try {
            return this.consulta.execute(sentencia);
        } catch (SQLException ex) {
            return false;
        }
    }
    
     public void crearTablas() {

        try {
            /* Instruciones SQL para crear la tabla usuarios, posiblemente en el futuro
            habra que crear mas tablas y normaliuzarlas, crear relaciones etc..
            */
            String sql_usuarios = "CREATE TABLE IF NOT EXISTS USERS (\n"
                    + "	id integer PRIMARY KEY UNIQUE,\n"
                    + "	name text NOT NULL,\n"
                    + "	user_name text NOT NULL,\n"
                    + "     token text NOT NULL,\n"
                    + "     secret_token VARBINARY NOT NULL\n"
                    + ");";
            
            String sql_TT = "CREATE TABLE IF NOT EXISTS LUGARES_TT (\n"
                    + "	woeid integer PRIMARY KEY,\n"
                    + "	ciudad text NOT NULL\n"
                    + ");";
            
            consulta.execute(sql_usuarios);
            consulta.execute(sql_TT);
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBBDD_SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertarUsuario(long id, String name, String user_name, String token, byte[] secret_token) {

        try {
            String sql = "INSERT INTO USERS(id, name, user_name, token, secret_token) VALUES(?,?,?,?,?)";
            
            this.reconectarBBDD();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, user_name);
            pstmt.setString(4, token);
            pstmt.setBytes(5, secret_token);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBBDD_SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public ResultSet getUserData(String user_name) {
        try {
            String sql = "SELECT * FROM USERS WHERE user_name=?";
            
            this.reconectarBBDD();
            PreparedStatement pstmt = conexion.prepareStatement(sql);

            pstmt.setString(1, user_name);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("name") + "\t"
                        + rs.getDouble("user_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorBBDD_SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
