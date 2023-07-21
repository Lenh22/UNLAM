import java.util.Scanner;

public class Password {
	private String contraseña;
	private int longMax8;
	private int longitudDeseada=8;
	
	public Password (String contra) {
		this.longMax8=contra.length();
		if(longMax8<=longitudDeseada && 0<longMax8) {
			this.contraseña=contra;
			}else {System.out.println("Contraseña no valida");}
	}
	public String generarPassword(String contra) {
		System.out.print("Genere nueva contraseña de max "+longitudDeseada+" :");
		this.longMax8=contra.length();
		if(longMax8<=longitudDeseada && 0<longMax8) {
			this.contraseña=contra;
			}else {System.out.println("Contraseña no valida");}
	return contra;
	}
	public void getContraLong() {
		System.out.println("La contraseña es: "+this.contraseña+ "\nLa longitud es: "+this.longMax8);
	}
	public int getLongitud(int longi) {
		this.longitudDeseada=longi;
		if(longitudDeseada<=8 &&0<longitudDeseada) {
			this.longitudDeseada=longi;
			System.out.println("Ha sido cambiado");
		}else {
			System.out.println("No es posible ese cambio, volvera a la predeterminada");
			this.longitudDeseada=8;}
		return longitudDeseada;
	}
		
	
	
	
	
////EL MAIN
	public static void main (String []arg) {
		String contraseña;
		int cambioLong;

		Scanner teclado=new Scanner (System.in);
		
		Password con=new Password("A1234567");
		
		con.generarPassword("Prueba01");
		System.out.print("Escriba la contraseña max 8 caracteres: ");
		contraseña=teclado.next();
		Password contra=new Password(contraseña);
		con.getContraLong();
		System.out.println("Elija la longitud para cambiar entre 0 a 8");
		cambioLong=teclado.nextInt();
		con.getLongitud(cambioLong);
		
		
	
		
	}
}
