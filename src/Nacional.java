class Nacional extends Producto {
    private String registroDIAN;

    public Nacional(String nombre, int codigo, String productoDIAN) {
        super(nombre, codigo);
        this.registroDIAN = productoDIAN;
    }

    public String toString() {
        return "Código: " + getCodigo() + " | Nombre: " + getNombre() + " | Registro DIAN: " + registroDIAN;
    }
}

