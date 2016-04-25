package br.ufpa.cbcc.navio;

public final class Tripulante {
	private String cargo;
	private String sobrenomeTripulante;
	
	public Tripulante(String cargo, String sobrenomeTripulante)
	{
		this.cargo = cargo;
		this.sobrenomeTripulante = sobrenomeTripulante;
	}
	
	public Tripulante(Tripulante copia)
	{
		this.cargo = copia.cargo;
		this.sobrenomeTripulante = copia.sobrenomeTripulante;
	}
	
	public final String getCargo()
	{
		return this.cargo;
	}
	
	public final String getSobrenomeTripulante()
	{
		return this.sobrenomeTripulante;
	}
}
