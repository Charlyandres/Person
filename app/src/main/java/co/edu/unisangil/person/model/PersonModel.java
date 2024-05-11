package co.edu.unisangil.person.model;

public class PersonModel {
    private String nombre;

    private String direccion;

    private int edad;

    private String foto;

    public PersonModel(String nombre, String direccion, int edad, String foto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
