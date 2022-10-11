package br.com.mvbos.lgj.base;

import java.awt.Color;
import java.awt.Graphics2D;


public class Unserialize extends Texto{
	
	
	
	
	public Unserialize() {
		super();

		
		setLargura(120);
		setAltura(20);
		setCor(Color.WHITE);
	}
	
	
	public void desenha(Graphics2D g,String i,int ctd, int pts) {
		
		g.setColor(getCor());
	
		super.desenha(g,String.format("%s............%d",i,pts), getPx(), getPy() + getAltura() +ctd);
	}
	
}
