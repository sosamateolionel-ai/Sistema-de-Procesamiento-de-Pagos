public class ModuloCompras {

    private ProcesadorPago procesador; // referencia a la ABSTRACCIÓN, no a una clase concreta

    public ModuloCompras(ProcesadorPago procesador) {
        this.procesador = procesador;
    }

    public void setProcesador(ProcesadorPago procesador) {
        this.procesador = procesador;
        System.out.println("Módulo de compras: proveedor de pago cambiado.");
    }

    public void realizarCompra(String producto, double monto) {

        System.out.println("\nCompra: " + producto + " por $" + monto);

        boolean aprobado = procesador.procesarPago(monto);

        if (aprobado) {
            System.out.println("Comprobante: compra de \"" + producto + "\" confirmada.");
        } else {
            System.out.println("Rechazo: la compra de \"" + producto + "\" no pudo completarse.");
        }
    }
}