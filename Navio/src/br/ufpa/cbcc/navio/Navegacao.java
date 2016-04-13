package br.ufpa.cbcc.navio;

public interface Navegacao {
	public void definirRota();
	public boolean definirRota(String origem, String destino);
	public void pilotoAutomatico();
	public void pilotoManual();
	public void navegar();
	public int navegar(int distanciaKmANavegar);
	public void operar();
	public boolean viagemFinalizada();
}
