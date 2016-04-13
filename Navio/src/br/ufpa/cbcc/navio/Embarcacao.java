package br.ufpa.cbcc.navio;

import java.util.Scanner;

public abstract class Embarcacao extends Veiculo implements Navegacao{	
	private String nomeEmbarcacao;
	private Data dataRegistro;
	private String portoPartida;
	private String portoChegada;
	private boolean embarcacaoAportada;
	private boolean navegacaoLiberada;
	private boolean rotaDefinida;
	private boolean tripulacaoDefinida;
	
	private boolean estadoMotor;
	private int distanciaKm;
	private int distanciaKmEntrePortos;
	private int distanciaKmAuto;
	private boolean modoPilotoAuto;
	private int velocidadeKmHora;
	private int tempoHoras;
	
	private Tripulante [] tripulacao;
	private Passageiro [] passageiros;
	private Carga [] cargas;
	private Mercadoria [] mercadorias;
	
	public Embarcacao(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida)
	{
		super(proprietario,"Mar");
		this.nomeEmbarcacao = nomeEmbarcacao;
		this.dataRegistro = dataRegistro;
		this.embarcacaoAportada = false;
		this.navegacaoLiberada = false;
		this.portoPartida = portoPartida;
		this.portoChegada = "Desconhecido";
		this.estadoMotor = false;
		this.velocidadeKmHora = 0;
		this.tempoHoras = 0;
		this.distanciaKm = 0;
		this.distanciaKmAuto = 0;
		this.distanciaKmEntrePortos = 0;
		this.modoPilotoAuto = false;
		this.rotaDefinida = false;
		this.tripulacaoDefinida = false;
	}
	
	// Gets:
	
	public final String getNomeEmbarcacao()
	{
		return this.nomeEmbarcacao;
	}
	
	public final Data getDataRegistro()
	{
		return this.dataRegistro;
	}
	
	public final boolean getEmbarcacaoAportada()
	{
		return this.embarcacaoAportada;
	}
	
	public final boolean getNavegacaoLiberada()
	{
		return this.navegacaoLiberada;
	}
	
	public final String getPortoPartida()
	{
		return this.portoPartida;
	}
	
	public final String getPortoChegada()
	{
		return this.portoChegada;
	}
	
	public final boolean getEstadoMotor()
	{
		return this.estadoMotor;
	}
	
	public final int getVelocidadeKmHora()
	{
		return this.velocidadeKmHora;
	}
	
	public final int getTempoHoras()
	{
		return this.tempoHoras;
	}
	
	public final int getDistanciaKm()
	{
		return this.distanciaKm;
	}
	
	public final int getDistanciaKmAuto()
	{
		return this.distanciaKmAuto;
	}
	
	public final int getDistanciaKmEntrePortos()
	{
		return this.distanciaKmEntrePortos;
	}
	
	public final boolean getModoPilotoAuto()
	{
		return this.modoPilotoAuto;
	}
	
	public final boolean getRotaDefinida()
	{
		return this.rotaDefinida;
	}
	
	public final boolean getTripulacaoDefinida()
	
	{
		return this.tripulacaoDefinida;
	}
	
	public final Tripulante[] getTripulacao()
	{
		return this.tripulacao;
	}
	
	public final Passageiro[] getPassageiros()
	{
		return this.passageiros;
	}
	
	public final Carga[] getCargas()
	{
		return this.cargas;
	}
	
	public final Mercadoria[] getMercadorias()
	{
		return this.mercadorias;
	}
	
	// Sets:
	
	public void setEmbarcacaoAportada()
	{
		if(this.embarcacaoAportada) this.embarcacaoAportada = false;
		else this.embarcacaoAportada = true;
	}
	
	public void setTripulacao(Tripulante[] tripulacaoDefine)
	{
		this.tripulacao = tripulacaoDefine;
	}
	
	public void setPassageiros(Passageiro[] passageirosDefine)
	{
		this.passageiros = passageirosDefine;
	}
	
	public void setCargas(Carga[] cargasDefine)
	{
		this.cargas = cargasDefine;
	}
	
	public void setMercadorias(Mercadoria[] mercadoriasDefine)
	{
		this.mercadorias = mercadoriasDefine;
	}
	
	public void setPortoPartida(String portoPartida)
	{
		this.portoPartida = portoPartida;
	}

	public void setPortoChegada(String portoChegada)
	{
		this.portoChegada = portoChegada;
	}

	public void setDistanciaKm(int distanciaKm)
	{
		this.distanciaKm = distanciaKm;
	}

	public void setDistanciaKmEntrePortos(int distanciaKmEntrePortos)
	{
		this.distanciaKmEntrePortos = distanciaKmEntrePortos;
	}

	public void setRotaDefinida()
	{
		if(this.rotaDefinida) this.rotaDefinida = false;
		else this.rotaDefinida = true;
	}
	
	// Implementations:
	
	Scanner ler = new Scanner(System.in);
	
	public void definirRota()
	{		
		System.out.println("Embarcação: " +getNomeEmbarcacao());
		if(this.embarcacaoAportada) System.out.println("Embarcação não aportada.");
		else
		{
			int km;
			String pC;
			System.out.println("Porto de Partida: " +this.portoPartida);
			System.out.println("Porto de Chegada: ");
			pC = ler.nextLine();
			this.portoChegada = pC;
			
			System.out.println("Qual a distância entre os portos, em kms <digite um inteiro> : ");
			km = ler.nextInt();
			this.distanciaKm = km;
			this.distanciaKmEntrePortos = km;
			this.rotaDefinida = true;
		}
	}

	
	public void definirTripulacao()
	{
		while(true)
		{
			int i;
			this.tripulacaoDefinida = true;
			System.out.println("Adicionar oficial a tripulação? <1 - sim> <digite um inteiro> : ");
			i = ler.nextInt();
			if(i != 1) break;
			this.tripulacaoDefinida = false;
			String tripSobrenome, tripCargo;
			System.out.println(" Tripulante: ");
			tripSobrenome = ler.nextLine();
			System.out.println(" Cargo: ");
			tripCargo = ler.nextLine();
			//Tripulante trip = new Tripulante(tripSobrenome, tripCargo);
			//this.tripulacao .. Inserir novo elemento no vetor... Nao sei essa parte da sintaxe.
		}
	}
	
	public boolean mover()
	{
		if(this.getTripulacaoDefinida()) return true;
		else return false;
	}
	
	public void ligarMotores()
	{
		if(!this.mover())
		{
			this.estadoMotor = false;
			System.out.println("Embarcação não habilitada para zarpar.");
		}
		else
		{
			System.out.println("Motores Ligados");
			this.estadoMotor = true;
			this.velocidadeKmHora = 2;
			this.modoPilotoAuto = false;
		}
	}
	
	public abstract int definirVelocidade();
	
	public void pilotoAutomatico()
	{
		if(this.getModoPilotoAuto())
		{
			if(this.getDistanciaKm() < this.getVelocidadeKmHora())
			{
				System.out.println("Redução forçada da velocidade para 2 km/h, destino imintente.");
				try
				{
					Thread.sleep(500);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				if(this.getDistanciaKm() == 1) this.velocidadeKmHora = 1;
				else this.velocidadeKmHora = 2;
			}
			else
			{
				if(this.getDistanciaKm() == this.getDistanciaKmAuto()) this.modoPilotoAuto = false;
				if(this.getDistanciaKm() - this.getDistanciaKmAuto() < this.getVelocidadeKmHora())
				{
					if(this.getDistanciaKm() - this.getDistanciaKmAuto() >= 2)
					{
						System.out.println("Redução forçada da velocidade para 2 km/h, fim do piloto automático iminente.");
						try
						{
							Thread.sleep(500);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						if(this.getDistanciaKm() == 1) this.velocidadeKmHora = 1;
						else this.velocidadeKmHora = 2;
						
					}
				}
			}
		}
	}
	
	public void pilotoManual()
	{
		if(this.getModoPilotoAuto())
		{
			if(this.getDistanciaKm() < this.getVelocidadeKmHora())
			{
				System.out.println("Redução forçada da velocidade para 2 km/h, destino iminente.");
				if(this.getDistanciaKm() == 1) this.velocidadeKmHora = 1;
				else this.velocidadeKmHora = 2;
			}
			else
			{
				if(this.getDistanciaKm() >= 32)
				{
					int resp;
					System.out.println("Ativar Piloto Automático? <digite 1 -> sim : >");
					resp = ler.nextInt();
					try
					{
						Thread.sleep(500);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					if(resp == 1)
					{
						System.out.println("Piloto Automatico LIGADO.");
						this.modoPilotoAuto = true;
						System.out.println("A que distância do destino desativar o modo automático? <digite um inteiro positivo> : ");
						this.distanciaKmAuto = ler.nextInt();
						try
						{
							Thread.sleep(500);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("Piloto Automático Desligado.");
					}
					System.out.println("Alterar Nível de Velocidade? <1 -> sim> : ");
					resp = ler.nextInt();
					try
					{
						Thread.sleep(500);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					if(resp == 1) this.velocidadeKmHora = definirVelocidade();
					try
					{
						Thread.sleep(500);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void navegar()
	{
		if(this.distanciaKm == 0)
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
			this.operar();
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
	
	public void operar()
	{
		System.out.println("--" +this.getNomeEmbarcacao());
		System.out.println("-Horas Passadas: " +this.getTempoHoras() +" Distância do Destino: " +this.getDistanciaKm());
		this.pilotoAutomatico();
		this.pilotoManual();
		this.distanciaKm -= this.velocidadeKmHora;
		this.tempoHoras++;
	}
	
	public boolean viagemFinalizada()
	
	{
		if(this.getDistanciaKm() == 0)
		{
			this.estadoMotor = false;
			this.navegacaoLiberada = false;
			this.rotaDefinida = false;
			this.tripulacaoDefinida = false;
			try
			{
				Thread.sleep(500);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
