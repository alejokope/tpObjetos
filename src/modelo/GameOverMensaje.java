package modelo;

public class GameOverMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CarmenSanDiegoMaster carmenSanDiegoMaster) {
        if(!carmenSanDiegoMaster.seEncuentranAmbos() && carmenSanDiegoMaster.estanEnElMismoPais()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new MismoPaisMensaje());
        }

        else if(!carmenSanDiegoMaster.estanEnElMismoPais() && carmenSanDiegoMaster.pasoPorElPaisElVillano()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new DarPistaMensaje());
        }

        else if(!carmenSanDiegoMaster.pasoPorElPaisElVillano()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new NoPasoPorEstePaisMensaje());
        }
    }

    @Override
    public String mostrarMensaje(CarmenSanDiegoMaster carmenSanDiegoMaster, Ayuda ayuda) {
        return ayuda.gameOverMensaje(carmenSanDiegoMaster.getVillano());
    }

    //condicion: villano y jugador estan en el mismo lugar y pais, carmenSanDiego sabe seEncontraronAmbos.
    //no es suficiente para ganar.
}
