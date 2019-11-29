package modelo;

public class NoPasoPorEstePaisMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CasoAJugar casoAJugar) {
        if(casoAJugar.seEncuentranAmbos()){
            casoAJugar.setEstadoDeMensaje(new GameOverMensaje());
        }

        else if(casoAJugar.estanEnElMismoPais()){
            casoAJugar.setEstadoDeMensaje(new MismoPaisMensaje());
        }

        else if(casoAJugar.pasoPorElPais()){
            casoAJugar.setEstadoDeMensaje(new DarPistaMensaje());
        }

    }

    @Override
    public String mostrarMensaje(CasoAJugar casoAJugar, Ayuda ayuda) {
        return ayuda.noPasoPorEstePaisMensaje();
    }
    //condicion: no paso por el pais, pasoElVillano es false en LugarInteres
}
