public class PartidoDeTenis{
	
	private String persona1;
	private String persona2;
	
	
	private int ganador1;
	private int ganador2;
	private int set1persona1;
	private int set1persona2;
	private int set2person1;
	private int set2persona2;
	private int set3persona1;
	private int set3persona2;
	
	public PartidoDeTenis(String n1, String n2){
		
		persona1 = n1;
		persona2 = n2;
		
	}
	
	public void set1(int p1, int p2){
		set1persona1 = p1;
		set1persona2 = p2;
		
		if(p1 > p2) {
			ganador1++;}
		else {
			ganador2++;}
	}
	
	public void set2(int p1, int p2){
		set2person1 = p1;
		
		set2persona2 = p2;
		
		if(p1 > p2) {
			ganador1++;}
		else {
			ganador2++;}
	}
	
	public void set3(int p1, int p2){
		set3persona1 = p1;
		set3persona2 = p2;
		
		if(p1 > p2) {
			ganador1++;}
		else {
			ganador2++;}
	}
	
	public void mostrarJuego(){
		System.out.println("Partido de tenis entre: " + persona1 + " y " + persona2);
		System.out.println("Set 1 :"+ persona1 +" " + set1persona1 + " "+persona2+": " + set1persona2);
		System.out.println("Set 2 :"+ persona1 +" " + set2person1 + " "+persona2+": " + set2persona2);
		System.out.println("Set 3 :"+ persona1 +" " + set3persona1 + " "+persona2+": " + set3persona2);
		
		if(ganador1>ganador2)
			System.out.println("Ganador: " + persona1);
		else
			System.out.println("Ganador: " + persona2);
	}
	
	
	
}