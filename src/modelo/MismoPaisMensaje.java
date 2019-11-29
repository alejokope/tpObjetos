package modelo;

public class MismoPaisMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CasoAJugar casoAJugar) {
        if(casoAJugar.seEncuentranAmbos()){
            casoAJugar.setEstadoDeMensaje(new GameOverMensaje());
        }

        else if(!casoAJugar.estanEnElMismoPais() && casoAJugar.pasoPorElPais()){
            casoAJugar.setEstadoDeMensaje(new DarPistaMensaje());
        }

        else if(!casoAJugar.pasoPorElPais()){
            casoAJugar.setEstadoDeMensaje(new NoPasoPorEstePaisMensaje());
        }
    }

    @Override
    public String mostrarMensaje(CasoAJugar casoAJugar, Ayuda ayuda) {
        return ayuda.mismoPaisMensaje();
    }

    //condicion: villano y jugador estan en el mismo pais, carmenSanDiego sabe esto.
}
