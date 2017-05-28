package igu;
import javax.swing.*;
import java.awt.*;

public class Minas extends Casilla{
	
	public Minas(Icon frente){
		super(frente);
	}
	public void explocion(int y, int x, Casilla[][] tablero, Icon imagen_b, Icon imagen_bb){
		if(banderita == true)return;
		else explocionFinal(tablero, imagen_b, imagen_bb);
	}
	public void explocionFinal(Casilla[][] tablero, Icon imagen_b, Icon imagen_bb){
		for(int i = 0; i < tablero.length; i++){
			for(int j = 0; j < tablero[i].length; j++){
				if(tablero[i][j] instanceof Minas){
					Minas mina = (Minas) tablero[i][j];
					mina.bum(imagen_b, imagen_bb);
				}
			}
		}
	}
	public void bum(Icon imagen_b, Icon imagen_bb){
		Toolkit.getDefaultToolkit().beep();
		System.out.println("BOOOM!!!");
		de_frente = true;
		if(super.banderita)
			setIcon(imagen_bb);
		else 
			setIcon(imagen_b);
	}
}
