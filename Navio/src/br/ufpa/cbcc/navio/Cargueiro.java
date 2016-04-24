package br.ufpa.cbcc.navio;

import java.util.List;

public class Cargueiro extends Navio{
	public Cargueiro(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida)
	{
		super(nomeEmbarcacao,dataRegistro,proprietario,portoPartida);
		this.iniciaCargasABordo();
	}
	
	public void definirCargas(List<Carga> cargasCargueiro)
	{
		if(cargasCargueiro.size() > qdeMaxCargas) return;
		this.setCargas(cargasCargueiro);
		this.setCargasABordo();
	}
}
