package br.ufpa.cbcc.navio;

public final class Mercadoria {
	private String nomeMercadoria;
	private int quantidade;
	private float valorRS;
	
	public Mercadoria()
	{
		this.nomeMercadoria = "Desconhecido";
		this.quantidade = 1;
		this.valorRS = 0;
	}
	
	public Mercadoria(String nomeMercadoria, int quantidade, float valorRS)
	{
		this.nomeMercadoria = nomeMercadoria;
		this.quantidade = quantidade;
		this.valorRS = valorRS;
	}
	
	public final String getNomeMercadoria()
	{
		return this.nomeMercadoria;
	}
	
	public final int getQuantidade()
	{
		return this.quantidade;
	}
	
	public final float getValorRS()
	
	{
		return this.valorRS;
	}
}
