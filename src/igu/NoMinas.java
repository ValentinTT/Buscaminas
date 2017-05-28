package igu;

import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class NoMinas extends Casilla{
	private String numero;
	
	public NoMinas(Icon frente){
		super(frente);
	}
	public void instanciarNumero(int x, int y, Casilla[][] tablero){
		int total = 0;
		
		if(x == 0 && y == 0){//Casilla esquina superior izquierda.
			if(tablero[y][x+1] instanceof Minas)
				total++;
			if(tablero[y+1][x] instanceof Minas)
				total++;
			if(tablero[y+1][x+1] instanceof Minas)
				total++;
		}
		else if(x == 0 && y == tablero.length-1){//Casilla esquina inferior izquierda.
			if(tablero[y][x+1] instanceof Minas)
				total++;
			if(tablero[y-1][x] instanceof Minas)
				total++;
			if(tablero[y-1][x+1] instanceof Minas)
				total++;
		}
		else if(x == tablero[0].length-1 && y == tablero.length-1){//Casilla esquina inferior derecha.
			if(tablero[y-1][x-1] instanceof Minas)
				total++;
			if(tablero[y-1][x] instanceof Minas)
				total++;
			if(tablero[y][x-1] instanceof Minas)
				total++;
		}
		else if(x == tablero[0].length-1 && y == 0){//Casilla esquina superior derecha.
			if(tablero[y][x-1] instanceof Minas)
				total++;
			if(tablero[y+1][x] instanceof Minas)
				total++;
			if(tablero[y+1][x-1] instanceof Minas)
				total++;
		}
		else if(x == 0){//Casillas del costado izquierdo.
			if(tablero[y-1][x] instanceof Minas)
				total++;
			if(tablero[y-1][x+1] instanceof Minas)
				total++;
			if(tablero[y][x+1] instanceof Minas)
				total++;
			if(tablero[y+1][x+1] instanceof Minas)
				total++;
			if(tablero[y+1][x] instanceof Minas)
				total++;		
		}
		else if(y == tablero.length-1){//Casillas del costado inferior.
			if(tablero[y][x-1] instanceof Minas)
				total++;
			if(tablero[y-1][x-1] instanceof Minas)
				total++;
			if(tablero[y-1][x] instanceof Minas)
				total++;
			if(tablero[y-1][x+1] instanceof Minas)
				total++;
			if(tablero[y][x+1] instanceof Minas)
				total++;
		}
		else if(x == tablero[0].length-1){//Casillas del costado derecho.
			if(tablero[y+1][x] instanceof Minas)
				total++;
			if(tablero[y+1][x-1] instanceof Minas)
				total++;
			if(tablero[y][x-1] instanceof Minas)
				total++;
			if(tablero[y-1][x-1] instanceof Minas)
				total++;
			if(tablero[y-1][x] instanceof Minas)
				total++;
		}
		else if(y == 0){//Casillas del costado superior.
			if(tablero[y][x-1] instanceof Minas)
				total++;
			if(tablero[y+1][x-1] instanceof Minas)
				total++;
			if(tablero[y+1][x] instanceof Minas)
				total++;
			if(tablero[y+1][x+1] instanceof Minas)
				total++;
			if(tablero[y][x+1] instanceof Minas)
				total++;
		}
		else if(x > 0 && x < tablero[0].length-1 && y > 0 && y < tablero.length-1){
			if(tablero[y+1][x-1] instanceof Minas)
				total++;
			if(tablero[y][x-1] instanceof Minas)
				total++;
			if(tablero[y-1][x-1] instanceof Minas)
				total++;
			if(tablero[y-1][x] instanceof Minas)
				total++;
			if(tablero[y-1][x+1] instanceof Minas)
				total++;
			if(tablero[y][x+1] instanceof Minas)
				total++;
			if(tablero[y+1][x+1] instanceof Minas)
				total++;
			if(tablero[y+1][x] instanceof Minas)
				total++; 			
		}
		numero = "" + total;
	}
	public void voltear(int y, int x, Casilla[][] tablero){
		if(banderita == true) return;
		if(super.de_frente == true) return;
		setIcon(new ImageIcon(NoMinas.class.getResource("image/" + numero + ".gif")));
		super.de_frente = true;
		if(numero.equals("0")){
			if(x == 0 && y == 0){//Casilla esquina superior izquierda.
				if(tablero[y][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x+1];
					no_minas.voltear(y, x+1, tablero);
				}									
				if(tablero[y+1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x];
					no_minas.voltear(y+1, x, tablero);
				}					
				if(tablero[y+1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
					no_minas.voltear(y+1, x+1, tablero);
				}
			}
			else if(x == 0 && y == tablero.length-1){//Casilla esquina inferior izquierda.
				if(tablero[y][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x+1];
					no_minas.voltear(y, x+1, tablero);
				}
				if(tablero[y-1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x];
					no_minas.voltear(y-1, x, tablero);
				}
				if(tablero[y-1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
					no_minas.voltear(y-1, x+1, tablero);
				}
			}
			else if(x == tablero[0].length-1 && y == tablero.length-1){//Casilla esquina inferior derecha.
				if(tablero[y-1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
					no_minas.voltear(y-1, x-1, tablero);
				}
				if(tablero[y-1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x];
					no_minas.voltear(y-1, x, tablero);
				}
				if(tablero[y][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x-1];
					no_minas.voltear(y, x-1, tablero);
				}
			}
			else if(x == tablero[0].length-1 && y == 0){//Casilla esquina superior derecha.
				if(tablero[y][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x-1];
					no_minas.voltear(y, x-1, tablero);
				}
				if(tablero[y+1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x];
					no_minas.voltear(y+1, x, tablero);
				}
				if(tablero[y+1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
					no_minas.voltear(y+1, x-1, tablero);
				}
			}
			else if(x == 0){//Casillas del costado izquierdo.
				if(tablero[y-1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x];
					no_minas.voltear(y-1, x, tablero);
				}
				if(tablero[y-1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
					no_minas.voltear(y-1, x+1, tablero);
				}
				if(tablero[y][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x+1];
					no_minas.voltear(y, x+1, tablero);
				}
				if(tablero[y+1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
					no_minas.voltear(y+1, x+1, tablero);
				}
				if(tablero[y+1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x];
					no_minas.voltear(y+1, x, tablero);
				}		
			}
			else if(y == tablero.length-1){//Casillas del costado inferior.
				if(tablero[y][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x-1];
					no_minas.voltear(y, x-1, tablero);
				}
				if(tablero[y-1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
					no_minas.voltear(y-1, x-1, tablero);
				}
				if(tablero[y-1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x];
					no_minas.voltear(y-1, x, tablero);
				}
				if(tablero[y-1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
					no_minas.voltear(y-1, x+1, tablero);
				}
				if(tablero[y][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x+1];
					no_minas.voltear(y, x+1, tablero);
				}
			}
			else if(x == tablero[0].length-1){//Casillas del costado derecho.
				if(tablero[y+1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x];
					no_minas.voltear(y+1, x, tablero);
				}
				if(tablero[y+1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
					no_minas.voltear(y+1, x-1, tablero);
				}
				if(tablero[y][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x-1];
					no_minas.voltear(y, x-1, tablero);
				}
				if(tablero[y-1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
					no_minas.voltear(y-1, x-1, tablero);
				}
				if(tablero[y-1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x];
					no_minas.voltear(y-1, x, tablero);
				}
			}
			else if(y == 0){//Casillas del costado superior.
				if(tablero[y][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x-1];
					no_minas.voltear(y, x-1, tablero);
				}
				if(tablero[y+1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
					no_minas.voltear(y+1, x-1, tablero);
				}
				if(tablero[y+1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x];
					no_minas.voltear(y+1, x, tablero);
				}
				if(tablero[y+1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
					no_minas.voltear(y+1, x+1, tablero);
				}
				if(tablero[y][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x+1];
					no_minas.voltear(y, x+1, tablero);
				}
			}
			else if(x > 0 && x < tablero[0].length-1 && y > 0 && y < tablero.length-1){
				if(tablero[y+1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
					no_minas.voltear(y+1, x-1, tablero);
				}
				if(tablero[y][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x-1];
					no_minas.voltear(y, x-1, tablero);
				}
				if(tablero[y-1][x-1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
					no_minas.voltear(y-1, x-1, tablero);
				}
				if(tablero[y-1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x];
					no_minas.voltear(y-1, x, tablero);
				}
				if(tablero[y-1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
					no_minas.voltear(y-1, x+1, tablero);
				}
				if(tablero[y][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y][x+1];
					no_minas.voltear(y, x+1, tablero);
				}
				if(tablero[y+1][x+1] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
					no_minas.voltear(y+1, x+1, tablero);
				}
				if(tablero[y+1][x] instanceof NoMinas){
					NoMinas no_minas = (NoMinas)tablero[y+1][x];
					no_minas.voltear(y+1, x, tablero);
				} 			
			}
		}
	}
	public void cambiaNumero(String valor){
		if("123456780".contains(valor))
			numero = valor;
	}
	public String getNumero(){
		return numero;
	}
	public boolean rodeadoBanderas(int y, int x, Casilla[][] tablero){
		int total = 0;
		if(x == 0 && y == 0){//Casilla esquina superior izquierda.
			if(tablero[y][x+1].banderita)
				total++;
			if(tablero[y+1][x].banderita)
				total++;
			if(tablero[y+1][x+1].banderita)
				total++;
		}
		else if(x == 0 && y == tablero.length-1){//Casilla esquina inferior izquierda.
			if(tablero[y][x+1].banderita)
				total++;
			if(tablero[y-1][x].banderita)
				total++;
			if(tablero[y-1][x+1].banderita)
				total++;
		}
		else if(x == tablero[0].length-1 && y == tablero.length-1){//Casilla esquina inferior derecha.
			if(tablero[y-1][x-1].banderita)
				total++;
			if(tablero[y-1][x].banderita)
				total++;
			if(tablero[y][x-1].banderita)
				total++;
		}
		else if(x == tablero[0].length-1 && y == 0){//Casilla esquina superior derecha.
			if(tablero[y][x-1].banderita)
				total++;
			if(tablero[y+1][x].banderita)
				total++;
			if(tablero[y+1][x-1].banderita)
				total++;
		}
		else if(x == 0){//Casillas del costado izquierdo.
			if(tablero[y-1][x].banderita)
				total++;
			if(tablero[y-1][x+1].banderita)
				total++;
			if(tablero[y][x+1].banderita)
				total++;
			if(tablero[y+1][x+1].banderita)
				total++;
			if(tablero[y+1][x].banderita)
				total++;		
		}
		else if(y == tablero.length-1){//Casillas del costado inferior.
			if(tablero[y][x-1].banderita)
				total++;
			if(tablero[y-1][x-1].banderita)
				total++;
			if(tablero[y-1][x].banderita)
				total++;
			if(tablero[y-1][x+1].banderita)
				total++;
			if(tablero[y][x+1].banderita)
				total++;
		}
		else if(x == tablero[0].length-1){//Casillas del costado derecho.
			if(tablero[y+1][x].banderita)
				total++;
			if(tablero[y+1][x-1].banderita)
				total++;
			if(tablero[y][x-1].banderita)
				total++;
			if(tablero[y-1][x-1].banderita)
				total++;
			if(tablero[y-1][x].banderita)
				total++;
		}
		else if(y == 0){//Casillas del costado superior.
			if(tablero[y][x-1].banderita)
				total++;
			if(tablero[y+1][x-1].banderita)
				total++;
			if(tablero[y+1][x].banderita)
				total++;
			if(tablero[y+1][x+1].banderita)
				total++;
			if(tablero[y][x+1].banderita)
				total++;
		}
		else if(x > 0 && x < tablero[0].length-1 && y > 0 && y < tablero.length-1){
			if(tablero[y+1][x-1].banderita)
				total++;
			if(tablero[y][x-1].banderita)
				total++;
			if(tablero[y-1][x-1].banderita)
				total++;
			if(tablero[y-1][x].banderita)
				total++;
			if(tablero[y-1][x+1].banderita)
				total++;
			if(tablero[y][x+1].banderita)
				total++;
			if(tablero[y+1][x+1].banderita)
				total++;
			if(tablero[y+1][x].banderita)
				total++; 			
		}
		if(numero.equals(String.valueOf(total)))
			return true;
		return false;
	}
	public void voltearOcho(int y, int x, Casilla[][] tablero, Icon imagen_b, Icon imagen_bb){
		if(x == 0 && y == 0){//Casilla esquina superior izquierda.
			if(tablero[y][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x+1];
				no_minas.voltear(y, x+1, tablero);
			}
			else if(tablero[y][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x+1];
				minas.explocion(y, x+1, tablero, imagen_b, imagen_bb);
			}									
			if(tablero[y+1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x];
				no_minas.voltear(y+1, x, tablero);
			}
			else if(tablero[y+1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x];
				minas.explocion(y+1, x, tablero, imagen_b, imagen_bb);
			}					
			if(tablero[y+1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
				no_minas.voltear(y+1, x+1, tablero);
			}
			else if(tablero[y+1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x+1];
				minas.explocion(y+1, x+1, tablero, imagen_b, imagen_bb);
			}
		}
		else if(x == 0 && y == tablero.length-1){//Casilla esquina inferior izquierda.
			if(tablero[y][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x+1];
				no_minas.voltear(y, x+1, tablero);
			}
			else if(tablero[y][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x+1];
				minas.explocion(y, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x];
				no_minas.voltear(y-1, x, tablero);
			}
			else if(tablero[y-1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x];
				minas.explocion(y-1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
				no_minas.voltear(y-1, x+1, tablero);
			}
			else if(tablero[y-1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x+1];
				minas.explocion(y-1, x+1, tablero, imagen_b, imagen_bb);
			}
		}
		else if(x == tablero[0].length-1 && y == tablero.length-1){//Casilla esquina inferior derecha.
			if(tablero[y-1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
				no_minas.voltear(y-1, x-1, tablero);
			}
			else if(tablero[y-1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x-1];
				minas.explocion(y-1, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x];
				no_minas.voltear(y-1, x, tablero);
			}
			else if(tablero[y-1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x];
				minas.explocion(y-1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x-1];
				no_minas.voltear(y, x-1, tablero);
			}
			else if(tablero[y][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x-1];
				minas.explocion(y, x-1, tablero, imagen_b, imagen_bb);
			}
		}
		else if(x == tablero[0].length-1 && y == 0){//Casilla esquina superior derecha.
			if(tablero[y][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x-1];
				no_minas.voltear(y, x-1, tablero);
			}
			else if(tablero[y][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x-1];
				minas.explocion(y, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x];
				no_minas.voltear(y+1, x, tablero);
			}
			else if(tablero[y+1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x];
				minas.explocion(y+1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
				no_minas.voltear(y+1, x-1, tablero);
			}
			else if(tablero[y+1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x-1];
				minas.explocion(y+1, x-1, tablero, imagen_b, imagen_bb);
			}
		}
		else if(x == 0){//Casillas del costado izquierdo.
			if(tablero[y-1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x];
				no_minas.voltear(y-1, x, tablero);
			}
			else if(tablero[y-1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x];
				minas.explocion(y-1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
				no_minas.voltear(y-1, x+1, tablero);
			}
			else if(tablero[y-1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x+1];
				minas.explocion(y-1, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x+1];
				no_minas.voltear(y, x+1, tablero);
			}
			else if(tablero[y][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x+1];
				minas.explocion(y, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
				no_minas.voltear(y+1, x+1, tablero);
			}
			else if(tablero[y+1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x+1];
				minas.explocion(y+1, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x];
				no_minas.voltear(y+1, x, tablero);
			}
			else if(tablero[y+1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x];
				minas.explocion(y+1, x, tablero, imagen_b, imagen_bb);
			}		
		}
		else if(y == tablero.length-1){//Casillas del costado inferior.
			if(tablero[y][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x-1];
				no_minas.voltear(y, x-1, tablero);
			}
			else if(tablero[y][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x-1];
				minas.explocion(y, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
				no_minas.voltear(y-1, x-1, tablero);
			}
			else if(tablero[y-1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x-1];
				minas.explocion(y-1, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x];
				no_minas.voltear(y-1, x, tablero);
			}
			else if(tablero[y-1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x];
				minas.explocion(y-1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
				no_minas.voltear(y-1, x+1, tablero);
			}
			else if(tablero[y-1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x+1];
				minas.explocion(y-1, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x+1];
				no_minas.voltear(y, x+1, tablero);
			}
			else if(tablero[y][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x+1];
				minas.explocion(y, x+1, tablero, imagen_b, imagen_bb);
			}
		}
		else if(x == tablero[0].length-1){//Casillas del costado derecho.
			if(tablero[y+1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x];
				no_minas.voltear(y+1, x, tablero);
			}
			else if(tablero[y+1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x];
				minas.explocion(y+1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
				no_minas.voltear(y+1, x-1, tablero);
			}
			else if(tablero[y+1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x-1];
				minas.explocion(y+1, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x-1];
				no_minas.voltear(y, x-1, tablero);
			}
			else if(tablero[y][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x-1];
				minas.explocion(y, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
				no_minas.voltear(y-1, x-1, tablero);
			}
			else if(tablero[y-1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x-1];
				minas.explocion(y-1, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x];
				no_minas.voltear(y-1, x, tablero);
			}
			else if(tablero[y-1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x];
				minas.explocion(y-1, x, tablero, imagen_b, imagen_bb);
			}
		}
		else if(y == 0){//Casillas del costado superior.
			if(tablero[y][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x-1];
				no_minas.voltear(y, x-1, tablero);
			}
			else if(tablero[y][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x-1];
				minas.explocion(y, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
				no_minas.voltear(y+1, x-1, tablero);
			}
			else if(tablero[y+1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x-1];
				minas.explocion(y+1, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x];
				no_minas.voltear(y+1, x, tablero);
			}
			else if(tablero[y+1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x];
				minas.explocion(y+1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
				no_minas.voltear(y+1, x+1, tablero);
			}
			else if(tablero[y+1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x+1];
				minas.explocion(y+1, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x+1];
				no_minas.voltear(y, x+1, tablero);
			}
			else if(tablero[y][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x+1];
				minas.explocion(y, x+1, tablero, imagen_b, imagen_bb);
			}
		}
		else if(x > 0 && x < tablero[0].length-1 && y > 0 && y < tablero.length-1){
			if(tablero[y+1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x-1];
				no_minas.voltear(y+1, x-1, tablero);
			}
			else if(tablero[y+1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x-1];
				minas.explocion(y+1, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x-1];
				no_minas.voltear(y, x-1, tablero);
			}
			else if(tablero[y][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x-1];
				minas.explocion(y, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x-1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x-1];
				no_minas.voltear(y-1, x-1, tablero);
			}
			else if(tablero[y-1][x-1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x-1];
				minas.explocion(y-1, x-1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x];
				no_minas.voltear(y-1, x, tablero);
			}
			else if(tablero[y-1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x];
				minas.explocion(y-1, x, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y-1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y-1][x+1];
				no_minas.voltear(y-1, x+1, tablero);
			}
			else if(tablero[y-1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y-1][x+1];
				minas.explocion(y-1, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y][x+1];
				no_minas.voltear(y, x+1, tablero);
			}
			else if(tablero[y][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y][x+1];
				minas.explocion(y, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x+1] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x+1];
				no_minas.voltear(y+1, x+1, tablero);
			}
			else if(tablero[y+1][x+1] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x+1];
				minas.explocion(y+1, x+1, tablero, imagen_b, imagen_bb);
			}
			if(tablero[y+1][x] instanceof NoMinas){
				NoMinas no_minas = (NoMinas)tablero[y+1][x];
				no_minas.voltear(y+1, x, tablero);
			}
			else if(tablero[y+1][x] instanceof Minas){
				Minas minas = (Minas) tablero[y+1][x];
				minas.explocion(y+1, x, tablero, imagen_b, imagen_bb);
			} 			
		}
	}
}
