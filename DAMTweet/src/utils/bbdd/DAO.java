package utils.bbdd;

import java.sql.ResultSet;

/**
 *
 * @author Silvia Leon
 */
public class DAO{

    // ATRIBUTOS
    protected GestorBBDD_MySQL bbdd;

    // METODOS
    // CONSTRUCTOR
    public DAO(GestorBBDD_MySQL bbdd) {
        this.bbdd = bbdd;
    }

    // GETTER Y SETTER
    public void setBbdd(GestorBBDD_MySQL bbdd) {
        this.bbdd = bbdd;
    }

    public GestorBBDD_MySQL getBbdd() {
        return bbdd;
    }

    // CONSULTAS
    public ResultSet ejecutarSELECT(String tabla, String nombreCampo, String valorCampo) {
        if (this.bbdd.reconectarBBDD()) {
            return this.bbdd.ejecutarSELECT("select * from " + tabla + " where upper(" + nombreCampo + ")=upper(\'" + valorCampo + "\')");
        }
        return null;
    }

    public ResultSet ejecutarSELECT(String tabla, String nombreCampo, int valorCampo) {
            return this.bbdd.ejecutarSELECT("select * from " + tabla + " where " + nombreCampo + "=" + valorCampo);
    }

    public int ejecutarINSERT(String tabla, String campos, String valores) {
        return bbdd.ejecutarUPDATE("INSERT INTO " + tabla + " (" + campos + ") VALUES (" + valores + ")");
    }

    public int ejecutarDELETE(String tabla, String nombreCampo, String valorCampo) {
        return this.bbdd.ejecutarUPDATE("delete " + tabla + " where upper(" + nombreCampo + ")=\'" + valorCampo + "\'");
    }

    public int ejecutarDELETE(String tabla, String nombreCampo, int valorCampo) {
        return this.bbdd.ejecutarUPDATE("delete " + tabla + " where " + nombreCampo + "=" + valorCampo);
    }
    
 
    
}
