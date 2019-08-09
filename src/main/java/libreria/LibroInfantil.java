package libreria;

public class LibroInfantil extends Libro {

    private Integer edadDesde;
    private Integer edadHasta;

    public Integer getEdadDesde() {
        return edadDesde;
    }

    public void setEdadDesde(Integer edadDesde) {
        this.edadDesde = edadDesde;
    }

    public Integer getEdadHasta() {
        return edadHasta;
    }

    public void setEdadHasta(Integer edadHasta) {
        this.edadHasta = edadHasta;
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }
}
