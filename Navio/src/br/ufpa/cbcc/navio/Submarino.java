package br.ufpa.cbcc.navio;

public class Submarino extends Embarcacao{
	private String tipoCombustivel;
	private boolean isSubmerso;
	
	public Submarino(String nomeEmbarcacao, Data dataRegistro, String proprietario, String portoPartida, String tipoCombustivel)
	{
		super(nomeEmbarcacao,dataRegistro,proprietario,portoPartida);
		this.tipoCombustivel = tipoCombustivel;
		this.isSubmerso = false;
	}
	
	public final String getTipoCombustivel()
	{
		return this.tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel)
	{
		this.tipoCombustivel = tipoCombustivel;
	}
	
	public boolean mover()
	{
		//this.setNavegacaoLiberada();
		if(this.getNavegacaoLiberada()) this.isSubmerso = true;
		if(this.isSubmerso) return true;
		else return false;
	}
	
	public int definirVelocidade()
	{
		if(this.getEstadoMotor())
		{
			int nivelVelocidade;
			System.out.println("Mudar nível de Velocidade?");
			System.out.println("0 -> 0 Km/h");
			System.out.println("1 -> 3 Km/h");
			System.out.println("2 -> 9 Km/h");
			System.out.println("3 -> 27 Km/h");
			System.out.println("4 -> 81 Km/h");
			System.out.print("Resposta: ");
			nivelVelocidade = ler.nextInt();
			
			switch(nivelVelocidade)
			{
				case 0:
					return 0;
				case 1:
					return 3;
				case 2:
					return 9;
				case 3:
					return 27;
				case 4:
					return 81;
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

}