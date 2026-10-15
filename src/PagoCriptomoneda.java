public class PagoCriptomoneda implements ProcesadorPago {

    private String billetera;
    private double saldoCripto; // expresado en dólares equivalentes
    private static final double COMISION = 0.02; // 2% de comisión de red

    public PagoCriptomoneda(String billetera, double saldoCripto) {
        this.billetera = billetera;
        this.saldoCripto = saldoCripto;
    }

    @Override
    public boolean procesarPago(double monto) {

        if (monto <= 0) {
            System.out.println("[Cripto] Monto inválido.");
            return false;
        }

        double totalConComision = monto + (monto * COMISION);

        if (totalConComision > saldoCripto) {
            System.out.println("[Cripto] Rechazado: se necesitan $" + totalConComision
                    + " (monto + comisión de red) y la billetera " + billetera
                    + " tiene $" + saldoCripto + ".");
            return false;
        }

        saldoCripto = saldoCripto - totalConComision;
        System.out.println("[Cripto] Transacción confirmada en la red desde " + billetera
                + ". Total debitado: $" + totalConComision + " (incluye comisión).");
        return true;
    }
}