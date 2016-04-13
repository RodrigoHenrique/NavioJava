package br.ufpa.cbcc.navio;

public class Navio extends Embarcacao{
	private boolean passageirosABordo;
	private boolean cargasABordo;
	private boolean mercadoriasABordo;
	
	public Navio(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida)
	{
		super(nomeEmbarcacao,dataRegistro,proprietario,portoPartida);
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

	public static void main(String[] args)
	{
		Data dataTeste = new Data(1,1,2016);
		Navio navioTeste = new Navio("Balerion",dataTeste,"Dany","Mereen");
		
		navioTeste.definirRota();
		navioTeste.definirTripulacao();
		navioTeste.ligarMotores();
		navioTeste.definirVelocidade();
		navioTeste.navegar();
		if(navioTeste.viagemFinalizada()) System.out.println("Finalizada Simulação 1.");
		
		Data dataTeste2 = new Data(2,1,2016);
		Navio navioTeste2 = new Navio("Meraxes",dataTeste2,"Dany","Mereen");
		
		navioTeste2.definirRota("Volantis","Porto Real");
		navioTeste2.definirTripulacao();
		navioTeste2.ligarMotores();
		navioTeste2.definirVelocidade();
		navioTeste2.navegar();
		if(navioTeste2.viagemFinalizada()) System.out.println("Finalizada Simulação 2.");
	}
}