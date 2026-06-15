package laboratorioFinal;

public class DetalleVenta {
	
	    // Atributos
	    private int idDetalle;
	    private int cantidad;
	    private double subtotal;
	    private Producto producto; // Relación con Producto (aparece en)

	    // Constructor
	    public DetalleVenta(int id, int cant, Producto prod) {
	        this.idDetalle = id;
	        this.cantidad = cant;
	        this.producto = prod;
	        this.subtotal = calcularSubtotal(); // Calcula automáticamente al crearse
	    }

	    // Getters y Setters
	    public int getIdDetalle() {
	        return idDetalle;
	    }

	    public int getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(int cant) {
	        this.cantidad = cant;
	        this.subtotal = calcularSubtotal(); // Recalcula si cambia la cantidad
	    }

	    public Producto getProducto() {
	        return producto;
	    }

	    public void setProducto(Producto prod) {
	        this.producto = prod;
	        this.subtotal = calcularSubtotal(); // Recalcula si cambia el producto
	    }

	    // Lógica del método calcularSubtotal()
	    public double calcularSubtotal() {
	        if (this.producto != null) {
	            return this.cantidad * this.producto.getPrecioVenta();
	        }
	        return 0.0;
	    }

	    public double getSubtotal() {
	        return subtotal;
	    }

	    // toString
	    @Override
	    public String toString() {
	        return "DetalleVenta{" + "idDetalle=" + idDetalle + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", producto=" + producto.getNombre() + '}';
	    }
	}

