

package utils.bbdd;

/**
 *
 * @author Silvia Leon
 */
public class VistaGestorBBDD {
    
    // EXITO
    public void exitoConexion(){
        System.out.println("Conexión a la base de datos realizada con éxito.");
    }
    
    public void exitoDesconexion(){
        System.out.println("Desconexión de la base de datos realizada con éxito.");
    }
    
    public void exitoAutocommit(){
        System.out.println("Cambio del modo Autocommit realizado con éxito..");
    }
    
    public void exitoRollback(){
        System.out.println("Rollback realizado con éxito.");
    }

    public void exitoCommit(){
        System.out.println("Commit realizado con éxito.");
    }
    
    public void exitoConsulta(){
        System.out.println("Consulta realizada con éxito.");
    }
    
    public void exitoUpdate(){
        System.out.println("Modificación de la base de datos realizada con éxito.");
    }
    
    // ERROR
    public void errorConexion(){
        System.out.println("Se ha producido un error al conectar a la base de datos.");
    }
    
    public void errorDesconexion(){
        System.out.println("Se ha producido un error al desconectar de la base de datos.");
    }
    
    public void errorComprobarConexion(){
        System.out.println("Se ha producido un error al comprobar la conexion con la base de datos.");
    }
    
    public void errorAutocommit(){
        System.out.println("Se ha producido un error al gestionar el modo Autocommit.");
    }
    
    public void errorRollback(){
        System.out.println("Se ha producido un error al realizar el rollback.");
    }

    public void errorCommit(){
        System.out.println("Se ha producido un error al realizar el commit.");
    }
    
    public void errorConsulta(){
        System.out.println("Se ha producido un error al realizar la consulta.");
    }
    
    public void errorUpdate(){
        System.out.println("Se ha producido un error al realizar la modificación de la base de datos.");
    }
    
    public void errorGenerico(){
        System.out.println("Se ha producido un error al realizar la operación en la base de datos.");
    }
    
    // RESULTADOS
    public void noResultado(){
        System.out.println("No hay ningun resultado.");
    }
    
    
}
