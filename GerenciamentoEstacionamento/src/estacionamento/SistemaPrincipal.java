package estacionamento;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SistemaPrincipal {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Estacionamento estacionamento = new Estacionamento();
		
		int opcao = 0;
		
		while(opcao != 6) 
		{
			System.out.println("1- Cadastrar Vagas 2- Resgistrar Entrada 3- Registrar Saida 4- Mostrar Vagas Ocupadas 5- Mostrar Historicos de veiculos 6- Encerrar");
			opcao = scan.nextInt();
			
			switch(opcao) 
			{
			
				case 1:
				{
				    System.out.println("Qual numero da vaga");
                    int numeroVaga = scan.nextInt();

                    System.out.println("Qual tamanho da vaga (pequeno, medio, grande)");
                    String tamanhoVaga = scan.next();

                    Vaga novaVaga = new Vaga(numeroVaga, tamanhoVaga, true);
                    estacionamento.adicionarVaga(novaVaga);

                    System.out.println("Vaga adicionada");
                    break;
				}

				case 2:
				{
					 System.out.println("Qual a placa do veículo:");
	                 String placa = scan.next();
	                 
	                 System.out.println("Qual o modelo do veículo:");
	                 String modelo = scan.next();
	                 
	                 System.out.println("Qual o tamanho do veículo (pequeno, medio, grande):");
	                 String tamanho = scan.next();
	                 
	                 Veiculo veiculo = new Veiculo(placa,modelo,tamanho,LocalDateTime.now(),null);
	                 estacionamento.registrarEntrada(veiculo);
	                 
	             break;
				}
				case 3:
				{
					System.out.println("Qual a placa do carro ");
					String placaVeiculoSaida = scan.next();
					estacionamento.registrarSaida(placaVeiculoSaida);
				break;
				}
				case 4:
				{
					estacionamento.mostrarVagasOcupadas();
				break;
				}
				case 5:
				{
					estacionamento.mostrarHistoricoVeiculos();
				break;
				}
				case 6:
				{
					System.out.println("saindo");
				break;
				}
			}
			
		}
		
		
	}

}
