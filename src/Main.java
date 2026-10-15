//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    ProcesadorPago tarjeta = new PagoTarjetaCredito("Lucía Fernández", 100000.0);
    ProcesadorPago cripto = new PagoCriptomoneda("0xAB12...F9", 500.0);
    ProcesadorPago billetera = new PagoBilleteraVirtual("lucia.f", 20000.0);

    ModuloCompras modulo = new ModuloCompras(tarjeta);

    System.out.println("=== Pago con tarjeta ===");
    modulo.realizarCompra("Notebook", 80000.0);   // aprobada
    modulo.realizarCompra("Monitor", 30000.0);    // rechazada (límite restante 20000)

    System.out.println("\n=== Cambio a criptomoneda ===");
    modulo.setProcesador(cripto);
    modulo.realizarCompra("Teclado", 100.0);      // aprobada
    modulo.realizarCompra("Silla gamer", 490.0);  // rechazada

    System.out.println("\n=== Cambio a billetera virtual ===");
    modulo.setProcesador(billetera);
    modulo.realizarCompra("Auriculares", 15000.0); // aprobada
    modulo.realizarCompra("Tablet", 60000.0);      // rechazada (supera el límite por operación)

}
