import java.util.Random;

public class Ahorcado {
	
	private String[] jugadores = new String[2];
 	private String[] palabras = new String[2];
	private String[] palabraA = new String[2];
	private Random ran;
	private byte[] intentos = new byte[2];
		
	/* para verificar en quien le toca, 
	 * true = el j1 tiene que adivinar la palabra del j2 
	 * false = el j2 tiene que adivinar la palabra del j1
	 */
	private boolean turno;
	
	private byte j1 = 0, j2 = 0;
	
	/*
	 * ganador: 
	 * 0= jugador1
	 * 1= jugador2
	 * 2 = empate
	 */
	private byte ganador;
	
	private byte[] pAcertadas = new byte[2];
	
	public Ahorcado(String jugador1, String jugador2, String palabra1, String palabra2){
				
		intentos[0] = 6;
		intentos[1] = 6;
		
		pAcertadas[0] = 0;
		pAcertadas[1] = 0;

		ran = new Random();
		
				
		jugadores[0] = jugador1;
		palabras[0] = palabra1;
		
		jugadores[1] = jugador2;
		palabras[1] = palabra2;
		
		
		palabraA[0] = "";
		palabraA[1] = "";
		
		for(int i = 0; i < palabra1.length(); i++){
			palabraA[0] += "*";
		}
		
		for(int i = 0; i < palabra2.length(); i++){
			palabraA[1] += "*";
		}
		
		turno = ran.nextBoolean();
		
		cambiarTurno();
		
	}
	
	public void juego(){
				 
		System.out.println("TURNO: " + jugadores[j1] + " | INTENTOS: " + intentos[j1]);
		
		System.out.print("Palabra a adivinar: " + palabraA[j2] + "\n");
		
	}
	
	public boolean arriesgar(String palabra){
		if(palabra.equals(palabras[j2])){
			pAcertadas[j1] = (byte) palabras[j2].length();
			return true;
		}else{
			intentos[j1] = 0;
			return false;
		}
			
	}
	
	public void ingresarLetra(char letra) {
		
		//boolean para saber si adivino una letra
		//si no adivino(false), se le descuenta un intento
		boolean siPalabra = false;
		
		String buscar = "";
		
		char[] bus = new char[palabras[j2].length()];
		
		for(int i = 0; i < palabras[j2].length(); i++){
			
			bus[i] = '*';
			
			if(palabraA[j2].charAt(i) != '*')
				bus[i] = palabraA[j2].charAt(i);
			
				
			if(palabras[j2].charAt(i) == letra){
				bus[i] = letra;
				siPalabra = true;
				pAcertadas[j1]++;
			}
			buscar += bus[i];			
		}
		
		palabraA[j2] = buscar;
		
		if(!siPalabra){
			intentos[j1]--;
			cambiarTurno();
		}
	}
	
	public void cambiarTurno(){
				
		if(turno){
			j1 = 0; j2 = 1;
			turno = false;
		}else{
			j1 = 1; j2 = 0;
			turno = true;
		}
	}
	
	public boolean ganador(){
		boolean winer = false, win1 = false, win2 = false;
		
		if(pAcertadas[0] == palabras[1].length())
			win1 = true;
		
		if(pAcertadas[1] == palabras[0].length())
			win2 = true;
		
		if(intentos[0] == 0 || win2){
			//gana el jugador2
			ganador = 1;
			winer = true;
		}
		
		if(intentos[1] == 0 || win1){
			//gana el jugador1
			ganador = 0;
			winer = true;
		}
		
		if(pAcertadas[0] == palabras[1].length() && pAcertadas[1] == palabras[0].length())
			ganador = 2;
		
		return winer;
	}
	
	public byte getGanador(){
		return ganador;
	}
	
	public String getNombre(byte n){
		return jugadores[n];
	}
	
	public String getJ2(){
		return jugadores[j2];
	}
	
	public String getJ1(){
		return jugadores[j1];
	}
	
	public String getPalabraA(){
		return palabraA[j1];
	}
}