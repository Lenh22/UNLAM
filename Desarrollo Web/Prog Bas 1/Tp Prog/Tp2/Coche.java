public class Coche
{
//Atributos
	
	private int CERO_KM;
	private int ANO_ACTUAL;
	private static int cantidadCoches;
	private String marca;
	private double modelo;
	private int kilometro;
	private int ano;
	private double precio;
	
//Construcciones
public Coche (String marca, String modelo, double precio)
	{
	this.marca=marca;
	this.modelo=modelo;
	this.precio=precio;
	
	this.cantidadCoches++
	this.kilometros = kilometros;
	this.ano = ano;
	}
	public Coche(String marca, String modelo,int kilometros, int ano, double precio)
	{
	this.marca = marca;
	this.modelo = modelo;
	this.precio = precio;
	
	this.kilometros = kilometros;
	this.ano = ano;
	this.cantidadCoches++;
	}
//Metodos
	public static int getCantidadCoches()
	{
		return cantidadCoches;
	}
	public void setKilometros(int kilometros)
	{
		this.kilometros=kilometros;
	}
	public void setPrecio (int precio)
	{
		this.precio=precio;
	}
	public double getPrecio(){
	return this.precio;
	}
	public int calcularAntiguedad(){
		return this.ANO_ACTUAL - this.ano;
	}
	
	public int getKilometros(){
		return this.kilometros;
	}
	public void getDatos(){
		
	System.out.println("Marca: " + marca + "Modelo: " + modelo + "Kilometros: " + kilometros + "Ano: " + ano + "Precio del coche: " + precio);
		System.out.println("Cant de coches: " + cantidadCoches + " ");
		
}