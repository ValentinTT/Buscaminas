package igu;

import java.util.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.font.*;

public class Cronometro extends JPanel implements Runnable{
	private byte h, m, s, ms;
	private JLabel hora;
	private DecimalFormat formato;
	private boolean bo;
	
	public Cronometro(){
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(50, 50));
		
		reiniciar();
		bo = true;
		formato = new DecimalFormat("00");
		hora = new JLabel();
		hora.setHorizontalAlignment(JLabel.CENTER);
		hora.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 35));
		add(hora, BorderLayout.CENTER);
	}
	public void reiniciar(){
		h = 0;
		m = 0;
		s = 0; 
		ms = 0;
	}
	public boolean getbo(){
		return bo;
	}
	public void kill(){
		bo = false;
	}
	public void run(){
		while(bo){
			ms += 1;
			if(h >= 99 && m >= 59 && s >= 59 && ms >= 9){
				try {
					Thread.sleep(100);
					hora.setText(formato.format(h) + ":" + formato.format(m) + ":" + formato.format(s) + ":" + ms);
				} catch (InterruptedException e) {}
				bo = false;
				break;
			}
			if(ms > 9){
				ms = 0;
				s += 1;
			}
			if(s > 59){
				s = 0;
				m += 1;
			}
			if(m > 59){
				m = 0;
				h += 1;
			}
			try {
				Thread.sleep(100);
				hora.setText(formato.format(h) + ":" + formato.format(m) + ":" + formato.format(s) + ":" + ms);
			} catch (InterruptedException e) {}
		}
	}
}
