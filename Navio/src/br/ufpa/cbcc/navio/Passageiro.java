package br.ufpa.cbcc.navio;

public final class Passageiro {
	private String nomePassageiro;
	private String sobrenomePassageiro;
	private int idade;
	private double peso;
	
	public Passageiro()
	{
		this.nomePassageiro = "Nao";
		this.sobrenomePassageiro = "Identificado";
		this.idade = 0;
		this.peso = 0.0;
	}
	
	public Passageiro(String nomePassageiro, String sobrenomePassageiro, int idade, double peso)
	{
		this.nomePassageiro = nomePassageiro;
		this.sobrenomePassageiro = sobrenomePassageiro;
		this.idade = idade;
		this.peso = peso;
	}
	
	public final String getNomePassageiro()
	{
		return this.nomePassageiro;
	}
	
	public final String getSobrenomePassageiro()
	{
		return this.sobrenomePassageiro;
	}
	
	public final int getIdade()
	{
		return this.idade;
	}
	
	public final double getPeso()
	{
		return this.peso;
	}
}
