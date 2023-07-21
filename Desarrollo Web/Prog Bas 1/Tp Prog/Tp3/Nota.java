public class Nota{
//Atributo
	private float valor;
	private float nuevoValor;
	private boolean aprobado = true;
//Construcciones
	public Nota (float valor){
		this.valor=valor;
	}
//Metodo
	public float getValor(){
	return this.valor;
	}
	public boolean aprobado(){
	 if (this.valor<=7 && this.valor>=4)
	 { return this.aprobado = true; }
	 else
	 { return this.aprobado = false;}
	}
	 public void recuperar(float nuevoValor){
		this.valor=nuevoValor ;
	 }
	 public boolean promocionado(){
		return this.aprobado=true;
	 }
	}



