package igu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tablero extends JPanel {
	private Icon im_bandera, im_bomba, im_bomba_bandera, im_frente;
	private int alto, ancho, minas;
	private int cant_banderas;	
	private int primer_click = -1;
	private int[] primer_click_alrededor = new int[9];
	private Casilla[][] tablero, tablero_aux;
	
	public Tablero(int alto, int ancho){
		setLayout(new GridLayout(alto, ancho));
		
		im_bandera = new ImageIcon(Tablero.class.getResource("image/Bandera.gif"));
		im_bomba = new ImageIcon(Tablero.class.getResource("image/Bomba.gif"));
		im_bomba_bandera = new ImageIcon(Tablero.class.getResource("image/BombaBandera.gif"));
		im_frente = new ImageIcon(Tablero.class.getResource("image/Frente.gif"));
		tablero_aux = new Casilla[alto][ancho];
		tablero = new Casilla[alto][ancho];		
		cant_banderas = 0;		
		
		iniciarTableroAux();
		calcularMinas(alto, ancho);
	}
	private void iniciarTableroAux(){
		for(int i = 0; i < tablero_aux.length; i++){
			for(int j = 0; j < tablero_aux[i].length; j++){
				tablero_aux[i][j] = new Casilla(im_frente);
				tablero_aux[i][j].addMouseListener(new AccionInicio(i, j));
				add(tablero_aux[i][j]);
			}
		}
	}
	private void calcularMinas(int alto, int ancho){
		this.alto = alto;
		this.ancho = ancho;
		minas = Integer.valueOf((15*alto*ancho) / 100); //Las minas son el 10% del total de casillas
	}
	private void crearMinas(int cant_minas){
		int[]posiciones = new int[cant_minas];
		for(int i = 0; i < cant_minas; i++){//Genera cant_minas posiciones donde se localizaran minas.
			int aux_pos = (int)(Math.random() * (alto*ancho));//Genera un número alazar entre 0 y la cantidad de casillas
			if(revisarArray(posiciones, aux_pos)) //Si el valor asignado no esta repetido en el array lo agrega
				posiciones[i] = aux_pos;
			else i--; //Sino vuelve a intentar reduciendo i en uno
		}
		int x, y;		
		for(int i = 0; i < cant_minas; i++){
			if(posiciones[i] == 0){
				y = 0;
				x = 0;
			}
			else if(posiciones[i] < ancho){
				y = 0;
				x = posiciones[i];
			}
			else{
				y = posiciones[i] / ancho;
				x = posiciones[i] % ancho;
			}
			tablero[y][x] = new Minas(im_frente);
		}
	}
	private boolean revisarArray(int[] array, int valor){//Revisa que el valor no este en el array.
		for(int i = 0; i < primer_click_alrededor.length; i++)
			if(primer_click_alrededor[i] == valor) return false; 
		for(int i = 0; i < array.length; i++){
			if(array[i] == valor)
				return false;
		}
		return true;
	}
	private void crearNoMinas(){
		for(int i = 0; i < tablero.length; i++){
			for(int j = 0; j < tablero[i].length; j++){
				if(tablero[i][j]  == null)
					tablero[i][j] = new NoMinas(im_frente);
			}
		}
	}
	private void agregarCasillas(){//String tipo indica que clase de oyente deve agregarle a los botones
		for(int i = 0; i < tablero.length; i++){
			for(int j = 0; j < tablero[i].length; j++){
				add(tablero[i][j]);
				tablero[i][j].addMouseListener(new AccionJuego(i, j));
				if(tablero[i][j] instanceof NoMinas){
					NoMinas no_mina = (NoMinas) tablero[i][j];
					no_mina.instanciarNumero(j, i, tablero);
				}		
			}
		}
	}
	private void iniciarJuego(int y, int x){
		Marco.queMarco(Tablero.this).getPanel().startCrono();
		
		removeAll();
		tablero_aux = null;
		primer_click = (y * ancho) + x;
		primer_click_alrededor[0] = primer_click - 1 - ancho;
		primer_click_alrededor[1] = primer_click - ancho;
		primer_click_alrededor[2] = primer_click + 1 - ancho;
		primer_click_alrededor[3] = primer_click - 1;
		primer_click_alrededor[4] = primer_click;
		primer_click_alrededor[5] = primer_click + 1;
		primer_click_alrededor[6] = primer_click - 1 + ancho;
		primer_click_alrededor[7] = primer_click + ancho;
		primer_click_alrededor[8] = primer_click + 1 + ancho;		
		
		crearMinas(minas);
		crearNoMinas();
		agregarCasillas();
		
		NoMinas no_mina = (NoMinas)tablero[y][x];
		no_mina.instanciarNumero(x, y, tablero);
		no_mina.voltear(y, x, tablero);
		updateUI();
	}
	private void fin(Casilla[][] tablero){
		for(int i = 0; i < tablero.length; i++){
			for(int j = 0; j < tablero[i].length; j++){
				if(tablero[i][j] instanceof Minas){
					if(tablero[i][j].de_frente) {
						Marco.queMarco(Tablero.this).getPanel().killCrono();
						reiniciar(JOptionPane.showConfirmDialog(null, "Perdiste ;(\nQuieres empezar de nuevo?", "Derrota", 0, 1, null));
						return;
					}
				}
			}
		}
		for(int i = 0; i < tablero.length; i++){
			for(int j = 0; j < tablero[i].length; j++){
				if(tablero[i][j] instanceof NoMinas){
					if(!tablero[i][j].de_frente)
						return;
				}
			}
		}
		Marco.queMarco(Tablero.this).getPanel().killCrono();
		reiniciar(JOptionPane.showConfirmDialog(null, "Felicidades Ganaste!!!!\nQuieres empezar de nuevo?", "Victoria", 0, 1, null));
	}
	public void reiniciar(int op){		
		if(op == 0){
			removeAll();
			for(int i = 0; i < tablero.length; i++){
				for(int j = 0; j < tablero[i].length; j++)
					tablero[i][j] = null;
			}				
			tablero_aux = new Casilla[alto][ancho];
			tablero = new Casilla[alto][ancho];		
			cant_banderas = 0;		
			
			iniciarTableroAux();
			calcularMinas(alto, ancho);
			updateUI();
		}
		else System.exit(0); //Marco.queMarco(Tablero.this).dispose(); //Marco.marcos.get(0).dispose();
	}
	private class Accion extends MouseAdapter{
		int x, y;
		public Accion(int y, int x){
			this.x = x;
			this.y = y;
		}
	}
	private class AccionInicio extends Accion{
		public AccionInicio(int y, int x) {
			super(y, x);
		}
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == 3) return;
			iniciarJuego(y,x);
		}		
	}
	private class AccionJuego extends Accion {
		public AccionJuego(int y, int x) {
			super(y, x);
		}

		public void mouseClicked(MouseEvent e) {		
			if(tablero[y][x].de_frente){
				NoMinas no_minas = (NoMinas)tablero[y][x];				
				if(no_minas.rodeadoBanderas(y, x, tablero)){
					if(e.getClickCount() == 2 || e.getButton() == 2){
						String aux = no_minas.getNumero();
						no_minas.cambiaNumero("0");
						no_minas.voltearOcho(y, x, tablero, im_bomba, im_bomba_bandera);
						no_minas.cambiaNumero(aux);
						fin(tablero);
					}
				}
				return;
			}
			if(tablero[y][x].banderita) return;
			if(e.getButton() == 3) return;
			
			if(tablero[y][x] instanceof Minas){
				Minas mina = (Minas) tablero[y][x];
				mina.explocionFinal(tablero, im_bomba, im_bomba_bandera);
				fin(tablero);
				//reiniciar(JOptionPane.showConfirmDialog(null, "Perdiste ;(\nQuieres empezar de nuevo?", "Derrota", 0, 1, null));
			}
			else if(tablero[y][x] instanceof NoMinas){
				NoMinas no_mina = (NoMinas) tablero[y][x];
				no_mina.voltear(y, x, tablero);
				fin(tablero);
			}
		}	
		public void mousePressed(MouseEvent e) {
			if(tablero[y][x] instanceof Minas) System.out.println("Es Mina");
			if(e.getButton() == 3){
				if(tablero[y][x].de_frente) return;
				if(!tablero[y][x].banderita && cant_banderas < minas){
					tablero[y][x].setIcon(im_bandera);
					tablero[y][x].banderita = true;
					cant_banderas ++;
				}
				else if(tablero[y][x].banderita && cant_banderas > 0){
					tablero[y][x].setIcon(im_frente);
					tablero[y][x].banderita = false;
					cant_banderas --;
				}
				else if(cant_banderas == minas)
					JOptionPane.showMessageDialog(null, "Lo siento ya marcaste todas las banderas");
				return ;
			}
		}	
	}
}


















