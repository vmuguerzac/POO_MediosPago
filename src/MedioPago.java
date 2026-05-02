public abstract class MedioPago {
    // Encapsulamiento: atributos private
    private double monto;
    private String moneda;
    private String titular;
    // Constructor
    public MedioPago(double _monto, String _moneda, String _titular){
        setMonto(_monto);
        setMoneda(_moneda);
        setTitular(_titular);
    }
    // En los Setters se establece validacion (consideracion)
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        // validacion
        if(monto <= 0){
            throw new IllegalArgumentException("El monto debe ser mayor a cero. Recibido: " + monto);
        }
        this.monto = monto;
    }
    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        if(moneda == null || moneda.isBlank()){
            throw new IllegalArgumentException("La moneda no puede estar varia");
        }
        this.moneda = moneda.toUpperCase();
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Metodo abstracto -> Contrato
    public abstract boolean procesarPago();

    // Metodo compartido por todas las clases
    public String resumen(){
        return String.format("[%s] %s - %s %.2f", 
        getClass().getSimpleName(), getTitular(), getMoneda(), getMonto());
    }

    
}
