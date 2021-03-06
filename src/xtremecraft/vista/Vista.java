package xtremecraft.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import xtremecraft.mapa.Coordenada;
import xtremecraft.partida.Identificable;

//public abstract class Vista extends JPanel implements MouseListener,Observer{
public abstract class Vista extends JPanel implements Observer{
	private static final long serialVersionUID = -973667959098244571L;
	
	Color color;
	Coordenada ubicacion;
	int numeroJugador;
	protected String nombre;
	
	private ObservableSeleccionado observableSeleccionado = new ObservableSeleccionado();
	
	public Vista(String nombreVista){
		
		String estadoInicial= "";
//		this.addMouseListener(this);
		this.nombre = nombreVista;
		this.observableSeleccionado.setClaseVista(this.getClass());
		this.observableSeleccionado.setNombre(this.nombre);
		this.observableSeleccionado.setEstado(estadoInicial);
		this.observableSeleccionado.setClaseVista(this.getClass());
		
	}
	
	public String getNombre(){
		
		return this.nombre;
		
	}
	
	public String getCoordenadaImprimible(){
		
		return this.observableSeleccionado.getCoordenadaImprimible();
		
	}
	
	public String getEstado(){
		
		return this.observableSeleccionado.getEstado();
		
	}
	
	public void setEstadoImprimible(String estado){
		
		this.observableSeleccionado.setEstado(estado);
		
	}
	
	public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);
        grafico.setColor(color);
        Dimension dimension = getSize();
        grafico.fill3DRect(0, 0, dimension.width, dimension.height, true);
        
    }

	public void setCoordenada(Coordenada coordenada) {
		
		this.ubicacion = coordenada;
		this.observableSeleccionado.setCoordenada(this.ubicacion);
		
	}
	
	public Coordenada getCoordenada(){
		
		return this.ubicacion;
		
	}
	
	public Color getColor(){
		
		return this.color;
		
	}
		
	@Override
	public void update(Observable observado, Object arg) {
		
		Identificable identificableVisibleEnMapa = (Identificable)observado;
		this.observableSeleccionado.setEstado(identificableVisibleEnMapa.getEstadoImprimible());
		
	}
	
	public void agregarObservador(Observer observador) {
		
		this.observableSeleccionado.addObserver(observador);
		
	}
	
//	
//	@Override
//	public void mouseClicked(MouseEvent click) {
//		
//		this.observableSeleccionado.notificarObservador();
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
	public void setNombre() {

		
		
	}

	public void borrarObservador(Observer observador) {
		
		this.observableSeleccionado.deleteObserver(observador);
		
	}

}
