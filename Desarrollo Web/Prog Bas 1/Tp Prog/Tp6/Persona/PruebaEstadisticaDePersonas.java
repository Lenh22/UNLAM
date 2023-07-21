public class PruebaEstadisticaDePersonas {
	private double pesoPromedio;
	private int personaBajo;
	private int personaMedio;
	private int personaSobre;
	private double promedioEdadBajo;
	private double promedioEdadSobre;
	 private int nroDePersona=0;
	 private int bajo=0;
	 private int alto=0;

	
	public PruebaEstadisticaDePersonas (String nombre, int peso, double altura, int edad){
		double imc=0;
		while (nroDePersona<=50) {
			imc=peso/altura;
			System.out.println("Su IMC es:" + imc + " entonces...");
		//if	//
			if(18<imc&&imc<25) {
				System.out.println("\nPeso normal");
				personaMedio++;
			}else {
			if (imc<18) {
				System.out.println("\nPeso bajo");
				personaBajo++;
				bajo++;
			}	else {
				System.out.println("\nPeso alto");
				personaSobre++;
				alto++;
			}
			}
		//fin del if	//
		
			nroDePersona++;
		}
		promedioEdadBajo=bajo/nroDePersona;
		promedioEdadSobre=alto/nroDePersona;
			
	}
	public double getPromedioBajo() {
		System.out.println("Promedio de edad con bajo peso: "+ promedioEdadBajo);
		return promedioEdadBajo;
		}
	
	public double getPromedioAlto() {
		System.out.println("Promedio de edad con bajo peso: "+ promedioEdadSobre);
		return promedioEdadSobre;
		}
	public void getDatosPersonas() {
		System.out.println("Personas con bajo peso: "+ personaBajo +"\nPersonas con alto peso: "+personaSobre+"\nPersonas peso medio: "+personaMedio);
		return ;
		}
		
	
}
