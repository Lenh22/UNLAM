package ar.edu.unlam.eva02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConsecionariaLen {

	@Test
	public void testAlContado() {
		//Crear empresa
		String nombreEmpr = "Empresa";
		Empresa concesionaria = new Empresa(nombreEmpr);
		assertNotNull(concesionaria);
		
		//Crear auto
		Vehiculo tipoDeVehiculo = new Auto(TipoVehiculo.AUTO, 2345, "Falcon", Fabricante.FORD, 2020, false, 200.0,5,4);
		
		//Meter al garage
		Boolean agregar = concesionaria.ingresarVehiculo(tipoDeVehiculo);
		assertTrue(agregar);
		
		//Crear vendedor
		Vendedor vendedor= new Vendedor("nombreV", "apellidoV", 0001);
		assertNotNull(vendedor);
		
		//Crear cliente
		Cliente nuevoCliente = new Cliente("nombreC", "apellidoC", 123456);
		assertNotNull(nuevoCliente);
		
		//Comprar vehiculo al contado
		boolean comprar = nuevoCliente.comprarContado (tipoDeVehiculo, vendedor);
		assertTrue(comprar);
		
		}
		
		@Test
		public void testPagarcuotas() {
			//Crear empresa
			String nombreEmpr = "Empresa";
			Empresa concesionaria = new Empresa(nombreEmpr);
			assertNotNull(concesionaria);
			
			//Crear auto
			Vehiculo tipoDeVehiculo = new Auto(TipoVehiculo.AUTO, 2345, "Falcon", Fabricante.FORD, 2020, false, 200.0,5,4);
			
			//Meter al garage
			Boolean agregar = concesionaria.ingresarVehiculo(tipoDeVehiculo);
			assertTrue(agregar);
			
			//Crear vendedor
			Vendedor vendedor= new Vendedor("nombreV", "apellidoV", 0001);
			assertNotNull(vendedor);
			
			//Crear cliente
			Cliente nuevoCliente = new Cliente("nombreC", "apellidoC", 123456);
			assertNotNull(nuevoCliente);
			
			//PagarCuota
			
			for (int i = 1; i < 7; i++) {
				
				Integer cuotaQuePaga=i;
				Integer pagar1 = nuevoCliente.aniadirCuotaPagada();
				assertEquals(cuotaQuePaga, pagar1);
			}
			
			
			
			
			//Comprar vehiculo en cuotas
			boolean comprar1 =nuevoCliente.comprarCuotas (tipoDeVehiculo, vendedor);
			assertTrue(comprar1);
		}
		
//		@Test
//		public void testAlquilado() {
//			//Crear empresa
//			String nombreEmpr = "Empresa";
//			Empresa concesionaria = new Empresa(nombreEmpr);
//			assertNotNull(concesionaria);
//			
//			//Crear auto
//			Vehiculo tipoDeVehiculo = new Auto(TipoVehiculo.AUTO, 2345, "Falcon", Fabricante.FORD, 2020, false, 200.0,5,4);
//			
//			//Meter al garage
//			Boolean agregar = concesionaria.ingresarVehiculo(tipoDeVehiculo);
//			assertTrue(agregar);
//			
//			//Crear vendedor
//			Vendedor vendedor= new Vendedor("nombreV", "apellidoV", 0001);
//			assertNotNull(vendedor);
//			
//			//Crear cliente
//			Cliente nuevoCliente = new Cliente("nombreC", "apellidoC", 123456);
//			assertNotNull(nuevoCliente);
//			
//			//Alquilar vehiculo
//			Integer cantDeTiempo=3;
//				boolean alquilar= nuevoCliente.alquilar (tipoDeVehiculo, vendedor, cantDeTiempo);
//				assertTrue(alquilar);
//		}
		
		@Test
		public void testMostrarComprados() {
			//Crear empresa
			String nombreEmpr = "Empresa";
			Empresa concesionaria = new Empresa(nombreEmpr);
			assertNotNull(concesionaria);
			
			//Crear auto
			Vehiculo tipoDeVehiculo = new Auto(TipoVehiculo.AUTO, 2345, "Falcon", Fabricante.FORD, 1957, false, 200.0,5,4);
			Vehiculo tipoDeVehiculo1 = new Auto(TipoVehiculo.AUTO, 1234, "Fitito", Fabricante.FORD, 1955, false, 200.0,5,2);
			//Meter al garage
			Boolean agregar = concesionaria.ingresarVehiculo(tipoDeVehiculo);
			assertTrue(agregar);
			
			//Crear vendedor
			Vendedor vendedor= new Vendedor("nombreV", "apellidoV", 0001);
			assertNotNull(vendedor);
			
			//Crear cliente
			Cliente nuevoCliente = new Cliente("nombreC", "apellidoC", 123456);
			assertNotNull(nuevoCliente);
			
			//Comprar vehiculo al contado
			boolean comprar = nuevoCliente.comprarContado (tipoDeVehiculo, vendedor);
			assertTrue(comprar);
			
			boolean comprar1 = nuevoCliente.comprarContado(tipoDeVehiculo1, vendedor);
			assertTrue(comprar1);
			
			nuevoCliente.mostrarListaDeVehiculosComprados();
		
			
		}
//		@Test
//		public void testMostrarAlquilados() {
//			//Crear empresa
//			String nombreEmpr = "Empresa";
//			Empresa concesionaria = new Empresa(nombreEmpr);
//			assertNotNull(concesionaria);
//			
//			//Crear auto
//			Vehiculo tipoDeVehiculo = new Auto(TipoVehiculo.AUTO, 2345, "Falcon", Fabricante.FORD, 1957, false, 200.0,5,4);
//			Vehiculo tipoDeVehiculo1 = new Auto(TipoVehiculo.AUTO, 1234, "Fitito", Fabricante.FORD, 1955, false, 200.0,5,2);
//			//Meter al garage
//			Boolean agregar = concesionaria.ingresarVehiculo(tipoDeVehiculo);
//			assertTrue(agregar);
//			
//			//Crear vendedor
//			Vendedor vendedor= new Vendedor("nombreV", "apellidoV", 0001);
//			assertNotNull(vendedor);
//			
//			//Crear cliente
//			Cliente nuevoCliente = new Cliente("nombreC", "apellidoC", 123456);
//			assertNotNull(nuevoCliente);
//			
//			//Alquilar
//			Integer cantDeTiempo=3;
//			boolean alquilar= nuevoCliente.alquilar (tipoDeVehiculo, vendedor, cantDeTiempo);
//			assertTrue(alquilar);
//			
//			nuevoCliente.mostrarListaDeVehiculosAlquilados();
//		}
//		
	

}
