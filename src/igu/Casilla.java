package igu;

import java.awt.*;
import javax.swing.*;

public class Casilla extends JButton{
	public boolean de_frente = false;
	public boolean banderita = false;
	
	public Casilla(Icon frente){
		super(frente);
		setFocusPainted(false);
		setPreferredSize(new Dimension(45, 45));
	}
}
