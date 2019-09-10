package BLL;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import DAL.alumnoDAO;
import DAL.Conexion;
import BLL.alumno;
import DAL.SingletonProperties;


public class alumnoTest {
	
				public static void main(String[] args) throws  InterruptedException, IOException {
						
						int opcion = 0;
						do {
							System.out.println ("Selecciones una Opción");
							System.out.println ("0 - Salir");
							System.out.println ("1 - Consultar Personas");
							System.out.println ("2 - Dar de Alta una Persona");
							System.out.println ("3 - Borrar a una persona");

							Scanner entradaEscaner = new Scanner (System.in);
							opcion = entradaEscaner.nextInt ();
							
							switch (opcion) {
								case 1:	{consultarAlumno(); break;}
								case 2: {
									if (insertarAlumno() == 1) 
										System.out.println("Se ha agregado la persona con Exito.");
									else
										System.out.println("Ocurrio un error al agregar a la persona");
									break;
								}
								case 3: {}
								default: break;
							}
							System.out.println("");
							System.out.println("Presione una tecla para continuar...");
							entradaEscaner.nextLine();
							entradaEscaner.nextLine();

						} while  (opcion!=0);
						
						System.out.println("Chau...");
					}
					
					private static void consultarAlumno() {
						alumnoDAO alumnoDAO = new alumnoDAO();
						List<alumno> alumno = alumnoDAO.getAlumno();
						for (alumno a: alumno){
							System.out.print(" " + a.getNumeroMatricula());
							System.out.print(" - " + a.getNombre());
							System.out.print(" - " + a.getApellido());
							System.out.print(" - " + a.getDni());
							System.out.print(" - " + a.getFechaDeNacimiento());
							System.out.print(" - " + a.getEstado());
							
						}
					}
					
					private static int insertarAlumno() {
						Scanner entradaEscaner = new Scanner (System.in);
						alumno alumno = new alumno();
						System.out.println ("Ingrese el Numero de Matricula: ");
						alumno.setNumeroMatricula(entradaEscaner.nextInt ());
						entradaEscaner.nextLine();
						System.out.println ("Ingrese el nombre: ");
						alumno.setNombre(entradaEscaner.nextLine());
						System.out.println ("Ingrese el apellido: ");
						alumno.setApellido(entradaEscaner.nextLine());
						System.out.println ("Ingrese el dni: ");
						alumno.setDni(entradaEscaner.nextLine());
						System.out.println ("Ingrese la fecha de nacimiento: ");
						alumno.setFechaDeNacimiento(entradaEscaner.nextInt());
						entradaEscaner.nextLine();
					
					
						alumnoDAO alumnoDAO = new alumnoDAO();
						return alumnoDAO.insertAlumno(alumno);
					}
				


			}


	}

}
