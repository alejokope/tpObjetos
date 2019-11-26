package modelo;

public class NoPasoPorEstePaisMensaje implements EstadoDeMensaje {

    @Override
    public void actualizarEstadoDeMensaje(CarmenSanDiegoMaster carmenSanDiegoMaster) {
        if(carmenSanDiegoMaster.seEncuentranAmbos()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new GameOverMensaje());
        }

        else if(carmenSanDiegoMaster.estanEnElMismoPais()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new MismoPaisMensaje());
        }

        else if(carmenSanDiegoMaster.pasoPorElPais()){
            carmenSanDiegoMaster.setEstadoDeMensaje(new DarPistaMensaje());
        }

    }

    @Override
    public String mostrarMensaje(CarmenSanDiegoMaster carmenSanDiegoMaster, Ayuda ayuda) {
        return ayuda.noPasoPorEstePaisMensaje();
    }
    //condicion: no paso por el pais, pasoElVillano es false en LugarInteres
}
