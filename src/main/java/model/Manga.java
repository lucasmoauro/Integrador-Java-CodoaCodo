package model;

public class Manga {

    //SE DEFINE EL MODELO
    private int idmanga;
    private String nombre;
    private String autor;
    private int cantPaginas;
    private double precio;
    private String genero;

    public Manga(int idmangas, String nombre, String autor, int cantPaginas, double precio, String genero) {
        this.idmanga = idmangas;
        this.nombre = nombre;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
        this.precio = precio;
        this.genero = genero;
    }

    //SIN ID PARA INSERTAR
    public Manga(String nombre, String autor, int cantPaginas, double precio, String genero) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
        this.precio = precio;
        this.genero = genero;
    }

    public Manga() {
    }

    public int getIdmangas() {
        return idmanga;
    }

    public void setIdmangas(int idmangas) {
        this.idmanga = idmangas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Manga{" + "idmangas=" + idmanga + ", nombre=" + nombre + ", autor=" + autor + ", cantPaginas=" + cantPaginas + ", precio=" + precio + ", genero=" + genero + '}';
    }

}
