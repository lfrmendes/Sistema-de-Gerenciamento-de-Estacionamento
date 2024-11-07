package estacionamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	List<Vaga> listaDeVagas = new ArrayList();
	List<Veiculo> listaDeVeiculos = new ArrayList();
	
	
	public void adicionarVaga(Vaga vaga) 
	{
		listaDeVagas.add(vaga);
	}
	
	public Vaga acharVagaDisponivel(String tamanhoVaga) 
	{
		for (Vaga vaga : listaDeVagas) 
		{
			if(vaga.isDisponibilidade() && vaga.getTamanhoVaga().equals(tamanhoVaga)) 
			{
				return vaga;
			}
		}
		return null;
	}
	
	public void registrarEntrada(Veiculo veiculo) 
	{
		Vaga vaga = acharVagaDisponivel(veiculo.getTamanho());
			
			if(vaga != null) 
			{
				vaga.ocuparVaga();
				veiculo.setHorarioEntrada(LocalDateTime.now());
				listaDeVeiculos.add(veiculo);
				System.out.println("Registrado:"+vaga.getNumeroVaga());
			}
			
			else 
			{
				System.out.println("Vaga não disponivel pra esse tamanho");
			}
	}
			
	public void registrarSaida(String placaVeiculo) 
	{
		for (Veiculo veiculo : listaDeVeiculos) 
		{
			if(veiculo.getPlacaVeiculo().equals(placaVeiculo)) 
			{
				veiculo.setHorarioSaida(LocalDateTime.now());
				int tempo = veiculo.tempoFicado();
				double valor = veiculo.somaValorMinutos();
				
				System.out.println("Veiculo " +placaVeiculo+ " tempo " +tempo);
				System.out.println("Valor total para pagar " +valor);
				
				
				for (Vaga vaga : listaDeVagas) {
					if(!vaga.isDisponibilidade())
						vaga.liberarVaga();
				}
					listaDeVeiculos.remove(veiculo);
				return;
			}
		}
		System.out.println("Nenhum veiculo correspondente");
	}
			
	public void mostrarVagasOcupadas() 
	{
		for (Vaga vaga : listaDeVagas) {
			if(!vaga.isDisponibilidade()) 
			{
				for (Veiculo veiculo : listaDeVeiculos) {
					if(veiculo.getHorarioEntrada() != null) 
					{
						System.out.println("Vaga: " + vaga.getNumeroVaga() + " | Ocupada por: " + veiculo.getPlacaVeiculo());
					}
				}
			}
		}
	}
		public void mostrarHistoricoVeiculos() 
		{
			for (Veiculo veiculo : listaDeVeiculos) 
			{
				  System.out.println("Placa: " + veiculo.getPlacaVeiculo());
		          System.out.println("Modelo: " + veiculo.getModeloVeiculo());
		          System.out.println("Entrada " + veiculo.getHorarioEntrada());
		          System.out.println("Saída: " + veiculo.getHorarioSaida());
		          System.out.println("Tempo ficado " + veiculo.tempoFicado() + " minutos");
		          System.out.println("Valor pago: R$ " + veiculo.somaValorMinutos());
		          System.out.println();
				
			}
		}
}
