public class DetalleFactura {
    private String codigoArticulo;
    private String nombreArticulo;
    private int cantidad;
    private double precioUnitario;
    private double descuentoItem;
    private double subtotal;

    public DetalleFactura(String codigoArticulo, String nombreArticulo, int cantidad, double precioUnitario) {
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;

        // Cálculo de descuento
        this.descuentoItem = (cantidad > 5) ? precioUnitario * 0.1 : 0;

        // Cálculo de subtotal
        this.subtotal = (precioUnitario - descuentoItem) * cantidad;
    }

    public String toString() {
        return String.format("%s\t%s\t%d\t%.2f\t%.2f\t%.2f",
                codigoArticulo, nombreArticulo, cantidad, precioUnitario, descuentoItem, subtotal);
    }

    public double getSubtotal() {
        return subtotal;
    }
}