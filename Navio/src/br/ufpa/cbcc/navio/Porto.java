package br.ufpa.cbcc.navio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.Scanner;

public class Porto {
	private String nomePorto;
	private Vector<Queue <Embarcacao> > filasEmbarcacao;
	private List<Passageiro> passageirosNoPorto;
	private List<Carga> cargasNoPorto;
	private List<Mercadoria> mercadoriasNoPorto;
	public static final int qdeMaxFilas = 10;
	public static final int qdeMaxEmbarcacoesPorFila = 5;
	public static final int qdeMaxPassageirosNoPorto = 1000;
	public static final int qdeMaxCargasNoPorto = 100;
	public static final int qdeMaxMercadoriasNoPorto = 1000;
	
	Scanner ler = new Scanner(System.in);
	
	public Porto(String nome)
	{
		this.nomePorto = nome;
		this.passageirosNoPorto = new ArrayList <Passageiro>();
		this.cargasNoPorto = new ArrayList <Carga>();
		this.mercadoriasNoPorto = new ArrayList <Mercadoria>();
		this.filasEmbarcacao = new Vector < Queue <Embarcacao> >();
	}
	
	public Porto(Porto copia)
	{
		this.nomePorto = copia.nomePorto;
		this.filasEmbarcacao = copia.filasEmbarcacao;
		this.passageirosNoPorto = copia.passageirosNoPorto;
		this.cargasNoPorto = copia.cargasNoPorto;
		this.mercadoriasNoPorto = copia.mercadoriasNoPorto;
	}
	
	// Gets:
	
	public final String getNomePorto()
	{
		return this.nomePorto;
	}
	
	public final Vector<Queue <Embarcacao> > getFilasEmbarcacao()
	{
		return this.filasEmbarcacao;
	}
	
	// Outras funcionalidades: 
	
	public void entradaEmbarcacao(Embarcacao embarcacaoEntrada)
	{
		if(this.nomePorto != embarcacaoEntrada.getPortoPartida())
		{
			if(this.nomePorto == embarcacaoEntrada.getPortoChegada())
			{
				if(embarcacaoEntrada.getDistanciaKm() != 0) return;
			}
			else return;
		}
		
		if(filasEmbarcacao.size() >= qdeMaxFilas) System.out.println("Tamanho Maximo de filas lotadas atingido");
		else
		{
			if(filasEmbarcacao.isEmpty())
			{
				Queue<Embarcacao> aux = new LinkedList <Embarcacao>();
				filasEmbarcacao.addElement(aux);
				filasEmbarcacao.lastElement().add(embarcacaoEntrada);
				filasEmbarcacao.elementAt(0).element().setEmbarcacaoAportada();
				filasEmbarcacao.elementAt(0).element().setPortoPartida(this.nomePorto);
			}
			else
			{
				if(filasEmbarcacao.lastElement().size() >= qdeMaxEmbarcacoesPorFila)
				{
					Queue<Embarcacao> aux = new LinkedList <Embarcacao>();
					filasEmbarcacao.add(aux);
					filasEmbarcacao.lastElement().add(embarcacaoEntrada);
					filasEmbarcacao.lastElement().element().setEmbarcacaoAportada();
					filasEmbarcacao.lastElement().element().setPortoPartida(this.nomePorto);
				}
				else
				{
					filasEmbarcacao.lastElement().add(embarcacaoEntrada);
					embarcacaoEntrada.setEmbarcacaoAportada();
					embarcacaoEntrada.setPortoPartida(this.nomePorto);
				}
			}
		}
	}

	
	
	public Embarcacao saidaEmbarcacao()
	{
		if(filasEmbarcacao.isEmpty())
		{
			System.out.println("Porto vazio.");
			return null;
		}
		else
		{
			Embarcacao embarcacaoSaida;
			for(int i=0;i<filasEmbarcacao.size();i++)
			{
				if(!filasEmbarcacao.elementAt(i).isEmpty())
				{
					System.out.println("Fila " +i +" : Nome da embarcacao: " +filasEmbarcacao.elementAt(i).peek().getNomeEmbarcacao());
				}
				
				int j;
				System.out.println("Qual embarcacao desaportar? <digite o indice da fila>: ");
				j = ler.nextInt();
				
				if(filasEmbarcacao.elementAt(j).peek().getRotaDefinida() && filasEmbarcacao.elementAt(j).peek().getTripulacaoDefinida())
				{
					System.out.println("oi");
					filasEmbarcacao.elementAt(i).peek().setEmbarcacaoAportada();
					embarcacaoSaida = filasEmbarcacao.elementAt(j).peek();
					filasEmbarcacao.elementAt(i).poll();
					System.out.println("Embarcacao desaportada.");
					return embarcacaoSaida;
				}
			}
			return null;
		}
	}

	public void entradaPassageiros(List<Passageiro> passageiros)
	{
		if(this.passageirosNoPorto.size() + passageiros.size() <= qdeMaxPassageirosNoPorto)
		{
			this.passageirosNoPorto.addAll(passageiros);
		}
	}
	
	public List <Passageiro> saidaPassageiros()
	{
		List <Passageiro> passageirosSaida = new ArrayList <Passageiro>();
		if(!this.passageirosNoPorto.isEmpty())
		{
			int i;
			System.out.println("Quantos passageiros embarcarao? <digite um numero inteiro positivo> : ");
			i = ler.nextInt();
			
			if(i == 0)
			{
				return passageirosSaida;
			}
			
			passageirosSaida.addAll(this.passageirosNoPorto.subList(0, i - 1));
			this.passageirosNoPorto.removeAll(passageirosSaida);
			return passageirosSaida;
		}
		return null;
	}

	public void entradaCargas(List <Carga> cargasEntrada)
	{
		if(this.cargasNoPorto.size() + cargasEntrada.size() > qdeMaxCargasNoPorto) return;
		this.cargasNoPorto.addAll(cargasEntrada);
	}

	public void saidaCargas(List <Carga> cargasSaida)
	{
		if(!this.cargasNoPorto.isEmpty())
		{
			int i;
			System.out.println("Quantas cargas embarcarao? <digite um numero inteiro positivo> : ");
			i = ler.nextInt();
			
			cargasSaida.addAll(this.cargasNoPorto.subList(0, i - 1));
			this.cargasNoPorto.removeAll(cargasSaida);
		}
	}

	public void entradaMercadorias(List <Mercadoria> mercadoriasEntrada)
	{
		if(this.mercadoriasNoPorto.size() + mercadoriasEntrada.size() > qdeMaxMercadoriasNoPorto) return;
		this.mercadoriasNoPorto.addAll(mercadoriasEntrada);
	}

	public void saidaMercadorias(List <Mercadoria> mercadoriasSaida)
	{
		if(!this.mercadoriasNoPorto.isEmpty())
		{
			int i;
			System.out.println("Quantas mercadorias embarcarao? <digite um numero inteiro positivo> : ");
			i = ler.nextInt();
			
			mercadoriasSaida.addAll(this.mercadoriasNoPorto.subList(0, i - 1));
			this.mercadoriasNoPorto.removeAll(mercadoriasSaida);
		}
	}


}
