package modelo.lugarInteres;

import modelo.*;

public interface LugarInteres {
    public Pista darPista();
    public void setVillano(Villano villano);
    public void setPasoVillano(boolean pasoVillano);
    public String informacion();
}
