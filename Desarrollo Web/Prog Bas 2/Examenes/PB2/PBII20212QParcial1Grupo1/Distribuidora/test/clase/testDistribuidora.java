package clase;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDistribuidora {

	@Test
	public void queSePuedaAgregarUnEmpleado() {
		Departamento nuevoDepto = new Departamento("finanzas");
		Empleado nuevo = new Gerente("haziel", 419284, nuevoDepto);
		Empleado nuevo2 = new Administrativo("mario", 419288, nuevoDepto);

		Distribuidora nueva = new Distribuidora("Fargo");

		nueva.agregarEmpleado(nuevo);
		nueva.agregarEmpleado(nuevo2);

		Empleado[] listaDeEmpleados = nueva.getEmpleados();
		String valorEsperado = "haziel";
		String valorEsperado2 = "mario";

		assertEquals(valorEsperado, listaDeEmpleados[0].getNombre());
		assertEquals(valorEsperado2, listaDeEmpleados[1].getNombre());

	}

	@Test
	public void queNosePuedaAgregarUnEmpleadoRepetido() {

		Departamento nuevoDepto = new Departamento("finanzas");
		Empleado nuevo = new Gerente("haziel", 419284, nuevoDepto);
		Empleado nuevo2 = new Administrativo("haziel", 419284, nuevoDepto);
		Distribuidora nueva = new Distribuidora("Fargo");

		nueva.agregarEmpleado(nuevo);
		nueva.agregarEmpleado(nuevo2);
		Empleado valorEsperado = null;
		Empleado[] listaDeEmpleados = nueva.getEmpleados();

//metodo arreglado, era borrar el getClass en el equals generado en la clase empleado

		assertEquals(valorEsperado, listaDeEmpleados[1]);

	}

	@Test
	public void queSePuedaDespedirUnEmpleado() {
		Departamento nuevoDepto = new Departamento("finanzas");
		Empleado nuevo = new Gerente("haziel", 419284, nuevoDepto);
		Distribuidora nueva = new Distribuidora("Fargo");
		nueva.agregarEmpleado(nuevo);
		nueva.despedirEmpleado(nuevo);
		Empleado[] listaDeEmpleadosDespedidos = nueva.getEmpleadosDespedidos();
		Empleado[] listaDeEmpleados = nueva.getEmpleados();
		String valorEsperado = "haziel";

		assertEquals(valorEsperado, listaDeEmpleadosDespedidos[0].getNombre());
		assertEquals(null, listaDeEmpleados[0]);
		
	}

	@Test
	public void queSePuedaEliminarUnCliente() {
		Distribuidora distribuidora = new Distribuidora("NombreDistri");
		Cliente len = new Cliente("Len", 22);
		Cliente k = new Cliente("K", 19);

		distribuidora.agregarCLiente(len);
		distribuidora.agregarCLiente(k);

		distribuidora.eliminarCliente(k);
		distribuidora.eliminarCliente(len);

		Empleado[] listaEmpleados = distribuidora.getEmpleados();

		assertEquals(null, listaEmpleados[0]);
		assertNull(listaEmpleados[1]);

	}

	@Test
	public void queSePuedaCalcularSueldoDeEmpleados() {
		Departamento departamento = new Departamento("DepartamentoNombre");
		Empleado len = new Gerente("Len", 20, departamento);
		Empleado k = new Administrativo("K", 19, departamento);
		Empleado u = new Operativo("U", 11, departamento);

		Distribuidora nueva = new Distribuidora("Wawa");

		nueva.agregarEmpleado(len);
		nueva.agregarEmpleado(k);
		nueva.agregarEmpleado(u);

		Double sueldoEsperadoLen = len.getSueldoBase() + 4000.0;
		Double sueldoEsperadoK = k.getSueldoBase() + (k.getSueldoBase() * 0.05);
		Double sueldoEsperadoU = u.getSueldoBase() + (u.getSueldoBase() * 0.1);

		assertEquals(sueldoEsperadoLen, len.calcularSueldo(), 0.01);
		assertEquals(sueldoEsperadoK, k.calcularSueldo(), 0.01);
		assertEquals(sueldoEsperadoU, u.calcularSueldo(), 0.01);
	}

	@Test
	public void queSeCalculeElTotalDeSueldos() {

		Distribuidora nueva = new Distribuidora("Wawa");
		Departamento departamento = new Departamento("DepartamentoNombre");
		Empleado len = new Gerente("Len", 20, departamento);
		Empleado k = new Administrativo("K", 19, departamento);
		Empleado u = new Operativo("U", 11, departamento);

		nueva.agregarEmpleado(len);
		nueva.agregarEmpleado(k);
		nueva.agregarEmpleado(u);

		Double sueldoEsperadoLen = len.getSueldoBase() + 4000.0;
		Double sueldoEsperadoK = k.getSueldoBase() + (k.getSueldoBase() * 0.05);
		Double sueldoEsperadoU = u.getSueldoBase() + (u.getSueldoBase() * 0.1);

		Double sueldoEsperadoTotal = (sueldoEsperadoK + sueldoEsperadoLen + sueldoEsperadoU);

		assertEquals(sueldoEsperadoLen, len.calcularSueldo(), 0.01);
		assertEquals(sueldoEsperadoK, k.calcularSueldo(), 0.01);
		assertEquals(sueldoEsperadoU, u.calcularSueldo(), 0.01);
		assertEquals(sueldoEsperadoTotal, nueva.calcularSueldoTotalDeEmpleados(), 0.01);

	}

	@Test
	public void queSePuedaAgregarUnCliente() {
		Distribuidora distribuidora = new Distribuidora("Distribuidora");
		Cliente pablo = new Cliente("Pablo", 20);
		Cliente len = new Cliente("Len", 21);

		distribuidora.agregarCLiente(pablo);
		distribuidora.agregarCLiente(len);

		Cliente[] listaObtenida = distribuidora.getClientes();

		String NOMBRE_ESPERADO = "Pablo";
		Integer CUIL_ESPERADO = 20;
		assertEquals(NOMBRE_ESPERADO, listaObtenida[0].getNombre());
		assertEquals(CUIL_ESPERADO, listaObtenida[0].getCuil());

		assertEquals("Len", listaObtenida[1].getNombre());
		assertEquals(21, listaObtenida[1].getCuil(), 0.1);

	}

	@Test
    public void queNoSePuedaAgregarDosClientesConMismoCuil() {
        Distribuidora distribuidora = new Distribuidora("NombreDistri");
        Cliente len = new Cliente("Len", 22);
        Cliente k = new Cliente("K", 22);


        distribuidora.agregarCLiente(len);
        distribuidora.agregarCLiente(k);
        Integer VALOR_ESPERADO = 22;
        Cliente VALOR_ESPERADO_DOS = null;

        Cliente [] listaObtenida = distribuidora.getClientes();

        assertEquals(VALOR_ESPERADO,listaObtenida[0].getCuil());
        assertEquals(VALOR_ESPERADO_DOS,listaObtenida[1]);

    }

	@Test
	public void queSePuedaBuscarUnClientePorSuCuil() {
		Distribuidora distribuidora = new Distribuidora("Distribuidora");
		Cliente pablo = new Cliente("Pablo", 20);

		distribuidora.agregarCLiente(pablo);

		Integer CUIL_ESPERADO = 20;
		Cliente listObtenida = distribuidora.buscarCliente(20);

		assertEquals(CUIL_ESPERADO, listObtenida.getCuil());

	}
	@Test
    public void queSeOrdenenClientesSegunSuDni(){
        Distribuidora distribuidora = new Distribuidora("NombreDistri");
        Cliente len = new Cliente("Len", 22);
        Cliente k = new Cliente("K", 21);

        distribuidora.agregarCLiente(len);
        distribuidora.agregarCLiente(k);

        distribuidora.ordenarClientesSegunSuCuil();
        Cliente [] listaObtenida = distribuidora.getClientes();

        Integer VALOR_ESPERADO = 21;

        assertEquals(VALOR_ESPERADO, listaObtenida[0].getCuil());

    }

	@Test
    public void queSeOrdenenClientessSegunSuCuil(){
        Distribuidora distribuidora = new Distribuidora("NombreDistri");
        Departamento finanzas = new Departamento("Finanzas");
        Empleado len = new Gerente("Len", 22,finanzas);
        Empleado k = new Gerente("K", 21,finanzas);

        distribuidora.agregarEmpleado(len);
        distribuidora.agregarEmpleado(k);

        distribuidora.ordenarEmpleadosContratados();
        Empleado [] listaObtenida = distribuidora.getEmpleados();

        Integer VALOR_ESPERADO = 21;

        assertEquals(VALOR_ESPERADO, listaObtenida[0].getCuil());

    }
}
