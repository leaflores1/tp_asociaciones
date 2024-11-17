import java.util.ArrayList;

public class Factura {
    private String fechaFactura;
    private long numeroFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura;
    private double totalCalculadoFactura;

    public Factura() {
        this.detallesFactura = new ArrayList<>();
        this.totalCalculadoFactura = 0;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        if (numeroFactura > 0) {
            this.numeroFactura = numeroFactura;
        } else {
            throw new IllegalArgumentException("El número de factura debe ser mayor a cero.");
        }
    }

    public void setCliente(String cliente) {
        if (!cliente.isEmpty()) {
            this.cliente = cliente;
        } else {
            throw new IllegalArgumentException("El cliente no puede estar vacío.");
        }
    }

    public void agregarDetalle(DetalleFactura detalle) {
        detallesFactura.add(detalle);
    }

    public void calcularMontoTotal() {
        totalCalculadoFactura = 0;
        for (DetalleFactura detalle : detallesFactura) {
            totalCalculadoFactura += detalle.getSubtotal();
        }
    }

    public void imprimirFactura() {
        System.out.println("Fecha: " + fechaFactura);
        System.out.println("Número: " + numeroFactura);
        System.out.println("Cliente: " + cliente);
        System.out.println("Código\tNombre\tCant\tPrecio\tDesc\tSubtotal");
        for (DetalleFactura detalle : detallesFactura) {
            System.out.println(detalle);
        }
        System.out.println("Total: " + totalCalculadoFactura);
    }
}
