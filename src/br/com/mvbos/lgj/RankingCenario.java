package br.com.mvbos.lgj;

import java.awt.Graphics2D;
import java.util.*;


import br.com.mvbos.lgj.base.*;
import Serializacao.*;

	public class RankingCenario extends CenarioPadrao{
		ArrayList<Object> jogador = Empacotamento.lerArquivoBinario("dados.dat");
		ArrayList<Ranking> rk = new ArrayList();
		

		
		Unserialize ranking = new Unserialize();
		
		public RankingCenario(int largura, int altura) {
			super(largura, altura);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void carregar() {
			
			Util.centraliza(ranking, largura, altura);
			for(Object item :jogador) {
				rk.add(new Ranking(((Jogador)item).getNome(),((Jogador)item).getPontuacao()));
			}
			
			Collections.sort(rk);
			
			
			
		}

		@Override
		public void descarregar() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void atualizar() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void desenhar(Graphics2D g) {

//			Collections.sort(jogador, new Comparator<Object>() {
//		        @Override
//		        public int compare(Object o1, Object o2) {
//		            return ((Jogador)o1).pontuacao.compareTo(((Jogador)o2).pontuacao);
//		        }});
			int ctd = 0;
			for(Ranking i :rk) {
			ranking.desenha(g,i.getNome(),ctd,i.getPts());
			ctd += 20;
			if(ctd>=200) {
				break;
			}
			}
			
		}
}
