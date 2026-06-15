package laboratorioFinal;


	
	// El import debe ir AQUÍ, fuera de la clase
	import java.util.ArrayList;

	public class Venta {
	    
	    // Atributos
	    private int idVenta;
	    private String fecha;
	    private double total;
	    private Cliente cliente;       
	    private Empleado empleado;     
	    private ArrayList<DetalleVenta> detalles; 

	    // Constructor
	    public Venta(int id, String fecha, Cliente cli, Empleado emp) {
	        this.idVenta = id;
	        this.fecha = fecha;
	        this.cliente = cli;
	        this.empleado = emp;
	        this.detalles = new ArrayList<>(); 
	        this.total = 0.0;
	    }

	    // Getters y Setters
	    public int getIdVenta() {
	        return idVenta;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }

	    public Cliente getCliente() {
	        return cliente;
	    }

	    public void setCliente(Cliente cli) {
	        this.cliente = cli;
	    }

	    public Empleado getEmpleado() {
	        return empleado;
	    }

	    public void setEmpleado(Empleado emp) {
	        this.empleado = emp;
	    }

	    public ArrayList<DetalleVenta> getDetalles() {
	        return detalles;
	    }

	    // Método para agregar detalles a la lista
	    public void agregarDetalle(DetalleVenta det) {
	        this.detalles.add(det);
	        this.total = calcularTotal(); 
	    }

	    // Lógica del método calcularTotal()
	    public double calcularTotal() {
	        double suma = 0.0;
	        for (DetalleVenta d : detalles) {
	            suma += d.getSubtotal();
	        }
	        return suma;
	    }

	    // toString
	    @Override
	    public String toString() {
	        return "Venta{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", total=" + total + ", cliente=" + cliente.getNombre() + ", empleado=" + empleado.getNombre() + '}';
	    }
	}
