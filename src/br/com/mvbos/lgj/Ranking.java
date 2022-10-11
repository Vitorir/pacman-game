package br.com.mvbos.lgj;

public class Ranking implements Comparable{
	public Ranking(String nome, int pts) {
		super();
		this.nome = nome;
		this.pts = pts;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	public String nome;
	public int pts;
	
	@Override
	public int compareTo(Object compare) {
		int comparepts = ((Ranking)compare).getPts();
		return comparepts - this.pts;
	}

}
