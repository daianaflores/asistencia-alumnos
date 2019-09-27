package asistenciaalumnos.configuracionconeccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {

        SingletonProperties sp=SingletonProperties.getInstancia();

        Connection con= null;
        try {
            String cadenaConeccion = sp.getPropiedad("CADENACONEXION");
            String driver = sp.getPropiedad("DRIVER");
            String user = sp.getPropiedad("USER");
            String password = sp.getPropiedad("PASSWORD");

            Class.forName(driver);

            con = DriverManager.getConnection(cadenaConeccion, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;

    }
}
