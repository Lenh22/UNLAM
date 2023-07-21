public class Punto{
//atributos
	private int ejeX;
	private int ejeY;
	
	public Punto(int x, int y ){
		this.ejeX = x;
		this.ejeY = y;
	}

	public void setCoordenadas(int x,int y ){
		this.ejeX = x;
		this.ejeY = y;
	}
	
	public int getCoordenadasX(){
		return this.ejeX;
	}
	
	public int getCoordenadasY(){
		return this.ejeY;
	}
	
	public String  ConsultaPunto(){
		if(this.ejeX!=0 && this.ejeY!=0){
			return "el eje esta entre el eje x y el eje y";
		}
			else{
				if (this.ejeX==0 && this.ejeY==0){
					return "el punto esta sobre el origen de las coordenadas";
				}
						else{
								if (this.ejeX!=0 && this.ejeY==0){
									return "el punto esta en el eje de las x";
								}
									else{
										return "el punto esta en el eje de las y"; 
									}			
			
							}
				
				
			}
	}



}