package clase;


import java.util.Objects;

public class Producto {

   private String nombre;
   private Integer nLote;
//   private TipoApto tipoApto;
   private Double precio;

   private Integer cantidadDeProductosEnLaCaja;

    public Producto(String nombre, Integer nLote, Double precio, Integer cantidadDeProductosEnLaCaja) {
        this.nombre = nombre;
        this.nLote = nLote;
        this.precio = precio;

        this.cantidadDeProductosEnLaCaja = cantidadDeProductosEnLaCaja;
    }

    public Integer getCantidadDeProductosEnLaCaja() {
        return cantidadDeProductosEnLaCaja;
    }

    public void setCantidadDeProductosEnLaCaja(Integer cantidadDeProductosEnLaCaja) {
        this.cantidadDeProductosEnLaCaja = cantidadDeProductosEnLaCaja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getnLote() {
        return nLote;
    }

    public void setnLote(Integer nLote) {
        this.nLote = nLote;
    }


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return nombre.equals(producto.nombre) && nLote.equals(producto.nLote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nLote);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", nLote=" + nLote +
//                ", tipoApto=" + tipoApto +
                ", precio=" + precio +
                ", cantidadDeProductosEnLaCaja=" + cantidadDeProductosEnLaCaja +
                '}';
    }
}
