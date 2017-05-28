package igu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
	private Tablero tablero;
	private Barra_Menu barra;
	private Cronometro crono;
	private Thread hilo_crono;
	
	public PanelPrincipal(int alto, int ancho){
		setLayout(new BorderLayout());
		
		barra = new Barra_Menu();
		add(barra, BorderLayout.NORTH);
		
		crearMinas(alto, ancho);		
		add(tablero, BorderLayout.CENTER);	
		
		crono = new Cronometro();
		add(crono, BorderLayout.SOUTH);
	}
	public void startCrono(){
		crono = new Cronometro();
		add(crono, BorderLayout.SOUTH);
		hilo_crono = new Thread(crono);
		hilo_crono.start();
	}
	public void killCrono(){
		Thread hilo = new Thread(new Runnable(){
			public void run() {
				try {
					Thread.sleep(90);
					if(crono.getbo())
						crono.kill();
				} catch (InterruptedException e) {}
			}
		});
		hilo.start();
	}
	public Tablero getTablero(){
		return tablero;
	}
	private void crearMinas(int alto, int ancho){
		tablero = new Tablero(alto, ancho); 		
	}
	public void reiniciarMinas(int alto, int ancho){
		tablero = new Tablero(alto, ancho);
	}
	class Barra_Menu extends JPanel{
		private JMenuBar barra;
		private JMenu menu_op;
		private JMenuItem nuevo, cambiar_tamanio, cerrar;
		
		public Barra_Menu(){
			setLayout(new BorderLayout());
			
			barra = new JMenuBar();
			menu_op = new JMenu("Opciones");
			
			nuevo = new JMenuItem("Nuevo Juego");
			cambiar_tamanio = new JMenuItem("Cambiar Tamaño");
			cerrar = new JMenuItem("Cerrar");
			
			nuevo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					tablero.reiniciar(0); //0 means ok in the confirmDialog
				}
			});
			cambiar_tamanio.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Marco.redimension(Marco.queMarco(tablero));
				}
			});
			cerrar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Marco.queMarco(tablero).dispose();
				}
			});
			
			menu_op.addSeparator();
			menu_op.add(nuevo);
			menu_op.add(cambiar_tamanio);
			menu_op.add(cerrar);
			
			barra.add(menu_op);
			add(barra, BorderLayout.NORTH);
		}
	}
	/*class CambiarTamanio extends JFrame{
		private JTextField ancho, largo, minas;
		private JButton aceptar, cancelar;
	}*/
	
}












