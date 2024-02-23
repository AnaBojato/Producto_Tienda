import java.util.*;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Nacional> listaN = new ArrayList<>();
    static ArrayList<Importado> listaI = new ArrayList<>();
    static Local lo_cal;
    static ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public static void main(String[] args) {

        lo_cal = new Local("Local Fijo", "Calle Principal, Ciudad");

        int opcion;
        do {
            System.out.println("------------------------------------------------");
            System.out.println("\t           **  MENÚ  **");
            System.out.println("\n\t1. Registrar productos nacionales");
            System.out.println("\t2. Registrar productos importados");
            System.out.println("\t3. Listar productos nacionales");
            System.out.println("\t4. Listar productos importados");
            System.out.println("\t5. Listar productos del local ");
            System.out.println("\t6. Registrar empleado");
            System.out.println("\t7. Listar empleados");
            System.out.println("\t8. Buscar producto nacional");
            System.out.println("\t9. Buscar producto importado");
            System.out.println("\t10. Buscar empleado");
            System.out.println("\t0. Salir");
            System.out.println("------------------------------------------------");
            System.out.print("> Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    registrarProductoNacional();
                    break;
                case 2:
                    registrarProductoImportado();
                    break;
                case 3:
                    listarProductosNacionales();
                    break;
                case 4:
                    listarProductosImportados();
                    break;
                case 5:
                    listarProductosLocal();
                    break;
                case 6:
                    registrarEmpleado();
                    break;
                case 7:
                    listarEmpleados();
                    break;
                case 8:
                    buscarProductoNacional();
                    break;
                case 9:
                    buscarProductoImportado();
                    break;
                case 10:
                    buscarEmpleado();
                    break;
                case 0:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nOpción inválida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    static void registrarProductoNacional(){
        System.out.println("------------------------------------------------");
        System.out.println("\n\t>> REGISTRAR PRODUCTO NACIONAL <<");
        System.out.print("\n\tNombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.print("\tCódigo del producto: ");
        int codigo = entrada.nextInt();
        entrada.nextLine(); //---
        System.out.print("\tRegistro DIAN: ");
        String registroDIAN = entrada.nextLine();
        Nacional nuevoProducto = new Nacional(nombre, codigo, registroDIAN);
        listaN.add(nuevoProducto);
        lo_cal.agregarProducto(nuevoProducto); // Agregar producto al inventario del local
        System.out.println("\n✅ Producto nacional registrado correctamente.");
    }

    static void registrarProductoImportado(){
        System.out.println("------------------------------------------------");
        System.out.println("\n\t>> REGISTRAR PRODUCTO IMPORTADO <<");
        System.out.print("\n\tNombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.print("\tCódigo del producto: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        System.out.print("\tLicencia de importación: ");
        String licenciaImportacion= entrada.nextLine();
        Importado nuevoProducto = new Importado(nombre, codigo, licenciaImportacion);
        listaI.add(nuevoProducto);
        lo_cal.agregarProducto(nuevoProducto); // Agregar producto al inventario del local
        System.out.println("\n✅ Producto importado registrado correctamente");
    }


    static void listarProductosLocal(){
        System.out.println("------------------------------------------------");
        System.out.println("\n>> PRODUCTOS DEL LOCAL <<");

        for (Producto producto : lo_cal.getInventario()){
            System.out.println("\n" + producto);
        }
    }

    static void registrarEmpleado(){
        System.out.println("------------------------------------------------");
        System.out.println("\n\t>> REGISTRAR EMPLEADO <<");
        System.out.print("\n\tNombre del empleado: ");
        String nombre = entrada.nextLine();
        System.out.print("\tCargo del empleado: ");
        String cargo = entrada.nextLine();
        listaEmpleados.add(new Empleado(nombre, cargo));
        System.out.println("\n✅ Empleado registrado correctamente");
    }

    static void listarProductosNacionales(){
        System.out.println("------------------------------------------------");
        System.out.println("\n>> PRODUCTOS NACIONALES <<");

        for (Nacional producto : listaN){
            System.out.println("\n" + producto);
        }
    }

    static void listarProductosImportados(){
        System.out.println("------------------------------------------------");
        System.out.println("\n>> PRODUCTOS IMPORTADOS <<");

        for (Importado producto : listaI){
            System.out.println("\n" + producto);
        }
    }

    static void listarEmpleados(){
        System.out.println("------------------------------------------------");
        System.out.println("\n>> EMPLEADOS <<");

        for (Empleado empleado : listaEmpleados){
            System.out.println("\n" + empleado);
        }
    }

    static void buscarProductoNacional(){
        System.out.println("------------------------------------------------");
        System.out.println("\n\t>> BUSCAR PRODUCTO NACIONAL <<");
        System.out.print("\nIngresa el código del producto a buscar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine(); //--
        for (Nacional producto : listaN) {
            if (producto.getCodigo() == codigo) {
                System.out.println("\n✅ Producto encontrado:");
                System.out.println(producto);
                return;
            }
        }
        System.out.println("\n❌ Producto no encontrado.");
    }

    static void buscarProductoImportado(){
        System.out.println("------------------------------------------------");
        System.out.println("\n\t>> BUSCAR PRODUCTO IMPORTADO <<");
        System.out.print("\nIngresa el código del producto a buscar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine(); //--
        for (Importado producto : listaI) {
            if (producto.getCodigo() == codigo) {
                System.out.println("\n✅ Producto encontrado:");
                System.out.println(producto);
                return;
            }
        }
        System.out.println("\n❌ Producto no encontrado.");
    }

    static void buscarEmpleado(){
        System.out.println("------------------------------------------------");
        System.out.println("\n\t>> BUSCAR EMPLEADO <<");
        System.out.print("\nIngresa el nombre del empleado a buscar: ");
        String nombre = entrada.nextLine();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNombre().equals(nombre)) {
                System.out.println("\n✅ Empleado encontrado:");
                System.out.println(empleado);
                return;
            }
        }
        System.out.println("\n❌ Empleado no encontrado.");
    }
}
