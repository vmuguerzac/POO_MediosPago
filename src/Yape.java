public class Yape extends MedioPago { // Herencia
    private String numeroCelular; // Atributo propio de YAPE

    public Yape(double _monto, String _titular, String _numeroCelular) {
        super(_monto, "PEN", _titular);
        setNumeroCelular(_numeroCelular);
    }

    @Override
    public boolean procesarPago() {
        System.out.printf("[Yape] Enviando S/ %.2f de %s al celular %s. %n", 
            getMonto(), getTitular(), getNumeroCelular()
        );
        System.out.println("[Yape] - Pago procesado via billetera digital");
        return true;
    } 

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        // Validar
        if(!numeroCelular.matches("^9\\d{8}")){
            throw new IllegalArgumentException("Número de telefono inválido: " + numeroCelular);
        }
        this.numeroCelular = numeroCelular;
    }
    
}
