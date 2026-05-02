public class TarjetaCredito extends MedioPago {
    private String numeroTarjeta;
    private int cuotas;

    public TarjetaCredito(double _monto, String _moneda, String _titular,
        String _numeroTarjeta, int _cuotas) {
        super(_monto, _moneda, _titular);
        setCuotas(_cuotas);
        setNumeroTarjeta(_numeroTarjeta);
    }

    @Override
    public boolean procesarPago() {
        double cuota = getMonto() / cuotas;
        System.out.printf("[Tarjeta de Credito] Procesando %s - %s %.2f en %d cuotas(s) de S/ %.2f %n",
            getNumeroTarjeta(), getMoneda(), getMonto(), getCuotas(), cuota);
        System.out.println("[Tarejta de Credito] Cargo Autorizado");
        return true;
    }

    public String getNumeroTarjeta() {
        // Ofuscar el numero tarjeta con * solo mostrar 4 ultimos
        return "**** **** **** " + numeroTarjeta.substring(12);
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        // Validacion
        if(numeroTarjeta.length() != 16){
            throw new IllegalArgumentException("Número de tarjeta inválido");
        }
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        if(cuotas < 1 || cuotas > 36){
            throw new IllegalArgumentException("Cuotas entre 1 y 36");
        }
        this.cuotas = cuotas;
    }

    
}
