package modelo;

import viewmodel.ResolviendoElCasoViewModel;
import viewmodel.SingletonDataDummy;

import java.util.List;

public class Utils {
    private ResolviendoElCasoViewModel modelo;
    public Utils(ResolviendoElCasoViewModel modelo) {
        this.modelo = modelo;
    }

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

    public boolean paisEstaEnElCaso(List<Pais> paises, Pais paisActual){
        for(Pais _pais: paises){
            if(_pais.getNombre().equalsIgnoreCase(paisActual.getNombre())){
                return true;
            }
        }
        return false;
    }
}
