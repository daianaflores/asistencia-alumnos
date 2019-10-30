package asistenciaalumnos.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import asistenciaalumnos.app.model.Alumno;
import asistenciaalumnos.configuracionconeccion.Conexion;


public class AlumnoDAO {
	
	    private static final String SELECTALUMNO = 
	    "SELECT Matricula, Nombre, Apellido, fecha_nacimiento, DNI, idEstado, idContacto FROM Alumno";

	    private static final String INSERTALUMNO =
	    "INSERT INTO Alumno (Matricula, Nombre, Apellido, fecha_nacimiento, DNI, idEstado, idContacto) VALUES(?,?,?,?,?,?,?)";
	    
	    private static final String MAXALUMNO= "SELECT MAX(Matricula) + 1 AS MAXIMO FROM Alumno";
	    
	    
	    public List<Alumno> getAlumno(){
			ArrayList<Alumno> Alumno = new ArrayList<Alumno>();
			Connection con = Conexion.getConexion();
			
			try {
				PreparedStatement stmn = null;

				ResultSet rs = null;
				Alumno Alumnoa;
				while (rs.next()) {
					Alumnoa = new Alumno();
		
					Alumno.add(Alumnoa);
				}

			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return Alumno;
	    }
	    
		public int insertAlumno(Alumno Alumno) {
			Connection con = Conexion.getConexion();
			PreparedStatement stmn = null;
			ResultSet rs = null;
			
			int max=0;
			int regAfectados = 0;
			

			return regAfectados;
		}
	}


