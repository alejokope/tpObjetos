package modelo.lugarinteres;

import modelo.Pista;
import modelo.Villano;

public interface LugarInteres {
    public Pista darPista();
    public void setVillano(Villano villano);
    public void setPasoVillano(boolean pasoVillano);
    public String informacion();
}
