package br.ufpa.cbcc.navio;

public abstract class Veiculo {
	private String proprietario;
	private String tipoLocomocao;
	
	public Veiculo(){}
	public Veiculo(String proprietario, String tipoLocomocao)
	{
		this.proprietario = proprietario;
		this.tipoLocomocao = tipoLocomocao;
	}
	
	public Veiculo(Veiculo copia)
	{
		this.proprietario = copia.proprietario;
		this.tipoLocomocao = copia.tipoLocomocao;
	}

	public abstract boolean mover();
	
	public final String getProprietario()
	{
		return this.proprietario;
	}
	
	public final String getTipoLocomocao()
	{
		return this.tipoLocomocao;
	}
}
