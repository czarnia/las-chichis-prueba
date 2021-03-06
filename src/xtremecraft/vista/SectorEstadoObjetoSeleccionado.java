package xtremecraft.vista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xtremecraft.mapa.Mapa;

public class SectorEstadoObjetoSeleccionado extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private MapaObservable mapaObservable;
	
	JLabel titulo = new JLabel("ESTADO ACTUAL SELECCIONADO"); 
	JLabel nombreObservable = new JLabel("");
	JLabel estadoObservable = new JLabel("");
	JLabel coordenadaObservable = new JLabel("");
	
	public SectorEstadoObjetoSeleccionado(MapaObservable mapaObservable, Mapa mapa) {
		
		
		setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
		
		this.mapaObservable = mapaObservable;
		this.mapaObservable.agregarObservadorAVistas(this);
				
		this.add(titulo);
		this.add(nombreObservable);
		this.add(coordenadaObservable);
		this.add(estadoObservable);
		
		
		setVisible(true);
		
	}
	
	@Override
	public void update(Observable observableSeleccionado, Object arg1) {
		
		ObservableSeleccionado vista = (ObservableSeleccionado) observableSeleccionado;
		nombreObservable.setText(vista.getNombre());
		coordenadaObservable.setText(vista.getCoordenadaImprimible());
		estadoObservable.setText(vista.getEstado());
		
	}
	
	public void mostrarInfo(Vista vista) {
		
		nombreObservable.setText(vista.getNombre());
		coordenadaObservable.setText(vista.getCoordenadaImprimible());
		estadoObservable.setText(vista.getEstado());
		
		
	}

}

	
