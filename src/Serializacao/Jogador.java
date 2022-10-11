package Serializacao;
import java.io.Serializable;

public class Jogador implements Serializable{
	public Jogador(String nome, int pontuacao) {
		super();
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	String nome;
	int pontuacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	

}
