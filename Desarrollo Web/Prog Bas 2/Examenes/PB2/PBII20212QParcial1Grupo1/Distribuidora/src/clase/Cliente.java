package clase;

public class Cliente {

    private String nombre;
    private Integer cuil;
	private boolean mayorista;

    public Cliente(String nombre,Integer cuil) {
        this.nombre = nombre;
        this.cuil= cuil;
        this.mayorista=false;;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCuil() {
        return cuil;
    }

    public void setCuil(Integer cuil) {
        this.cuil = cuil;
    }
    

	public boolean isMayorista() {
		return mayorista;
	}

	public void setMayorista(boolean mayorista) {
		this.mayorista = mayorista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuil == null) ? 0 : cuil.hashCode());
		result = prime * result + (mayorista ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
// Lo comento para que no compare si las clases son distintas
//		if (getClass() != obj.getClass())
//			return false;
		Cliente other = (Cliente) obj;
		if (cuil == null) {
			if (other.cuil != null)
				return false;
		} else if (!cuil.equals(other.cuil))
			return false;
		if (mayorista != other.mayorista)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"nombre='" + nombre + '\'' +
				", cuil=" + cuil +
				", mayorista=" + mayorista +
				'}';
	}
}
