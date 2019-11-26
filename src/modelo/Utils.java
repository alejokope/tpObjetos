package modelo;

public class Utils {
    public int obtenerNumeroAleotorio (int maximo){
        return (int) (Math.random() * maximo);
    }

    public Pais obtenerPais(String paisProximo) {
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        for (Pais pais: baseDeDatos.obtenerListaPaises()){
            if(pais.getNombre().equalsIgnoreCase(paisProximo)){
                return pais;
            }
        }
        return null;
    }
}
