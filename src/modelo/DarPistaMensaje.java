package modelo;

public class DarPistaMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CasoAJugar casoAJugar) {
        if(casoAJugar.seEncuentranAmbos()){
            casoAJugar.setEstadoDeMensaje(new GameOverMensaje());
        }

        else if(casoAJugar.estanEnElMismoPais()){
            casoAJugar.setEstadoDeMensaje(new MismoPaisMensaje());
        }

        else if(!casoAJugar.pasoPorElPais()){
            casoAJugar.setEstadoDeMensaje(new NoPasoPorEstePaisMensaje());
        }

    }

    @Override
    public String mostrarMensaje(CasoAJugar casoAJugar, Ayuda ayuda) {
        return ayuda.darPistaMensaje();
    }
}
