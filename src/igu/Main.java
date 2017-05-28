package igu;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Main {
	public static void main(String[] args){
		MetalLookAndFeel.setCurrentTheme(new EstiloBuscaminas());
		try{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			System.out.println("Falló la carga del tema");
	      	System.out.println(ex);
	   	}
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		new Marco(10, 10);
	}
}
