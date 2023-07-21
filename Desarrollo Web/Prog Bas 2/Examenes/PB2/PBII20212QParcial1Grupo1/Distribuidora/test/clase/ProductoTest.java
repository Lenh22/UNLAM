package clase;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoTest {

    @Test
    public void queSePuedaAgregarUnLote(){
        Distribuidora distribuidora = new Distribuidora("Distribuidora");

        Producto pepa = new Producto("Pepa", 100, 1000.0,100);


        distribuidora.agregarLote(pepa);

        String NOMBRE_ESPERA = "Pepa";
        Integer NLOTE_ESPERADO = 100;
        assertEquals(NOMBRE_ESPERA,pepa.getNombre());
        assertEquals(NLOTE_ESPERADO,pepa.getnLote());



    }

    @Test
    public  void queSePuedaBuscarUnLotePorSuNumero () {
        Distribuidora distribuidora = new Distribuidora("Distribuidora");

        Producto pepa = new Producto("Pepa", 100, 1000.0,100);
        Producto oreo = new Producto("Oreo", 101, 1500.0,200);

        distribuidora.agregarLote(pepa);
        distribuidora.agregarLote(oreo);

        String NOMBRE_ESPERADO_PEPA = "Pepa";
        String NOMBRE_ESPERADO_OREO = "Oreo";
        Producto [] listaObtenida = distribuidora.getProductos();

        assertEquals(NOMBRE_ESPERADO_PEPA,listaObtenida[0].getNombre());
        assertEquals(NOMBRE_ESPERADO_OREO,listaObtenida[1].getNombre());
    }

    @Test
    public void queSePuedaAgregarUnLoteAlArrayDeLotesVendidos(){


        Distribuidora distribuidora = new Distribuidora("Distribuidora");
        Producto pepa = new Producto("Pepa", 100, 1000.0,100);
        Producto oreo = new Producto("Oreo", 101, 1500.0,200);

        distribuidora.agregarLote(pepa);
        distribuidora.agregarLote(oreo);

        String NOMBRE_ESPEADO = "Pepa";

        distribuidora.agregarLoteVendido(pepa);
        Producto [] listaObtenida = distribuidora.getProductosVendidos();


        assertEquals(NOMBRE_ESPEADO,listaObtenida[0].getNombre());
    }

    @Test
    public void queSePuedaVenderUnLote(){

        Cliente pablo = new Cliente("Pablo", 20);

        Distribuidora distribuidora = new Distribuidora("Distribuidora");
        Producto pepa = new Producto("Pepa", 100, 1000.0,100);
        Producto oreo = new Producto("Oreo", 101, 1500.0,200);

        distribuidora.agregarLote(pepa);
        distribuidora.agregarLote(oreo);

        distribuidora.agregarCLiente(pablo);

        String NOMBRE_ESPEADO = "Pepa";

        distribuidora.venderLote(100,20);
        Producto [] listaObtenida = distribuidora.getProductosVendidos();
        Producto [] listaObtenida2 = distribuidora.getProductos();

        assertEquals(NOMBRE_ESPEADO,listaObtenida[0].getNombre());
        assertNull(listaObtenida2[0]);

    }
    @Test
	public void queSePuedaVenderAMinoristaPocaCantidad() {
	
		Minorista len = new Minorista("Len", 20);
		Minorista b = new Minorista("B", 21);
		Mayorista c = new Mayorista("C", 22);

		Distribuidora distribuidora = new Distribuidora("Distribuidora");
		Producto pepa = new Producto("Pepa", 100, 100.0, 100);
		Producto oreo = new Producto("Oreo", 101, 100.0, 100);

		distribuidora.agregarLote(pepa);
		distribuidora.agregarLote(oreo);

		distribuidora.agregarCLiente(len);
		distribuidora.agregarCLiente(b);
		distribuidora.agregarCLiente(c);

		Cliente[] listaClientes = distribuidora.getClientes();
		assertEquals("B", listaClientes[1].getNombre());
		assertEquals("Len", listaClientes[0].getNombre());
		assertEquals("C", listaClientes[2].getNombre());

		Integer valorEsperado = 85;
		distribuidora.venderProductoPorUnidad(100, 20, 5);
		distribuidora.venderProductoPorUnidad(100, 20, 5);
		distribuidora.venderProductoPorUnidad(100, 21, 5);
		assertFalse(distribuidora.venderProductoPorUnidad(101, 22, 5));
		assertEquals(valorEsperado, pepa.getCantidadDeProductosEnLaCaja());

	}

    @Test
	public void queSePuedaVenderUnLoteAEmpleadoConDescuento() {


		Departamento departamento = new Departamento("DepartamentoNombre");
		Empleado len = new Gerente("Len", 20, departamento);
		Empleado k = new Administrativo("K", 19, departamento);
		Empleado u = new Operativo("U", 11, departamento);

		Distribuidora distribuidora = new Distribuidora("Distribuidora");
		Producto pepa = new Producto("Pepa", 100, 100.0, 100);
		Producto oreo = new Producto("Oreo", 101, 100.0, 200);
		Producto rueditas = new Producto("Rueditas", 102, 100.0, 300);

		distribuidora.agregarLote(pepa);
		distribuidora.agregarLote(oreo);
		distribuidora.agregarLote(rueditas);

		distribuidora.agregarEmpleado(len);
		distribuidora.agregarEmpleado(k);
		distribuidora.agregarEmpleado(u);

		assertTrue(distribuidora.venderLoteAEmpleado(100, len));
		assertTrue(distribuidora.venderLoteAEmpleado(102, k));
		assertTrue(distribuidora.venderLoteAEmpleado(101, u));

		Producto[] listaObtenida = distribuidora.getProductosVendidos();
		Producto[] listaObtenida2 = distribuidora.getProductos();

		Double precioEsperadoLen = 100 * 0.85;
		Double precioEsperadoK = 100 * 0.9;
		Double precioEsperadoU = 100 * 0.95;

		assertEquals(precioEsperadoLen, listaObtenida[0].getPrecio());
		assertEquals(precioEsperadoK, listaObtenida[1].getPrecio());
		assertEquals(precioEsperadoU, listaObtenida[2].getPrecio());

		assertNull(listaObtenida2[0]);

	}









}
