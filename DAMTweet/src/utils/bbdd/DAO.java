package utils.bbdd;

import java.sql.ResultSet;

/**
 *
 * @author Silvia Leon
 */
public class DAO {

    // ATRIBUTOS
    protected GestorBBDD_SQLite bbdd;

    // METODOS
    // CONSTRUCTOR
    public DAO(GestorBBDD_SQLite bbdd) {
        this.bbdd = bbdd;
    }

    // GETTER Y SETTER
    public void setBbdd(GestorBBDD_SQLite bbdd) {
        this.bbdd = bbdd;
    }

    public GestorBBDD_SQLite getBbdd() {
        return bbdd;
    }

    // CONSULTAS
    public ResultSet ejecutarSELECT(String tabla) {
        if (this.bbdd.reconectarBBDD()) {
            return this.bbdd.ejecutarSELECT("select * from " + tabla );
        }
        return null;
    }
    
    public ResultSet ejecutarSELECT(String tabla, String nombreCampo, String valorCampo) {
        if (this.bbdd.reconectarBBDD()) {
            return this.bbdd.ejecutarSELECT("select * from " + tabla + " where upper(" + nombreCampo + ")=upper(\'" + valorCampo + "\')");
        }
        return null;
    }

    public ResultSet ejecutarSELECT(String tabla, String nombreCampo, int valorCampo) {
        if (this.bbdd.reconectarBBDD()) {
            return this.bbdd.ejecutarSELECT("select * from " + tabla + " where " + nombreCampo + "=" + valorCampo);
        }
        return null;
    }

    public int ejecutarINSERT(String tabla, String campos, String valores) {
        if (this.bbdd.reconectarBBDD()) {
            return bbdd.ejecutarUPDATE("INSERT INTO " + tabla + " (" + campos + ") VALUES (" + valores + ")");
        }
        return -1;
    }

    public int ejecutarDELETE(String tabla, String nombreCampo, String valorCampo) {
        if (this.bbdd.reconectarBBDD()) {
            return this.bbdd.ejecutarUPDATE("delete " + tabla + " where upper(" + nombreCampo + ")=\'" + valorCampo + "\'");
        }
        return -1;
    }

    public int ejecutarDELETE(String tabla, String nombreCampo, int valorCampo) {
        if (this.bbdd.reconectarBBDD()) {
            return this.bbdd.ejecutarUPDATE("delete " + tabla + " where " + nombreCampo + "=" + valorCampo);
        }
        return -1;
    }

}
