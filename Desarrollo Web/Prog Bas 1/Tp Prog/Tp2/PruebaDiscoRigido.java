public class PruebaDiscoRigido{
	public static void main (String [] arg){
		DiscoRigido seagate = new DiscoRigido ("seagate", 10);
		System.out.println ("Marca: " + seagate.getMarca() + " Tamaño: " + seagate.getTamano() + " Equivale a dvd: " + seagate.cantidadDeDvd() + " y de BlueRay: " + seagate.capacidadDeBlue());
		
		DiscoRigido hitachi= new DiscoRigido ("HItachi", 20);
		System.out.println ("Marca:" + hitachi.getMarca() + " Tamaño: " + hitachi.getTamano() + " Equivale a dvd: " + hitachi.cantidadDeDvd() + " y de BlueRay: " +   hitachi.capacidadDeBlue());
	
		DiscoRigido westernDigital= new DiscoRigido ("WesternDigital" , 32);
		System.out.println ("Marca:" + westernDigital.getMarca() + " Tamaño: " + westernDigital.getTamano() + " Equivale a dvd: " + westernDigital.cantidadDeDvd() + " y de BlueRay: " + westernDigital.capacidadDeBlue());
		
		DiscoRigido toshiba =new DiscoRigido ("Toshiba" , 48);
		System.out.println ("Marca:" + toshiba.getMarca() + " Tamaño: " + toshiba.getTamano() + " Equivale a dvd: " + toshiba.cantidadDeDvd() + " y de BlueRay: " + toshiba.capacidadDeBlue());
	}
}	