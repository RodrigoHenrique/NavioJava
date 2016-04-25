package br.ufpa.cbcc.navio;

import java.util.List;

public class CruzeiroComercial extends Cruzeiro implements Comercio{
	public static final int tempoMaximoViagem = 1000;
	private boolean podeNavegarTempoHabil;
	
	public CruzeiroComercial(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida)
	{
		super(nomeEmbarcacao,dataRegistro,proprietario,portoPartida);
		this.iniciaPassageirosABordo();
		this.podeNavegarTempoHabil = false;
	}
	
	public CruzeiroComercial(CruzeiroComercial copia)
	{
		super((Cruzeiro)copia);
		this.podeNavegarTempoHabil = copia.podeNavegarTempoHabil;
	}
	
	public final boolean getPodeNavegarTempoHabil()
	{
		return this.podeNavegarTempoHabil;
	}
	
	public void definirMercadorias(List<Mercadoria> mercadoriasNavio)
	{
		if(mercadoriasNavio.size() > qdeMaxMercadorias) return;
		this.setMercadorias(mercadoriasNavio);
		this.setMercadoriasABordo();
	}
	
	public boolean testaTempoHabil()
	{
		if(this.getVelocidadeMaxEsp()/this.getDistanciaKmEsp() > tempoMaximoViagem)
		{
			this.podeNavegarTempoHabil = false;
			return false;
		}
		this.podeNavegarTempoHabil = true;
		return true;
	}
}
