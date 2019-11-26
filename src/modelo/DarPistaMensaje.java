package modelo;

public class DarPistaMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CarmenSanDiegoMaster carmenSanDiegoMaster) {
        if(carmenSanDiegoMaster.seEncuentranAmbos()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new GameOverMensaje());
        }

        if(carmenSanDiegoMaster.estanEnElMismoPais()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new MismoPaisMensaje());
        }

        if(!carmenSanDiegoMaster.pasoPorElPais()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new NoPasoPorEstePaisMensaje());
        }

    }

    @Override
    public String mostrarMensaje(CarmenSanDiegoMaster carmenSanDiegoMaster, Ayuda ayuda) {
        return ayuda.darPistaMensaje();
    }
}
