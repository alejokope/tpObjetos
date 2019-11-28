package modelo;

public class MismoPaisMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CarmenSanDiegoMaster carmenSanDiegoMaster) {
        if(carmenSanDiegoMaster.seEncuentranAmbos()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new GameOverMensaje());
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
        return ayuda.mismoPaisMensaje();
    }

    //condicion: villano y jugador estan en el mismo pais, carmenSanDiego sabe esto.
}
