public class PagoTarjetaCredito implements ProcesadorPago {

    private String titular;
    private double limiteCredito;

    public PagoTarjetaCredito(String titular, double limiteCredito) {
        this.titular = titular;
        this.limiteCredito = limiteCredito;
    }

    @Override
    public boolean procesarPago(double monto) {

        if (monto <= 0) {
            System.out.println("[Tarjeta] Monto inválido.");
            return false;
        }

        if (monto > limiteCredito) {
            System.out.println("[Tarjeta] Rechazado: $" + monto + " supera el límite de crédito ($"
                    + limiteCredito + ") de " + titular + ".");
            return false;
        }

        limiteCredito = limiteCredito - monto;
        System.out.println("[Tarjeta] Pago aprobado de $" + monto + " a nombre de " + titular
                + ". Límite restante: $" + limiteCredito);
        return true;
    }
}