package br.ufpa.cbcc.navio;

import java.util.List;

public class Cruzeiro extends Navio{
	public Cruzeiro(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida)
	{
		super(nomeEmbarcacao,dataRegistro,proprietario,portoPartida);
		this.iniciaPassageirosABordo();
	}
	
	public Cruzeiro(Cruzeiro copia)
	{
		super((Navio)copia);
	}
	
	public void definirPassageiros(List<Passageiro> passageirosNavio)
	{
		if(passageirosNavio.size() > qdeMaxPassageiros) return;
		this.setPassageiros(passageirosNavio);
		this.setPassageirosABordo();
	}
	
	public final int getVelocidadeMaxEsp()
	{
		return this.getVelocidadeMax();
	}
	
	public final int getDistanciaKmEsp()
	{
		return this.getVelocidadeMax();
	}
}
