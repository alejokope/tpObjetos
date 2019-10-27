package modelo.lugarInteres;

import modelo.*;

public class Club extends LugarInteres{

    public static final int MAXIMO_NUMERO_RANDOM = 100;
    public static final int PORCENTAJE_EVALUADO = 70;

    @Override
    public Pista darPista() {
        Pista pista = new Pista();
        if (pasoElVillano) {
            pista.agregarDosPistas(obtenerPistas(villano.getSeñasParticulares()), obtenerPistas(villano.getSeñasParticulares()));
            if (porcentajeMayorA()) {
                pista.agregarUnaPista(obtenerPistas(villano.getHobbies()));
            }
        }
        return pista;
    }

    @Override
    public String informacion() {
        return "CLUB";
    }

    @Override
    protected boolean porcentajeMayorA() {
        return (Math.random() * MAXIMO_NUMERO_RANDOM) >= PORCENTAJE_EVALUADO;
    }

}
