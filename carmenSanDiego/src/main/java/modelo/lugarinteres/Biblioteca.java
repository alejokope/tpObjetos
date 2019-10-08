package modelo.lugarinteres;

import lombok.Setter;
import modelo.Pais;
import modelo.Pista;
import modelo.Villano;

@Setter
public class Biblioteca implements LugarInteres {
    private Villano villano;
    private boolean pasoVillano = false;
    public Pista darPista() {
        Pista pista = new Pista();
        if(pasoVillano){
            String pista1 = obtenerSeñasParticulares(villano);
            String pista2 = obtenerPistaSobrePais(villano.getPaisProximo());
            if(porcentajeMayorA50()){
                String pista3 = obtenerHobbies(villano);
                pista = new Pista(pista1,pista2,pista3);
            }else{
                pista = new Pista(pista1,pista2);
            }
        }
        else{
            System.out.println("No hay información.");
        }
        return pista;
    }


    //todo o utils o herencia repite mucho codigo
    private String obtenerPistaSobrePais(Pais pais){
        int numero = (int) (Math.random() * pais.getCaracteristicas().size());
        return pais.getCaracteristicas().get(numero);
    }

    private String obtenerSeñasParticulares(Villano villano){
        int numero = (int) (Math.random() * villano.getSeñasParticulares().size());
        return villano.getSeñasParticulares().get(numero);
    }
    private String obtenerHobbies(Villano villano){
        int numero = (int) (Math.random() * villano.getHobbies().size());
        return villano.getHobbies().get(numero);
    }

    private boolean porcentajeMayorA50(){
        int numeroAlAzar = (int) (Math.random() * 100);
        return numeroAlAzar >= 50;
    }

    public void setPasoVillano(boolean pasoVillano) {
        this.pasoVillano = pasoVillano;
    }

    public String informacion() {
        return "BIBLIOTECA";
    }
}
