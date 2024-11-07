package estacionamento;

import java.time.LocalDateTime;

public class Veiculo {

	private String placaVeiculo;
	private String modeloVeiculo;
	private String tamanho;
	private LocalDateTime horarioEntrada;
	private LocalDateTime horarioSaida;
	
	public Veiculo(String placaVeiculo, String modeloVeiculo, String tamanho, LocalDateTime horarioEntrada,LocalDateTime horarioSaida) {
			
		this.placaVeiculo = placaVeiculo;
		this.modeloVeiculo = modeloVeiculo;
		this.tamanho = tamanho;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public LocalDateTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalDateTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalDateTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
	public int tempoFicado() 
	{
		if(horarioSaida == null) 
		{
			return 0;
		}
		
		int horas = horarioSaida.getHour() - horarioEntrada.getHour();
		int minutos = horarioSaida.getMinute() - horarioEntrada.getMinute();
		
		if(minutos<0) 
		{
			minutos += 60;
			horas--;
		}
		
		return horas* 60 + minutos;
	
	}

	public double somaValorMinutos() 
	{
		int minutos = tempoFicado();
		
		if(minutos <= 60) 
		{
			return 5.0;
		}
		
		else if (minutos<= 100)
		{
			return 10.0;
		}
		
		else 
		{
			return 15.0;
		}
	}
	
}
