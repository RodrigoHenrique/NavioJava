package br.ufpa.cbcc.navio;

public final class Data {
	private final static int [] diasPorMes = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano)
	{
		this.dia = checarDia(dia,mes,ano);
		
		if(mes >= 1 && mes <= 12) this.mes = mes;
		else this.mes = 1;
		
		if(ano < 0) this.ano = 1900;
		else this.ano = ano;
	}
	
	private int checarDia(int dia, int mes, int ano)
	{
		int d = diasPorMes[mes];
		
		if((dia > 0) && (dia <= d)) return dia;
		if((mes == 2) && (dia == 29) && ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)))) return dia;
		System.out.println("Dia Inválido.");
		return 1;
	}
	
	public final void imprimeData()
	{
		System.out.println(+this.dia+"/"+this.mes+"/"+this.ano);
	}
	
	public final int getDia()
	{
		return this.dia;
	}
	
	public final int getMes()
	{
		return this.mes;
	}
	
	public final int getAno()
	
	{
		return this.ano;
	}
}
