package modelo;

public class GameOverMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CasoAJugar casoAJugar) {
        if(!casoAJugar.seEncuentranAmbos() && casoAJugar.estanEnElMismoPais()){
            casoAJugar.setEstadoDeMensaje(new MismoPaisMensaje());
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
        return ayuda.gameOverMensaje(casoAJugar.getVillano());
    }

    //condicion: villano y jugador estan en el mismo lugar y pais, carmenSanDiego sabe seEncontraronAmbos.
    //no es suficiente para ganar.
}
