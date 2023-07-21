public class Ascensor {
	private int PISO_MAXIMO;
	private int PISO_MINIMO;
	private double PESO_MAXIMO;
	private int CAPACIDAD_MAXIMA;
	
	private boolean puertaAbierta=false;
	private boolean sobrecarga=false;
	private long pisoActual;
	private double pesoActual;
	private int capacidadActual;
	private Persona ocupantes;
	
	public Ascensor (int capacidadMaxima,double pesoMaximo, int pisoMax , int pisoMin) {
		this.CAPACIDAD_MAXIMA=capacidadMaxima;
		this.PESO_MAXIMO=pesoMaximo;
		this.PISO_MAXIMO=pisoMax;
		this.PISO_MINIMO=pisoMin;
		pisoActual=0;
		this.capacidadActual=0;
		this.pesoActual=0;
		}
	public void ingresar(Persona elQueSube) {
		if(this.puertaAbierta==true) {
			this.capacidadActual++;
			this.ocupantes=elQueSube;
			double valor=elQueSube.pesar();
			this.pesoActual=this.pesoActual+valor;
			if(this.pesoActual>this.PESO_MAXIMO&&this.capacidadActual>this.CAPACIDAD_MAXIMA) {
				this.sobrecarga=true;
			}else {this.sobrecarga=false;
			}	
		}else {
			this.puertaAbierta=false;
		}
		
	}
	
	public void salir(Persona elQueBaja) {
		if(this.puertaAbierta==true) {
			this.capacidadActual--;
			this.ocupantes=elQueBaja;
			double valor=elQueBaja.pesar();
			this.pesoActual=this.pesoActual-valor;
			if(this.pesoActual<this.PESO_MAXIMO) {
				this.sobrecarga=false;
				}else {this.sobrecarga=true;
				}
		}
	}
	
	
	public void abrirPuerta() {
		puertaAbierta=true;
		}
	public void cerrarPuerta() {
		puertaAbierta=false;
	}
	public void subir() {
		if (PISO_MINIMO<=(int)pisoActual && (int)pisoActual<=PISO_MAXIMO &&this.sobrecarga==false) {
			pisoActual++;	
		}else {System.out.println("Esta en el piso Maximo");}
	}
	public void bajar() {
		if (this.sobrecarga==false && PISO_MINIMO<=(int)pisoActual && (int)pisoActual<=PISO_MAXIMO) {
			pisoActual--;
		}else {System.out.println("Esta en el piso Minimo");}
	}
	
	public void irAlPiso(int pisoDeseado) {
		while (PISO_MINIMO<=(int)pisoDeseado && (int)pisoDeseado<=PISO_MAXIMO) {
			pisoActual=pisoDeseado;
			System.out.println("Deseo ir al piso"+pisoDeseado);
			}
	}
	
	public int getPisoActual() {
		System.out.println("Piso actual: "+pisoActual);
		return (int) pisoActual;
	}
	
	
}