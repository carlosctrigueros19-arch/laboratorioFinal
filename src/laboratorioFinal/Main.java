package laboratorioFinal;

// Los imports siempre van aquí, fuera de la clase
import java.util.ArrayList; 

public class Main {

    public static void main(String[] args) {
        // 1. Creación de Entidades Base
        System.out.println("=== Cargando Datos Base ===");
        
        // Crear una categoría y un producto
        Categoria catBebidas = new Categoria(1, "Bebidas");
        Producto prod1 = new Producto(101, "Coca-Cola 2L", 1.50, 2.50, catBebidas);
        prod1.setCantidadMin(100);
        prod1.setCantidadMax(10);

        Producto prod2 = new Producto(102, "Agua Mineral 500ml", 0.30, 0.80, catBebidas);
        prod2.setCantidadMax(200);
        prod2.setCantidadMin(20);

        // Crear Cliente y Empleado
        Cliente cliente = new Cliente(501, "Oscar Lopez", "7777-1234");
        cliente.setDireccion("Av. Principal #123");

        Empleado empleado = new Empleado(201, "Carlos Gomez", "Cajero");
        
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Empleado a cargo: " + empleado.getNombre() + " (" + empleado.getCargo() + ")");
        System.out.println("--------------------------------------------------\n");

        // 2. Iniciar una Venta
        System.out.println("=== Registrando Nueva Venta ===");
        Venta nuevaVenta = new Venta(1001, "15/06/2026", cliente, empleado);

        // 3. Crear los Detalles de la Venta (Productos que lleva el cliente)
        // El cliente lleva 3 Coca-Colas
        DetalleVenta detalle1 = new DetalleVenta(1, 3, prod1);
        // El cliente lleva 5 Aguas Minerales
        DetalleVenta detalle2 = new DetalleVenta(2, 5, prod2);

        // 4. Agregar los detalles a la venta
        nuevaVenta.agregarDetalle(detalle1);
        nuevaVenta.agregarDetalle(detalle2);

        // 5. Mostrar el Ticket / Resumen de la Venta
        System.out.println("Venta ID: " + nuevaVenta.getIdVenta());
        System.out.println("Fecha: " + nuevaVenta.getFecha());
        System.out.println("Cliente: " + nuevaVenta.getCliente().getNombre());
        System.out.println("Atendido por: " + nuevaVenta.getEmpleado().getNombre());
        System.out.println("\n--- DETALLE DE COMPRA ---");
        
        for (DetalleVenta det : nuevaVenta.getDetalles()) {
            System.out.printf("- %s x%d | Subtotal: $%.2f%n", 
                det.getProducto().getNombre(), 
                det.getCantidad(), 
                det.getSubtotal()
            );
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL A PAGAR: $%.2f%n", nuevaVenta.calcularTotal());
    } // Cierre del método main
} // Cierre de la clase Main

