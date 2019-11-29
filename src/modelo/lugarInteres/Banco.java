package modelo.lugarInteres;

import modelo.CasoAJugar;


public class Banco extends LugarInteres {

	@Override
	public String pasoPorElPais(CasoAJugar casoAJugar){
		return ayuda.pasoPorElPais(obtenerPistas(casoAJugar.getVillano().obtenerCaracteristicasDelPaisProximo(casoAJugar.getJugador())) + "\n" +
				                   obtenerPistas(casoAJugar.getVillano().getSeniasParticulares()));
	}

	@Override
	public String informacion() {
		return "BANCO";
	}

}
