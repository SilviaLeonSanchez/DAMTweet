package utils.bbdd;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
