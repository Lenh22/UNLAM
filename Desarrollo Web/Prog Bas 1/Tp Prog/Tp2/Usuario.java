public class Usuario{
//Atributos
	private String usuario;
	private String contraseña;
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
//Constructores
public Usuario (String usuario, String contraseña, String nombre, String apellido, int dni, int edad){
	this.usuario = usuario;
	this.contraseña=contraseña;
	this.nombre=nombre;
	this.apellido=apellido;
	this.dni=dni;
	this.edad=edad;
	}
//Metodos
 public String getUsuario(){
	 return this.usuario;
 }
 public String getContraseña(){
	 return this.contraseña;
 }
 public void setContrseña (String contraseña){
	this.contraseña = contraseña
 }
 public void setEdad (int edad){
	 this.edad = edad;
 }
} 
