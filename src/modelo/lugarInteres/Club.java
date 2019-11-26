package modelo.lugarInteres;

public class Club extends LugarInteres{

    public static final int MAXIMO_NUMERO_RANDOM = 100;
    public static final int PORCENTAJE_EVALUADO = 70;

    @Override
    public void darPista() {
        if (pasoElVillano && chanceDeObtenerPistaExtra()) {
            ayuda.setPista(obtenerPistas(villano.getHobbies()) + "\n" +
                            obtenerPistas(villano.getSeniasParticulares()) + "\n" +
                            obtenerPistas(villano.getSeniasParticulares()));
        }
        else if (pasoElVillano) {
            ayuda.setPista(obtenerPistas(villano.getSeniasParticulares()) + "\n" +
                            obtenerPistas(villano.getSeniasParticulares()));
        }
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
