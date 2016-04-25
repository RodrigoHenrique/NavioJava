package br.ufpa.cbcc.navio;

import java.util.List;

public class Mercante extends Navio implements Comercio{
	public Mercante(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida)
	{
		super(nomeEmbarcacao,dataRegistro,proprietario,portoPartida);
		this.iniciaMercadoriasABordo();
	}
	
	public Mercante(Mercante copia)
	{
		super((Navio)copia);
	}
	
	public void definirMercadorias(List<Mercadoria> mercadoriasNavio)
	{
		if(mercadoriasNavio.size() > qdeMaxMercadorias) return;
		this.setMercadorias(mercadoriasNavio);
		this.setMercadoriasABordo();
	}
}
