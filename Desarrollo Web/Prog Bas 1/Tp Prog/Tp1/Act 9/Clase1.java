public class Clase1 
{	public static  void main (String args [])
	{
	int hdd = 1;
	double dvd = 8.5;
	double blueray = 25.0;
	double dvdhdd;
	double bluerayhdd;
	
	Final int unidad= 1024; //Punto 10, agrege "Final" para que sea constante
				//En vez de variable
		
		dvdhdd = ((hdd*unidad)/dvd);
		bluerayhdd =((hdd*unidad)/blueray);
		
	System.out.println ("Cant dvd disc rig: " + dvdhdd);
	System.out.println ("Cant blueray disc rig: " + bluerayhdd);
	
	}



}
//Dice que hay un error de compativilidad con los tipos de datos
//Haria unos cambios en los tipos de datos de int, pasarlos a double en "dvdhdd" y "bluerayhdd"