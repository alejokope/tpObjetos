package modelo;

public interface EstadoDeMensaje {

    public void actualizarEstadoDeMensaje(CasoAJugar casoAJugar);
    public String mostrarMensaje(CasoAJugar casoAJugar, Ayuda ayuda);
}
