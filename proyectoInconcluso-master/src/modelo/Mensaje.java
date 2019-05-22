
package modelo;

public class Mensaje {
    
    private int id_mensaje;
    private Usuario emisor;
    private Usuario receptor;
    private String contenido;

    public Mensaje(int id_mensaje, Usuario emisor, Usuario receptor, String contenido) {
        this.id_mensaje = id_mensaje;
        this.emisor = emisor;
        this.receptor = receptor;
        this.contenido = contenido;
    }

    public Mensaje() {
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getRemitente() {
        return receptor;
    }

    public void setRemitente(Usuario remitente) {
        this.receptor = remitente;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
    
}
