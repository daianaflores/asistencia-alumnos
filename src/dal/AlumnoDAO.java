package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bll.Alumno;

import dal.Conexion;


public class AlumnoDAO {
	
	    private static final String SELECTALUMNO = 
	    "SELECT ID_PERSONA, NRO_DNI, APELLIDO, NOMBRE, GENERO, EDAD, EMAIL FROM PERSONAS";

	    private static final String INSERTALUMNO =
	    "INSERT INTO PERSONAS (ID_PERSONA, NRO_DNI, APELLIDO, NOMBRE, GENERO, EDAD, EMAIL) VALUES(?,?,?,?,?,?,?)";
	    
	    private static final String BORRARALUMNO = "";

	    private static final String MAXALUMNO= "SELECT MAX(ID_PERSONA) + 1 AS MAXIMO FROM PERSONAS";
	    
	    
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


