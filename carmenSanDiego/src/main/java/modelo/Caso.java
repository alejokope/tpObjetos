package modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Caso {
    private Villano responsable;
    private List<Pais> planEscape;
    private String reporte;
    private String objeto;
    private Pais paisOrigen;

}
