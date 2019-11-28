package modelo;

import viewmodel.SingletonDataDummy;

public class Utils {
    public int obtenerNumeroAleotorio (int maximo){
        return (int) (Math.random() * maximo);
    }

    public Pais obtenerPais(String paisProximo) {

        for (Pais pais: SingletonDataDummy.getInstance().obtenerListaPaises()){
            if(pais.getNombre().equalsIgnoreCase(paisProximo)){
                return pais;
            }
        }
        return null;
    }

}
