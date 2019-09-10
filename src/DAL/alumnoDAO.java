package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BLL.alumno;
import DAL.Conexion;


public class alumnoDAO {
	
	    private static final String SELECTALUMNO = 
	    "SELECT ID_PERSONA, NRO_DNI, APELLIDO, NOMBRE, GENERO, EDAD, EMAIL FROM PERSONAS";

	    private static final String INSERTALUMNO =
	    "INSERT INTO PERSONAS (ID_PERSONA, NRO_DNI, APELLIDO, NOMBRE, GENERO, EDAD, EMAIL) VALUES(?,?,?,?,?,?,?)";
	    
	    private static final String BORRARALUMNO = "";

	    private static final String MAXALUMNO= "SELECT MAX(ID_PERSONA) + 1 AS MAXIMO FROM PERSONAS";
	    
	    
	    public List<alumno> getAlumno(){
			ArrayList<alumno> alumno = new ArrayList<alumno>();
			Connection con = Conexion.getConexion();
			
			try {
				PreparedStatement stmn = null;

				ResultSet rs = null;
				alumno alumnoa;
				while (rs.next()) {
					alumnoa = new alumno();
		
					alumno.add(alumnoa);
				}

			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return alumno;
	    }
	    
		public int insertAlumno(alumno alumno) {
			Connection con = Conexion.getConexion();
			PreparedStatement stmn = null;
			ResultSet rs = null;
			
			int max=0;
			int regAfectados = 0;
			

			return regAfectados;
		}
	}


