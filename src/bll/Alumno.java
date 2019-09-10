package bll;

import bll.Alumno;


public class Alumno {	
		
		private int id ;
		private int numeroMatricula;
		private String nombre;
		private String apellido;
		private int dni;
		private java.util.Date fechaDeNacimiento;
		private int Estado;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumeroMatricula() {
			return numeroMatricula;
		}
		public void setNumeroMatricula(int numeroMatricula) {
			this.numeroMatricula = numeroMatricula;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public int getDni() {
			return dni;
		}
		public void setDni(int dni) {
			this.dni = dni;
		}

		public java.util.Date getFechaDeNacimiento() {
			return fechaDeNacimiento;
		}
		public void setFechaDeNacimiento(java.util.Date fechaDeNacimiento) {
			this.fechaDeNacimiento = fechaDeNacimiento;
		}
		public int getEstado() {
			return Estado;
		}
		public void setEstado(int estado) {
			Estado = estado;
		}
		
}

