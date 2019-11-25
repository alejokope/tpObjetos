package modelo.lugarInteres;

import modelo.*;

public class Club extends LugarInteres{

    public static final int MAXIMO_NUMERO_RANDOM = 100;
    public static final int PORCENTAJE_EVALUADO = 70;

    @Override
    public Ayuda darPista() {
        Ayuda ayuda = new Ayuda();
        if (pasoElVillano) {
            ayuda.agregarDosPistas(obtenerPistas(villano.getSeniasParticulares()), obtenerPistas(villano.getSeniasParticulares()));
            if (chanceDeObtenerPistaExtra()) {
                ayuda.agregarUnaPista(obtenerPistas(villano.getHobbies()));
            }
        }
        return ayuda;
    }

    @Override
    public String informacion() {
        return "CLUB";
    }

    @Override
	protected int maximoNumeroRandom() {
		return MAXIMO_NUMERO_RANDOM;
	}

	@Override
    protected int porcentajeEvaluado() {
        return PORCENTAJE_EVALUADO;
    }


}
