package br.ufpa.cbcc.navio;

public interface Veiculo {
	public boolean mover();
	public boolean mover(String meio);
	
	public void manutencao();
	public void manutencao(boolean permissao);
}
