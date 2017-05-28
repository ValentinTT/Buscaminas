package igu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Marco extends JFrame {
	private PanelPrincipal lienzo;
	public static ArrayList<Marco> marcos = new ArrayList<Marco>();
	
	public Marco(int alto, int ancho){
		setTitle("Buscaminas");
		//setSize();
		
		lienzo = new PanelPrincipal(alto, ancho);
		add(lienzo);
		pack();
		//setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Dimension ventana_dim = getSize();
		Dimension pantalla_dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(pantalla_dim.width/2-ventana_dim.width/2, pantalla_dim.height/2-ventana_dim.height/2);
		
		marcos.add(this);
	}
	public PanelPrincipal getPanel(){
		return lienzo;
	}
	public static Marco queMarco(Tablero tablero){
		Iterator<Marco> iterador = marcos.iterator();
		while(iterador.hasNext()){
			Marco marco = iterador.next();
			if(marco.lienzo.getTablero().equals(tablero)) return marco;
		}
		return null;
	}
	public static void redimension(Marco marco){
		String alto = JOptionPane.showInputDialog("Introduce alto: ");
		if(alto == null || alto.equals("")) return;
		for(int i = 0; i < alto.length(); i++)
			if(!Character.isDigit(alto.charAt(i))) return;
		String ancho = JOptionPane.showInputDialog("Introduce ancho: ");
		if(ancho == null || ancho.equals("")) return;
		for(int i = 0; i < ancho.length(); i++)
			if(!Character.isDigit(ancho.charAt(i))) return;
		
		marco.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		marco.dispose();
		if(Integer.valueOf(alto) > 20) alto = "20";
		if(Integer.valueOf(ancho) > 35) ancho = "35";
		marco = new Marco(Integer.valueOf(alto), Integer.valueOf(ancho));
	}
}