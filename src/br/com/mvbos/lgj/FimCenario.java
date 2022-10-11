package br.com.mvbos.lgj;

import java.awt.Graphics2D;

import br.com.mvbos.lgj.base.CenarioPadrao;
import br.com.mvbos.lgj.base.Menu;
import br.com.mvbos.lgj.base.Util;
import Serializacao.*;
import java.io.IOException;
import java.util.ArrayList;


public class FimCenario extends CenarioPadrao{
	public FimCenario(int largura, int altura) {
		super(largura, altura);
	}

	private Menu menuLetra1;
	private Menu menuLetra2;
	private Menu menuLetra3;
	private Menu GameOver;
	
	@Override
	public void carregar() {
		
		GameOver = new Menu("");
		menuLetra1 = new Menu("");
		menuLetra2 = new Menu("");
		menuLetra3 = new Menu("");
		
		menuLetra1.addOpcoes("A", "B", "C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
		menuLetra2.addOpcoes("A", "B", "C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
		menuLetra3.addOpcoes("A", "B", "C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
		GameOver.addOpcoes("GAME OVER");
		Util.centraliza(menuLetra1, largura, altura);
		Util.centraliza(menuLetra2, largura, altura);
		Util.centraliza(menuLetra3, largura, altura);
		Util.centraliza(GameOver,largura,altura);
		
		menuLetra1.setLargura(40);
		menuLetra2.setLargura(40);
		menuLetra3.setLargura(40);
		
		menuLetra1.setPx(menuLetra2.getPx() - 40);
		menuLetra3.setPx(menuLetra2.getPx() + 40);
		GameOver.setPx(menuLetra2.getPx() - 40);
		GameOver.setPy(menuLetra2.getPy() - 40);
		
		
		menuLetra1.setAtivo(true);
		menuLetra2.setAtivo(true);
		menuLetra3.setAtivo(true);
		menuLetra1.setSelecionado(true);
	}

	@Override
	public void descarregar() {
		ArrayList<Object> jogador = Empacotamento.lerArquivoBinario("dados.dat");
		String nome = menuLetra1.getOpcaoTexto() + menuLetra2.getOpcaoTexto() +menuLetra3.getOpcaoTexto();
		jogador.add(new Jogador(nome,JogoCenario.pontos));
		Empacotamento.gravarArquivoBinario(jogador, "dados.dat");
		
	  

	}

	@Override
	public void atualizar() {
		if (Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]) {
			if(menuLetra1.isSelecionado()) {
				menuLetra1.setSelecionado(false);
				menuLetra2.setSelecionado(true);
				menuLetra3.setSelecionado(false);
			}else if(menuLetra2.isSelecionado()) {
				menuLetra1.setSelecionado(false);
				menuLetra2.setSelecionado(false);
				menuLetra3.setSelecionado(true);
			} else if(menuLetra3.isSelecionado()) {
				menuLetra1.setSelecionado(true);
				menuLetra2.setSelecionado(false);
				menuLetra3.setSelecionado(false);
			}

		} else if (Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]) {
			if(menuLetra1.isSelecionado()) {
				menuLetra1.setSelecionado(false);
				menuLetra2.setSelecionado(false);
				menuLetra3.setSelecionado(true);
			}else if(menuLetra2.isSelecionado()) {
				menuLetra1.setSelecionado(true);
				menuLetra2.setSelecionado(false);
				menuLetra3.setSelecionado(false);
			} else if(menuLetra3.isSelecionado()) {
				menuLetra1.setSelecionado(false);
				menuLetra2.setSelecionado(true);
				menuLetra3.setSelecionado(false);
			}

		} else if (Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()] || Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]) {
			boolean esquerda = Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()];
			menuLetra1.setTrocaOpcao(esquerda);
			menuLetra2.setTrocaOpcao(esquerda);
			menuLetra3.setTrocaOpcao(esquerda);

		}

		Jogo.liberaTeclas();

	}

	@Override
	public void desenhar(Graphics2D g) {
		GameOver.desenha(g);
		menuLetra1.desenha(g);
		menuLetra2.desenha(g);
		menuLetra3.desenha(g);
		

	}


}
