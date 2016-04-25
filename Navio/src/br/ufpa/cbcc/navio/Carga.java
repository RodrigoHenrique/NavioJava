package br.ufpa.cbcc.navio;

public final class Carga {
	private String nomeCarga;
	private double peso;
	
	public Carga()
	{
		this.nomeCarga = "Desconhecido";
		this.peso = 1.0;
	}
	
	public Carga(Carga copia)
	{
		this.nomeCarga = copia.nomeCarga;
		this.peso = copia.peso;
	}
	
	public Carga(String nomeCarga, double peso)
	{
		this.nomeCarga = nomeCarga;
		this.peso = peso;
	}
	
	public final String getNomeCarga()
	{
		return this.nomeCarga;
	}
	
	public final double getPeso()
	{
		return this.peso;
	}
}
