public class Letra{
	
	private char letra;
	private boolean esVocal;
	
			
	public void setLetra(char letra){
		this.letra = letra;
		switch(this.letra){
			case 'a':
				this.esVocal=true;
				break;
			case 'e':
				this.esVocal=true;
				break;
			case 'i':
				this.esVocal=true;
				break;
			case 'o':
				this.esVocal=true;
				break;
			case 'u':
				this.esVocal=true;	
				break;
			default: 
				this.esVocal=false;
				break;
		}
	}
	public char getLetra(){
		return this.letra;	
	}		
	
	public boolean getVocal(){
		return this.esVocal;	
	}		
}