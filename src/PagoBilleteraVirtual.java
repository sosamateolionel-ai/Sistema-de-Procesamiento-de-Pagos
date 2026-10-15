public class PagoBilleteraVirtual implements ProcesadorPago {

    private String usuario;
    private double saldo;
    private static final double LIMITE_POR_OPERACION = 50000.0;

    public PagoBilleteraVirtual(String usuario, double saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
    }

    @Override
    public boolean procesarPago(double monto) {

        if (monto <= 0) {
            System.out.println("[Billetera] Monto inválido.");
            return false;
        }

        if (monto > LIMITE_POR_OPERACION) {
            System.out.println("[Billetera] Rechazado: supera el límite por operación ($"
                    + LIMITE_POR_OPERACION + ").");
            return false;
        }

        if (monto > saldo) {
            System.out.println("[Billetera] Rechazado: saldo insuficiente (" + saldo + ").");
            return false;
        }

        saldo = saldo - monto;
        System.out.println("[Billetera] Pago aprobado para " + usuario + ". Saldo restante: $" + saldo);
        return true;
    }
}