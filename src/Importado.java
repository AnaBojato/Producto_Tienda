class Importado extends Producto {
    private String licenciaImportacion;

    public Importado(String nombre, int codigo, String licenciaImportacion) {
        super(nombre, codigo);
        this.licenciaImportacion = licenciaImportacion;
    }

    public String toString() {
        return "Código: " + getCodigo() + " | Nombre: " + getNombre() + " | Licencia de Importación: " + licenciaImportacion;
    }
}