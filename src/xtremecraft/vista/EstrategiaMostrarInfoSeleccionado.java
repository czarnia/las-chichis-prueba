package xtremecraft.vista;

public class EstrategiaMostrarInfoSeleccionado implements EstrategiaDeClick{

	SectorJuego sectorJuego;
	
	public EstrategiaMostrarInfoSeleccionado(SectorJuego sector) {
	
		this.sectorJuego = sector;
		
	}

	public void seHizoClick(Vista vista){
		
		this.sectorJuego.actualizarInfoPanel(vista);
		
	}
	
}
