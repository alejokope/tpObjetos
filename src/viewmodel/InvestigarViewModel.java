package viewmodel;

import modelo.Caso;

public class InvestigarViewModel {
	
	private Caso caso;
	
	public void setCaso(Caso caso) {
		this.caso=caso;
	}
	public String getResporteDummy() {
		return SingletonDataDummy.getInstance().obtenerReporteDelCasoAsignado();
	}
	
	public String getTituloDummy() {
		return SingletonDataDummy.getInstance().obtenerTituloDelCasoAsignado();
	}

}
