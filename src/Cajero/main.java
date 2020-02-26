package Cajero;

import java.util.List;
import java.util.Scanner;

public class main {
	static CrearUsuario datosU;
	static Registro registroU;
	static int nip;
	static int ID; 
	
	public static void main(String[] args) {
		int selec = 0;
		boolean pass = true;
		Scanner lector = new Scanner(System.in);
		
		do {
			Menu();
			selec = lector.nextInt();
			
			if(selec == 1) {
				AuthAdmin();
			}else if(selec == 2){
				AuthUser();
			}else if(selec == 3){
				break;
			}else {
				System.out.println("Eleccion inexistente");
				System.out.println("Por favor haga otra eleccion \n");
			}
		}while(pass);
		
		System.out.println("Sliendo ...");
		System.out.println("Gracias por participar en el BetaTest 1.0.0.");
		
	}

	private static void Menu() {
		System.out.println("/////////////////////////////");
		System.out.println("/// Bienbenido al cajero  ///");
		System.out.println("///     automatico UT     ///");
		System.out.println("/////////////////////////////");
		System.out.println("");
		System.out.println("//////////////////////////////");
		System.out.println("///       Seleccione       ///");
		System.out.println("///                        ///");
		System.out.println("///    1.- Administrador   ///");
		System.out.println("///    2.- Usuario         ///");
		System.out.println("///    3.- Salir           ///");
		System.out.println("//////////////////////////////");
		
	}

	private static void AuthAdmin() {
		Scanner lector = new Scanner(System.in);
		String user = "admin"; 
		String userIng;
		String password = "admin123";
		String passwordIng;
		int intentos = 0;
		
		System.out.println("Inicie Sesion para continuar");
		
		while(intentos <= 3) {
			System.out.print("\nIngrese su Usuario: ");
			userIng = lector.nextLine();
			
			System.out.print("\nIngrese su Contraseña: ");
			passwordIng = lector.nextLine();
			
			if(userIng.equals(user) && passwordIng.equals(password)) {
				Administrador();
				break;
			}else {
				System.out.println("Usuario o contraseña incorrectos, intente de nuevo porfavor");
				intentos++;
			}
		}
		System.out.println("\nLimite de intentos superado ...");
		
	}
	
	private static void AuthUser() {
		List<CrearUsuario> liUsua;
		registroU = new Registro();
		Scanner lector = new Scanner(System.in);
		boolean flag = false;
		int intentos = 0;
		
		System.out.println("Inicie sesion para continuar");
		
		while(intentos <= 3) {
			System.out.println("\nIngrese su NIP");
			nip = lector.nextInt();
			
			liUsua = registroU.seleccionarPersona();
			for (CrearUsuario usuario : liUsua) {
				if(usuario.getNIPU() == nip) {
					ID = usuario.getId();
					Usuario();
					flag = true;
					break;
				}
			}
			if(flag == false) {	
				System.out.println("\nEl NIP ingresado no existe en la BD");
				System.out.println("Intentelo de nuevo porfavor ...");
				intentos++;
			}else {
				break;
			}
		}
		if(intentos >= 3) {			
			System.out.println("\nNumero de intentos superados\n");
		}
	}
	
	private static void Administrador() {
		List<CrearUsuario> liUsua;
		int auth = 1;
		int auth2 = 1;
		int elim, opcion;
		String nombre, rol;
		int id, nip, numTarjeta;
		boolean flag = true;
		datosU = new CrearUsuario();
		registroU = new Registro();
		EliminarUsuario eliminar = new EliminarUsuario();
		ActualizarUsuario actualizar = new ActualizarUsuario();
		Scanner lector = new Scanner(System.in);
		Scanner lector1 = new Scanner(System.in);
		Scanner lector2 = new Scanner(System.in);
		Scanner lector3 = new Scanner(System.in);
		Scanner lector4 = new Scanner(System.in);
		Scanner lector5 = new Scanner(System.in);
		
		do {
		
			System.out.println("\nBienvenido al panel de Administracion");
			
			System.out.println("/////////////////////////////////////");
			System.out.println("///  Seleccione segun corresponda ///");
			System.out.println("///                               ///");
			System.out.println("///   1.- Usuarios Registrados    ///");
			System.out.println("///   2.- Registrar Nuevo Usuario ///");
			System.out.println("///   3.- Actualizar Usuario      ///");
			System.out.println("///   4.- Eliminar Usuario        ///");
			System.out.println("///   5.- Salir                   ///");
			System.out.println("/////////////////////////////////////");
			opcion = lector.nextInt();
			
			if(opcion == 1) {
				/**
				 * Hace un Query y trae todos los usuarios existentes en la BD
				 * */
				liUsua = registroU.seleccionarPersona();
				for (CrearUsuario usuario : liUsua) {
					System.out.print("ID: "+usuario.getId()+", ");
					System.out.print("Rol: "+usuario.getRol()+", ");
					System.out.print("Nombre: "+usuario.getNombreU()+", ");
					System.out.print("NIP: "+usuario.getNIPU()+", ");
					System.out.print("Numero Tarj: "+usuario.getNumTerjetaU()+", ");
					System.out.print("Saldo: $"+usuario.getFondosU()+"\n");
				}
			}else if(opcion == 2) {
				/**
				 * Formulario para la insercion de nuevos usuarios a la BD
				 * */				
				do {
					System.out.println("Creacion de Nuevo Usuario");
					
					System.out.println("Ingrese el ID del Usuario Nuevo: ");
					datosU.setId(lector.nextInt());
					
					System.out.println("Ingrese el rol: ");
					datosU.setRol(lector1.nextLine());
					
					System.out.println("Ingrese el Nombre: ");
					datosU.setNombreU(lector2.nextLine());
					
					System.out.println("Ingrese el NIP: ");
					datosU.setNIPU(lector3.nextInt());
					
					System.out.println("Ingrese el numero de tarjeta: ");
					datosU.setNumTerjetaU(lector4.nextInt());
					
					System.out.println("Ingrese los fondos Iniciales: ");
					datosU.setFondosU(lector5.nextInt());
					
					registroU.insertarRegistro(datosU);
					
					System.out.println("Desea continuar? si=1, no=2");
					auth = lector.nextInt();
					
				}while(auth == 1);
				
			}else if(opcion == 3){
				System.out.println("\nToda la informacion del usuario seleccionado se modificará a ecepcion de sus Fondos");
				System.out.println("Ingrese el ID del usuario al que desea modificarle la informacion: ");
				id = lector.nextInt();
				
				System.out.println("Ingrese el Nuevo Nombre: ");
				nombre = lector1.nextLine();
				
				System.out.println("Ingrese el Nuevo NIP: ");
				nip = lector2.nextInt();
				
				System.out.println("Ingrese el Nuevo Numero de Tarjeta: ");
				numTarjeta = lector3.nextInt();
				
				actualizar.actualizarRegistro(id, nombre, nip, numTarjeta);
				
				datosU.setId(id);
				datosU = actualizar.selecionarPersona(datosU);
				System.out.println("\nDatos actualizados exitosamente");
				System.out.println("ID: "+datosU.getId()+", Nombre: "+datosU.getNombreU()+", NIP: "+datosU.getNIPU()+", Numero de Tajeta: "+datosU.getNumTerjetaU());
				
			} else if(opcion == 4) {
				/**
				 * Elimina a un usuario segun el ID ingresado, cuenta con "validacion"
				 * */
				System.out.println("Ingrese el ID del Usuario que desa Eliminar: ");
				elim = lector.nextInt();
				
				liUsua = registroU.seleccionarPersona();
				for (CrearUsuario usuario : liUsua) {
					if(usuario.getId() == elim) {
						System.out.println("\n¿Esta seguro de eliminar al usuario "+usuario.getNombreU()+"?");
						System.out.println("1.- Si     2.- No");
						opcion = lector.nextInt();
						flag = false;
						if(opcion == 1) {
							eliminar.eliminarRegistro(elim);
							System.out.println("Usuario Eliminado.");
							break;
						}else if(opcion == 2){
							System.out.println("Accion Cancelanda");
							break;
						}
						
					}
				}
				
				if(flag == true) {					
					System.out.println("El usuario con el ID "+elim+" no existe");
				}else {
					flag = true;
				}
				
			}else if(opcion == 5) {
				break;
			}
		
		}while(auth2 == 1);

	}
	
	private static void Usuario() {
		List<CrearUsuario> liUsua;
		MovimientosUsuario movimiento = new MovimientosUsuario();
		datosU = new CrearUsuario();
		registroU = new Registro();
		Scanner lector = new Scanner(System.in);
		int auth = 1;
		int opcion;
		String Nombre = "";
		int Id = ID, Saldo = 0, Retiro = 0, Deposito = 0;
		
		datosU.setId(Id);
		datosU = movimiento.selecionarPersona(datosU);
		
		while(auth == 1) {
			
			liUsua = registroU.seleccionarPersona();
			for (CrearUsuario usuario : liUsua) {
				if(usuario.getNIPU() == nip) {
					Id = usuario.getId();
					Nombre = usuario.getNombreU();
					Saldo = usuario.getFondosU();
				}
			}
			
			System.out.println("\n         Bienven1ido "+Nombre+"\n");
			
			System.out.println("////////////////////////////////////");
			System.out.println("/// Seleccione segun corresponda ///");
			System.out.println("///                              ///");
			System.out.println("///     1.- Saldo Actual         ///");
			System.out.println("///     2.- Retiro               ///");
			System.out.println("///     3.- Deposito             ///");
			System.out.println("///     4.- Salir                ///");
			System.out.println("////////////////////////////////////");
			opcion = lector.nextInt();
			
			if(opcion == 1) {
				
				System.out.println("\nSu saldo actual es de: $"+Saldo+" MXN\n");
				
				System.out.println("¿Desea realizar otra operacion?");
				System.out.println("     1.- SI      2.- NO        ");
				auth = lector.nextInt();
				
			}else if(opcion == 2) {
				
				System.out.println("\nIngrese la cantidad que desee retirar");
				Retiro = lector.nextInt();
				
				if(Retiro <= Saldo) {					
					Retiro = Saldo - Retiro;
					
					movimiento.Movimiento(Id, Retiro);
					
					System.out.println("Retiro realizado con exito");
					System.out.println("Su saldo actual es de $"+Retiro+" MXN");
					
					System.out.println("\n¿Desea realizar otra operacion?");
					System.out.println("     1.- SI      2.- NO        ");
					auth = lector.nextInt();
				}else {
					System.out.println("Los fondos que tiene actualmente es menor a lo que quiere retirar");
					System.out.println("Saldo actual $"+Saldo+" MXN");
				}
				
			}else if(opcion == 3) {
				
				System.out.println("\nIngrese la cantidad que desee depositar");
				Deposito = lector.nextInt();
				
				Deposito = Saldo + Deposito;
				
				movimiento.Movimiento(Id, Deposito);
				
				System.out.println("\nDeposito realizado con exito");
				System.out.println("Su saldo actual es de $"+Deposito+" MXN");
				
				System.out.println("\n¿Desea realizar otra operacion?");
				System.out.println("     1.- SI      2.- NO        ");
				auth = lector.nextInt();
				
			}else if(opcion == 4) {
				break;
			}else {
				System.out.println("\nEleccion inexistente, Elija de nuevo porfavor ...\n");
			}
			
		}
		
	}
	
}
