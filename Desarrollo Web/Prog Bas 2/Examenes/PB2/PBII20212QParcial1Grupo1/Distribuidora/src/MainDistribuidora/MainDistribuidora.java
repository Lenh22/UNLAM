package MainDistribuidora;

import clase.*;

import java.util.Scanner;

public class MainDistribuidora {
    static final Scanner teclado = new Scanner(System.in);

    static String nombre;
    static Integer numLote;
    static Double precio;
    static Integer cuil;
    static Integer cantidadDeProductosEnLaCaja;

    static final int VOLVER_ATRAS = 9;

    static final int SALIR = 0;
    static final int GESTIONAR_CLIENTES = 1;
    static final int GESTIONAR_PRODUCTOS = 2;
    static final int GESTIONAR_EMPLEADOS = 3;
    

    static final int REGISTRAR_LOTE = 1;
    static final int VENDER_LOTE = 2;
    static final int BUSCAR_LOTE = 3;
    static final int LOTES_VENDIDOS = 4;
    static final int LOTES_EN_STOCK = 5;

    static final int VENDER_LOTE_A_MAYORISTA = 1;
    static final int VENDER_PRODUCTO_A_MINORISTA = 2;
    static final int VENDER_LOTE_A_EMPLEADO = 3;

    static final int REGISTRAR_EMPLEADO = 1;
    static final int ELIMINAR_EMPLEADO = 2;
    static final int BUSCAR_EMPLEADO = 3;
    static final int MOSTRAR_EMPLEADOS_CONTRATADOS = 4;
    static final int MOSTRAR_EMPLEADOS_DESPEDIDOS = 5;

    static final int REGISTRAR_GERENTE = 1;
    static final int REGISTRAR_ADMINISTRATIVO = 2;
    static final int REGISTRAR_OPERARIO = 3;

    static final int AGREGAR_FINANZAS = 1;
    static final int AGREGAR_ADMINISTRATIVO = 2;
    static final int AGREGAR_OPERATIVO = 3;

    static final int REGISTRAR_CLIENTE = 1;
    static final int ELIMINAR_CLIENTE = 2;
    static final int BUSCAR_CLIENTE = 3;
    static final int MOSTRAR_CLIENTES = 4;

    static final int AGREGAR_MAYORISTA= 1;
    static final int AGREGAR_MINORISTA= 2;


    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora("Fangio");
        Departamento finanza = new Departamento("Departamento Finanzas", null);
        Departamento administrativo = new Departamento("Departamento administrativo", null);
        Departamento operativo = new Departamento("Departamento operativo");
        int opcionDeseada = 0;

        System.out.println("Bienvenidx al sistema de gestion de la distribuidra\n " + distribuidora.getNombre());

        do {
            opcionDeseada = menuPrincipal();
            switch (opcionDeseada) {
                case GESTIONAR_PRODUCTOS:
                    gestionDeProductos(distribuidora);
                    break;

                case GESTIONAR_EMPLEADOS:
                    opcionDeseada = gestionarEmpleados(distribuidora, finanza, administrativo, operativo);
                    break;

                case GESTIONAR_CLIENTES:
                    opcionDeseada = gestionarCliente(distribuidora);
                    break;

                case SALIR :
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opcionDeseada != SALIR);
        System.out.println("Adios.");


    }

    private static int gestionarCliente(Distribuidora distribuidora) {
        int opcionDeseada;
        System.out.println("1- Para registrar Cliente");
        System.out.println("2- Para eliminar cliente");
        System.out.println("3- Buscar cliente");
        System.out.println("4- Mostrar clientes ");
        opcionDeseada = teclado.nextInt();
        switch (opcionDeseada) {
            case REGISTRAR_CLIENTE:
                registrarCliente(distribuidora);
                break;
            case ELIMINAR_CLIENTE:
                eliminarCliente(distribuidora);
                break;
            case BUSCAR_CLIENTE:
                buscarCliente(distribuidora);
            case MOSTRAR_CLIENTES:
                mostrarClientes(distribuidora);
                break;


        }
        return opcionDeseada;
    }

    private static void mostrarClientes(Distribuidora distribuidora) {
       distribuidora.ordenarClientesSegunSuCuil();
        Cliente [] clientesEncontrados = distribuidora.clientes();
        if (clientesEncontrados != null){
            for (int i = 0; i < clientesEncontrados.length; i++) {
                if (clientesEncontrados[i] != null) {
                    System.out.println(clientesEncontrados[i].toString());
                }
            }
        } else {
            System.out.println("No se encontraron empleados");
        }
    }

    private static void buscarCliente(Distribuidora distribuidora) {
        System.out.println("Ingrese el cuil del cliente a buscar");
        cuil = teclado.nextInt();

        Cliente sebuscoCLiente = distribuidora.buscarCliente(cuil);
        if (sebuscoCLiente !=null){
            System.out.println(sebuscoCLiente);
        }else
        {
            System.out.println("No se pudo crear el cliente");
        }
        return;
    }

    private static void eliminarCliente(Distribuidora distribuidora) {
        System.out.println("Ingrese el cuil del cliente ");
        cuil = teclado.nextInt();

        Cliente seBusco = distribuidora.buscarCliente(cuil);
        if (seBusco !=null){
            Boolean seElimino = distribuidora.eliminarCliente(seBusco);
            if (seElimino ==true) {
                System.out.println("Se pudo eliminar");
            }else {
                System.out.println("No se pudo vender el producto");
            }
        }else{
            System.out.println("No se encontro el cliente");
        }
    }

    private static void registrarCliente(Distribuidora distribuidora) {
        int opcionDeseada;
        System.out.println("Ingrese el nombre ");
        nombre = teclado.next();

        System.out.println("Ingrese el cuil");
        cuil = teclado.nextInt();
        //do {
            System.out.println("1- Para agregar Mayorista");
            System.out.println("2- Para agregar Minorista");
            opcionDeseada = teclado.nextInt();
            switch (opcionDeseada){
                case AGREGAR_MAYORISTA:
                    Cliente mayorista = new Mayorista( nombre,cuil);

                    Boolean seAgregoMayorista = distribuidora.agregarCLiente(mayorista);
                    if (seAgregoMayorista = true){
                        System.out.println("Se pudo crear el cliente mayorista con cuil : " + cuil);
                    }else {
                        System.out.println("No se pudo crear el cliente.");
                    }

                    break;

                case AGREGAR_MINORISTA:
                    Cliente minorista = new  Minorista( nombre,cuil);

                    Boolean seAgregoMinorista = distribuidora.agregarCLiente(minorista);
                    if (seAgregoMinorista = true){
                        System.out.println("Se pudo crear el cliente mayorista con cuil : " + cuil);
                    }else {
                        System.out.println("No se pudo crear el cliente.");
                    }
                    break;

            }


      //  }while (opcionDeseada != VOLVER_ATRAS);
    }

    private static int gestionarEmpleados(Distribuidora distribuidora, Departamento finanza, Departamento administrativo, Departamento operativo) {
        int opcionDeseada;
        //do {
            opcionDeseada = menuGestionEmpleados();
            switch (opcionDeseada) {
                case REGISTRAR_EMPLEADO:
                    registrarEmpleado(distribuidora, finanza, administrativo, operativo);
                    break;

                case ELIMINAR_EMPLEADO:
                    eliminarEmpleado(distribuidora);
                    break;

                case BUSCAR_EMPLEADO:
                    buscarEmpleado(distribuidora);
                    break;

                case MOSTRAR_EMPLEADOS_CONTRATADOS:
                    mostrarEmpleados(distribuidora);
                    break;

                case MOSTRAR_EMPLEADOS_DESPEDIDOS:
                    mostrarEmpleadosDespedidos(distribuidora);
                    break;

                default:
                    System.out.println("Opcion  Incorrecta");
            }


        //} while (opcionDeseada != VOLVER_ATRAS);

    return opcionDeseada;
}


    private static void mostrarEmpleadosDespedidos(Distribuidora distribuidora) {
        Empleado [] empleadosDespedidos = distribuidora.empleadosDespedidos();
        if (empleadosDespedidos!= null){
            for (int i = 0; i < empleadosDespedidos.length; i++) {
                if (empleadosDespedidos[i] != null) {
                    System.out.println(empleadosDespedidos[i].toString());
                }
            }
        } else {
            System.out.println("No se encontraron empleados");
        }
    }

    private static void mostrarEmpleados(Distribuidora distribuidora) {
     distribuidora.ordenarEmpleadosContratados();
        Empleado[] contratados = distribuidora.empleadosContratados();
        if (contratados != null) {
            for (int i = 0; i < contratados.length; i++) {
                if (contratados[i] != null) {
                    System.out.println(contratados[i].toString());
                }
            }
        } else {
            System.out.println("No se encontraron empleados despedidos");
        }
    }

    private static void buscarEmpleado(Distribuidora distribuidora) {
        System.out.println("Ingrese el cuil del empleado a buscar");
        cuil = teclado.nextInt();

        Empleado seBusco = distribuidora.buscarEmpleado(cuil);
        if (seBusco != null){
            System.out.println(seBusco);
        }else {
            System.out.println("No se encontro el empleado");
        }
        return;
    }

    private static void eliminarEmpleado(Distribuidora distribuidora) {
        System.out.println("Ingrese el cuil del empleado");
        cuil = teclado.nextInt();
        Empleado seBusco = distribuidora.buscarEmpleado(cuil);
        if (seBusco !=null){
            distribuidora.despedirEmpleado(seBusco);
            System.out.println("Se pudo eliminar correctamente el empleado");
        }else{
            System.out.println("No se encuentra el empleado");
        }
    }

    private static void registrarEmpleado(Distribuidora distribuidora, Departamento finanza, Departamento administrativo, Departamento operativo) {
        int opcionDeseada;
        do {
            opcionDeseada = registrarEmpleadoTIpo();
            switch (opcionDeseada) {
                case REGISTRAR_GERENTE:
                    agregarGerenteAtipoDepartamento(distribuidora, finanza, administrativo, operativo);
                   opcionDeseada = VOLVER_ATRAS;
                    break;

                case REGISTRAR_ADMINISTRATIVO:
                    registrarAdministrativoAtipoDepartamento(distribuidora, finanza, administrativo);
                    break;

                case REGISTRAR_OPERARIO:

                    registrarOperario(distribuidora, operativo);

                    break;
                case VOLVER_ATRAS:
                    break;

            }

       }while (opcionDeseada != VOLVER_ATRAS);
    }

    private static void registrarOperario(Distribuidora distribuidora, Departamento operativo) {
        System.out.println("Ingrese el nombre");
        nombre  = teclado.next();

        System.out.println("Ingrese el cuil");
        cuil  = teclado.nextInt();
        Empleado operario = new Operativo(nombre,cuil, operativo);
        Boolean seAgrego = distribuidora.agregarEmpleado(operario);
        if (seAgrego == true){
            System.out.println("Se agrego el empleado con cuil: " + cuil + " al departemento " + operativo.getNombre());
        }
        else {
            System.out.println("No se pudo agregar el empleado");
        }
    }

    private static void registrarAdministrativoAtipoDepartamento(Distribuidora distribuidora, Departamento finanza, Departamento administrativo) {
        int opcionDeseada;
        System.out.println("Ingrese el nombre");
        nombre  = teclado.next();

        System.out.println("Ingrese el cuil");
        cuil  = teclado.nextInt();

            System.out.println("Ingrese el departamento al cual quiere enviarlo");
            System.out.println("1- Departamento de finanzas");
            System.out.println("2- Departamento administrativo ");
            opcionDeseada = teclado.nextInt();
            switch (opcionDeseada){
                case AGREGAR_FINANZAS:
                    agregarAdministrativoFinanzas(distribuidora, finanza);
                    break;

                case AGREGAR_ADMINISTRATIVO :
                    agregarAdministrativo(distribuidora, administrativo);
                    break;

                case VOLVER_ATRAS:
                    break;

            }

    }

    private static void agregarAdministrativo(Distribuidora distribuidora, Departamento administrativo) {
        Empleado empleadoAdministrativo = new Administrativo(nombre, cuil, administrativo);
        Boolean seAgregoAdministrativo = distribuidora.agregarEmpleado(empleadoAdministrativo);
        if (seAgregoAdministrativo == true) {
            System.out.println("Se agrego el empleado con cuil: " + cuil + " al departemento " + administrativo.getNombre());
        }
    }

    private static void agregarAdministrativoFinanzas(Distribuidora distribuidora, Departamento finanza) {
        Empleado AdministrativoFinanzas = new Administrativo(nombre, cuil, finanza);
        Boolean seAgregoFinanzas = distribuidora.agregarEmpleado(AdministrativoFinanzas);
        if (seAgregoFinanzas == true) {
            System.out.println("Se agrego el empleado con cuil: " + cuil + " al departemento " + finanza.getNombre());
        }
    }

    private static void agregarGerenteAtipoDepartamento(Distribuidora distribuidora, Departamento finanza, Departamento administrativo, Departamento operativo) {
        int opcionDeseada;
       // do {
        System.out.println("Ingrese el nombre");
        nombre = teclado.next();

        System.out.println("Ingrese el numero de cuil");
        cuil = teclado.nextInt();


            System.out.println("Ingrese el departamento al cual quiere enviarlo");
            System.out.println("1- Departamento de finanzas");
            System.out.println("2- Departamento administrativo ");
            System.out.println("3- Departamento operativo ");
            opcionDeseada = teclado.nextInt();
            switch (opcionDeseada){
                case AGREGAR_FINANZAS:
                    agregarGerenteFinanzas(distribuidora, finanza);
                    break;

                case AGREGAR_ADMINISTRATIVO :
                    agregarGerenteAdministrativo(distribuidora, administrativo);
                    break;

                case AGREGAR_OPERATIVO:
                    agregarGerenteOperativo(distribuidora, operativo);
                    break;
            }

       // }while( opcionDeseada !=VOLVER_ATRAS);
    }

    private static int registrarEmpleadoTIpo() {
        int opcionDeseada;
        System.out.println("1. Para registar un Gerente");
        System.out.println("2. Para registar un AdminIstrativo");
        System.out.println("3. Para registar un Operario ");
        System.out.println("9. Volver atras ");
        opcionDeseada = teclado.nextInt();
        return opcionDeseada;
    }

    private static void agregarGerenteOperativo(Distribuidora distribuidora, Departamento operativo) {
        Empleado gerenteAdministrativo = new Gerente(nombre, cuil, operativo);
        Boolean seAgregoOperativo = distribuidora.agregarEmpleado(gerenteAdministrativo);
        if (seAgregoOperativo == true) {
            System.out.println("Se agrego el empleado con cuil: " + cuil + " al departemento " + operativo.getNombre());
        }
    }

    private static void agregarGerenteAdministrativo(Distribuidora distribuidora, Departamento administrativo) {
        Empleado gerenteAdministrativo = new Gerente(nombre, cuil, administrativo);
        Boolean seAgregoAdministrativo = distribuidora.agregarEmpleado(gerenteAdministrativo);
        if (seAgregoAdministrativo == true) {
            System.out.println("Se agrego el empleado con cuil: " + cuil + " al departemento " + administrativo.getNombre());
        }
    }

    private static void agregarGerenteFinanzas(Distribuidora distribuidora, Departamento finanza) {
        Empleado gerenteFinanzas = new Gerente(nombre, cuil, finanza);
        Boolean seAgregoFinanzas = distribuidora.agregarEmpleado(gerenteFinanzas);
        if (seAgregoFinanzas == true) {
            System.out.println("Se agrego el empleado con cuil: " + cuil + " al departemento " + finanza.getNombre());
        }
    }

    private static int menuGestionEmpleados() {
        int opcionDeseada;
        System.out.println("MENU GESTION DE EMPLEADOS \n");
        System.out.println("1- Registrar empleados");
        System.out.println("2- Eliminar empleado");
        System.out.println("3- Buscar un empleado");
        System.out.println("4- Mostrar empleados contratados");
        System.out.println("5- Mostrar empleados despedidos");
        System.out.println("9- Atras");
        opcionDeseada = teclado.nextInt();
        return opcionDeseada;
    }

    private static void gestionDeProductos(Distribuidora distribuidora) {
        int opcionDeseada;
        do {
            opcionDeseada = menuProductos();
            switch (opcionDeseada){

                case REGISTRAR_LOTE:
                    menuRegistrarLote(distribuidora);
                    break;

                case VENDER_LOTE:
                    venderLote(distribuidora);
                    break;

                case BUSCAR_LOTE:
                    buscarLote(distribuidora);
                    break;

                case LOTES_VENDIDOS:
                    buscarLotesVendidos(distribuidora);
                    break;

                case LOTES_EN_STOCK:
                    lotesEnStock(distribuidora);
                    break;

                case VOLVER_ATRAS:
                    break;


                default:
                    System.out.println("Opcion Incorrecta");
            }


        }while (opcionDeseada !=VOLVER_ATRAS);
    }

    private static void lotesEnStock(Distribuidora distribuidora) {
        Producto[] encontrados =  distribuidora.lotesEnStock();
        if (encontrados !=null) {
            for (int i = 0; i < encontrados.length; i++) {
                if (encontrados[i] != null) {
                    System.out.println(encontrados[i].toString());
                }
            }
        } else{
            System.out.println("No se encontraron productos");
        }
    }

    private static void buscarLotesVendidos(Distribuidora distribuidora) {
        Producto [] encontrados =  distribuidora.lotesVendidos();
        if (encontrados != null){
            for (int i = 0; i < encontrados.length; i++) {
                if (encontrados[i] != null) {
                    System.out.println(encontrados[i].toString());
                }
            }
        } else{
            System.out.println("No se encontraron productos vendidos");
        }
    }

    private static void buscarLote(Distribuidora distribuidora) {
        System.out.println("Ingrese el numero de lote a buscar ");
        int numeroLote = teclado.nextInt();
        Producto seBusco = distribuidora.buscarLote(numeroLote);
        if (seBusco !=null){
            System.out.println("El lote con numero" + numeroLote + "se encuentra en stock");
        }else{
            System.out.println("El lote con mumero" +numeroLote + "no se encuentra en stock");
        }
    }

    private static void venderLote(Distribuidora distribuidora) {
        int opcionDeseada;
        do {
            opcionDeseada = menuVentaLote();
            switch (opcionDeseada) {
                case VENDER_LOTE_A_MAYORISTA:
                    ventaAMayorista(distribuidora);
                    break;

                case VENDER_PRODUCTO_A_MINORISTA:
                    ventaAMinorista(distribuidora);
                    break;

                case VENDER_LOTE_A_EMPLEADO:
                    ventaAEmpleado(distribuidora);
                    break;

                case  VOLVER_ATRAS:
                    break;

                default:
                    System.out.println("Opcion Incorrecta");
            }
        }while (opcionDeseada != VOLVER_ATRAS);
    }

    private static void ventaAEmpleado(Distribuidora distribuidora) {
        System.out.println("Ingrese el numero de lote a vender");
        int numeroLote = teclado.nextInt();
        Producto seEncontroLote = distribuidora.buscarLote(numeroLote);
        if (seEncontroLote != null){
            System.out.println("Ingrese el cuil del cliente mayorista");
            int cuilCliente = teclado.nextInt();
            Empleado seEncontroEmpleado = distribuidora.buscarEmpleado(cuilCliente);
            if (seEncontroEmpleado != null){
                Boolean seVendioLoteAEmpleado = distribuidora.venderLoteAEmpleado(numeroLote,seEncontroEmpleado );
                if (seVendioLoteAEmpleado == true){
                    System.out.println("Venta exitosa");
                }else
                {
                    System.out.println("No se pudo vender el lote");
                }

            }else {
                System.out.println("No existe el cliente");
            }

        }else {
            System.out.println("No existe el numero el lote en stock");
        }
    }

    private static void ventaAMinorista(Distribuidora distribuidora) {
        System.out.println("Ingrese el numero de Lote");
        int numeroLote = teclado.nextInt();
        Producto seEncontroLote = distribuidora.buscarLote(numeroLote);
        if (seEncontroLote != null){
            System.out.println("Ingrese el cuil del cliente minorista");
            int cuilCliente = teclado.nextInt();
            Cliente seEncontroCliente = distribuidora.buscarCliente(cuilCliente);
            if (seEncontroCliente != null){
                System.out.println("Ingrese la cantidad de productos que desea comprar");
                int cantProductos = teclado.nextInt();

                Boolean seVendio = distribuidora.venderProductoPorUnidad(numeroLote,cuilCliente,cantProductos);

                if ( seVendio== true){
                    System.out.println("Venta exitosa");
                }else
                {
                    System.out.println("No se pudo vender el lote");
                }

            }else {
                System.out.println("No existe el cliente");
            }

        }else {
            System.out.println("No existe el numero el lote en stock");
        }
    }

    private static void ventaAMayorista(Distribuidora distribuidora) {
        System.out.println("Ingrese el numero de lote a vender");
        int numeroLote = teclado.nextInt();
        Producto seEncontroLote = distribuidora.buscarLote(numeroLote);
        if (seEncontroLote != null){
            System.out.println("Ingrese el cuil del cliente mayorista");
            int cuilCliente = teclado.nextInt();
            Cliente seEncontroCliente = distribuidora.buscarCliente(cuilCliente);
            if (seEncontroCliente != null){
                Boolean seVendioLote = distribuidora.venderLote(numeroLote,cuilCliente);
                if (seVendioLote == true){
                    System.out.println("Venta exitosa");
                }else
                {
                    System.out.println("No se pudo vender el lote");
                }

            }else {
                System.out.println("No existe el cliente");
            }

        }else {
            System.out.println("No existe el numero el lote en stock");
        }
    }

    private static int menuVentaLote() {
        int opcionDeseada;

           System.out.println("1- Para vender lote a cliente Mayorista");
           System.out.println("2- Para vender producto a cliente Minorista");
           System.out.println("3- Para vender lote a Empleado");
           System.out.println("9-Atras");
           opcionDeseada = teclado.nextInt();

        return opcionDeseada;
    }

    private static void menuRegistrarLote(Distribuidora distribuidora) {
        System.out.println("Ingrese el nombre del Producto");
        nombre = teclado.next();

        System.out.println("Ingrese el numero de lote");
        numLote = teclado.nextInt();

        System.out.println("Ingrese el precio del Lote");
        precio = teclado.nextDouble();

        System.out.println("Ingrese la cantidad de productos en el lote");
        cantidadDeProductosEnLaCaja = teclado.nextInt();

        Producto producto = new Producto(nombre,numLote,precio,cantidadDeProductosEnLaCaja);

        Boolean seAgrego = distribuidora.agregarLote(producto);
        if (seAgrego == true){
            System.out.println("El lote de numero: "+ producto.getnLote()+ " a sido creado correctamente");
        }else{
            System.out.println("El lote no pudo ser ingresado , realice la accion nuevamente");
        }
    }

    private static int menuProductos() {
        int opcionDeseada;
        int opcionDeseadaProductos;
        System.out.println("************************");
        System.out.println("Menu de Productos");
        System.out.println("1 - Registrar Lote");
        System.out.println("2 - Vender Lote");
        System.out.println("3 - Buscar lote por su numero");
        System.out.println("4 - Mostrar lotes vendidos");
        System.out.println("5 - Mostrar lotes");
        System.out.println("9 - Atras");
        System.out.println("0 - Salir");
        System.out.println("************************");
        System.out.println("Ingrese una opcion");
        opcionDeseada = teclado.nextInt();
        return opcionDeseada;

    }

    private static int menuPrincipal() {
        int opcionDeseada;
        System.out.println("************************");
        System.out.println("Menu de opciones");
        System.out.println("1 - Para gestionar Clientes");
        System.out.println("2 - Para gestionar Productos");
        System.out.println("3 - Para gestionar Empleados");
        System.out.println("0 - Salir");
        System.out.println("************************");
        System.out.println("Ingrese una opcion");
        opcionDeseada = teclado.nextInt();
        return opcionDeseada;
    }


}
