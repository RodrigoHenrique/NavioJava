package br.ufpa.cbcc.navio;

import java.util.ArrayList;
import java.util.List;

public class Navio extends Embarcacao{
	public static final int qdeMaxPassageiros = 500;
	public static final int qdeMaxCargas = 50;
	public static final int pesoMaxCargas = 100000;
	public static final int qdeMaxMercadorias = 500;
	public static final int valorRSMaxMercaorias = 1000000;
	
	private boolean passageirosABordo;
	private boolean cargasABordo;
	private boolean mercadoriasABordo;
	
	public Navio(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida)
	{
		super(nomeEmbarcacao,dataRegistro,proprietario,portoPartida);
	}
	
	public Navio(Navio copia)
	{
		super((Embarcacao)copia);
		this.passageirosABordo = copia.passageirosABordo;
		this.cargasABordo = copia.cargasABordo;
		this.mercadoriasABordo = copia.mercadoriasABordo;
	}
	
	// Gets:
	
	public final boolean getPassageirosABordo()
	{
		return this.passageirosABordo;
	}
	
	public final boolean getCargasABordo()
	{
		return this.cargasABordo;
	}
	
	public final boolean getMercadoriasABordo()
	{
		return this.mercadoriasABordo;
	}
	
	// Sets:
	
	public void setPassageirosABordo()
	{
		if(this.passageirosABordo) this.passageirosABordo = false;
		else this.passageirosABordo = true;
	}
	
	public void setCargasABordo()
	{
		if(this.cargasABordo) this.cargasABordo = false;
		else this.cargasABordo = true;
	}
	
	public void setMercadoriasABordo()
	{
		if(this.mercadoriasABordo) this.mercadoriasABordo = false;
		else this.mercadoriasABordo = true;
	}
	
	// Implementations:
	
	public int definirVelocidade()
	{
		if(this.getEstadoMotor())
		{
			int nivelVelocidade;
			System.out.println("Mudar nível de Velocidade?");
			System.out.println("0 -> 0 Km/h");
			System.out.println("1 -> 2 Km/h");
			System.out.println("2 -> 4 Km/h");
			System.out.println("3 -> 8 Km/h");
			System.out.println("4 -> 16 Km/h");
			System.out.println("5 -> 32 Km/h");
			System.out.print("Resposta: ");
			nivelVelocidade = ler.nextInt();
			
			switch(nivelVelocidade)
			{
				case 0:
					return 0;
				case 1:
					return 2;
				case 2:
					return 4;
				case 3:
					return 8;
				case 4:
					return 16;
				case 5:
					return 32;
				default:
					System.out.println("Nível de Velocidade Inválido.");
					return this.getVelocidadeKmHora();
			}
		}
		else
		{
			System.out.println("Motor Deslidago. Navio Imóvel.");
			return 1;
		}
	}
	
	public void iniciaPassageirosABordo()
	{
		this.passageirosABordo = false;
	}
	
	public void iniciaCargasABordo()
	{
		this.cargasABordo = false;
	}
	
	public void iniciaMercadoriasABordo()
	{
		this.mercadoriasABordo = false;
	}

	public boolean definirRota(String origem, String destino)  // Implementa o outro método sobrecarregado.
	{
		System.out.println("Embarcação: " +getNomeEmbarcacao());
		if(this.getEmbarcacaoAportada()) System.out.println("Embarcação não aportada.");
		else
		{
			int km;
			if(origem != this.getPortoPartida()) this.setPortoPartida(origem);
			this.setPortoChegada(destino);
			System.out.print("Qual a distância entre os portos, em kms <digite um inteiro> : ");
			km = ler.nextInt();
			this.setDistanciaKm(km);
			this.setDistanciaKmEntrePortos(km);
			this.setRotaDefinida();
			return true;
		}
		return false;
	}

	public void navegar() // Sobrescreve o "método qualquer"
	{
		if(this.getDistanciaKm() == 0)
		{
			System.out.println("--" +this.getNomeEmbarcacao());
			System.out.println("Horas Passadas: " +this.getTempoHoras());
			System.out.println("Distância do destino: " +this.getDistanciaKm());
			try
			{
				Thread.sleep(500);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.print("Chegou ao Destino.");
		}
		else
		{
			System.out.println("--" +this.getNomeEmbarcacao());
			System.out.println("-Horas Passadas: " +this.getTempoHoras() +" Distância do Destino: " +this.getDistanciaKm());
			this.pilotoAutomatico();
			this.pilotoManual();
			this.percorreDistancia();
			this.implementaTempoHoras(1);
			try
			{
				Thread.sleep(500);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			this.navegar();
		}
	}
	
	public final int getVelocidadeMax()
	{
		return 32;
	}

	public static void main(String[] args)
	{
		Data dataTeste = new Data(1,1,2016);
		
		Porto portoSaida = new Porto("PedraDoDragao");
		Porto portoChegada = new Porto("PortoReal");
		
		List <Passageiro> passageiros = new ArrayList <Passageiro>();
		
		for(int i=0;i<600;i++)
		{
			Passageiro pass = new Passageiro();
			passageiros.add(pass);
		}
		
		portoSaida.entradaPassageiros(passageiros);
		
		List <Carga> cargas = new ArrayList <Carga>();
		
		for(int i=0;i<90;i++)
		{
			Carga carg = new Carga();
			cargas.add(carg);
		}
		
		portoSaida.entradaCargas(cargas);
		
		List <Mercadoria> mercadorias = new ArrayList <Mercadoria>();
		
		for(int i=0;i<999;i++)
		{
			Mercadoria merc = new Mercadoria();
			mercadorias.add(merc);
		}
		
		portoSaida.entradaMercadorias(mercadorias);

		Cruzeiro cruzeiro = new Cruzeiro("Balerion",dataTeste,"Aegon",portoSaida.getNomePorto());
		
		Cargueiro cargueiro = new Cargueiro("Meraxes",dataTeste,"Rhaenys",portoSaida.getNomePorto());
		
		Mercante mercante = new Mercante("Vhagar",dataTeste,"Visenya",portoSaida.getNomePorto());
		
		portoSaida.entradaEmbarcacao(cruzeiro);
		portoSaida.entradaEmbarcacao(cargueiro);
		portoSaida.entradaEmbarcacao(mercante);
		
		for(int i=0;i<portoSaida.getFilasEmbarcacao().size();i++)
		{
			if(portoSaida.getFilasEmbarcacao().elementAt(i).peek() instanceof Cruzeiro)
			{
				Cruzeiro aux = (Cruzeiro) portoSaida.getFilasEmbarcacao().elementAt(i).peek();
				
				portoSaida.saidaEmbarcacao();
				aux.definirRota();
				
				aux.definirTripulacao();
				
				List <Passageiro> passEmbarque = new ArrayList <Passageiro>();
				passEmbarque = portoSaida.saidaPassageiros();
				aux.definirPassageiros(passEmbarque);
				
				aux.ligarMotores();
				aux.definirVelocidade();
				aux.navegar();
				
				portoChegada.entradaEmbarcacao(aux);
				if(aux.viagemFinalizada()) System.out.println("Finalizada Viagem.");
				
				List <Passageiro> passDesembarque = aux.getPassageiros();
				portoChegada.entradaPassageiros(passDesembarque);
			}
		}
	}
}