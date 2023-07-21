public class Dia{
	
	private String dia;
	private int numeroDeDia;
	
	public void setDia(int numeroDeDia){
		this.numeroDeDia=numeroDeDia;
		switch(this.numeroDeDia){
			case 1:
				this.dia = "Domingo";
				break;
			case 2:
				this.dia = "Lunes";
				break;
			case 3:
				this.dia = "Martes";
				break;
			case 4:
				this.dia = "Miercoles";
				break;
			case 5:
				this.dia = "Jueves";
				break;
			case 6: 
				this.dia = "Viernes";
				break;
			case 7:
				this.dia = "Sabado";
				break;
			default:
				System.out.println("No se reconoce como dia wachin");
		}
	}
	public String getDia(){
		return this.dia;
	}
	
}
