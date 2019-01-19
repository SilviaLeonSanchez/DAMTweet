package utils.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Silvia Leon
 */
public class GestorBBDD_MySQL {

    // ATRIBUTOS
    protected VistaGestorBBDD vista;
    protected Connection conexion;
    protected Statement consulta;
    protected int tipoResultado;
    protected int tipoActualizacion;
    protected String url;
    protected String usuario;
    protected String password;

    // METODOS
    // CONSTRUCTORES
    public GestorBBDD_MySQL(String IP_BBDD, String usuario, String password, String esquema) {
        this.url = "jdbc:mysql://" + IP_BBDD + ":3306/"+ esquema + "?serverTimezone=UTC" ;
        parametrosConexion();
    }

    public GestorBBDD_MySQL(String usuario, String password, String esquema) {
        this.url = "jdbc:mysql://localhost:3306/"+esquema+"?serverTimezone=UTC";
        parametrosConexion();
    }
    
    private void parametrosConexion(){
        this.vista = new VistaGestorBBDD();
        this.tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
        this.tipoActualizacion = ResultSet.CONCUR_UPDATABLE;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectarBBDD(usuario, password);
            this.vista.exitoConexion();
            // this.consulta = conexion.createStatement(tipoResultado, tipoActualizacion);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se ha encontrado la clase al cargar el driver de la BBDD MySQL.");
        }
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

    public String getPassword() {
        return password;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public void setTipoResultado(int tipoResultado) {
        this.tipoResultado = tipoResultado;
    }

    public int getTipoResultado() {
        return tipoResultado;
    }
    
    public void setTipoActualizacion(int tipoActualizacion) {
        this.tipoActualizacion = tipoActualizacion;
    }

    public int getTipoActualizacion() {
        return tipoActualizacion;
    }

    
    // CONEXION BBDD
    private boolean conectarBBDD(String usuario, String password) {
        try {
            this.conexion = DriverManager.getConnection(url, usuario, password);
            this.usuario = usuario;
            this.password = password;
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
            try {
                this.conexion = DriverManager.getConnection(url, usuario, password);
                return true;
            } catch (SQLException ex) {
                vista.errorConexion();
                System.out.print("Mensaje error: " + ex.getMessage());
                return false;
            }
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
    
    public boolean ejecutar(String sentencia){
        try {
            return this.consulta.execute(sentencia);
        } catch (SQLException ex) {
            return false;
        }
    }


}
