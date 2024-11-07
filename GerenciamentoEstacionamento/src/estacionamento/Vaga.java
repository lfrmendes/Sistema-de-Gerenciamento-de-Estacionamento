package estacionamento;

public class Vaga {

	private int numeroVaga;
	private String tamanhoVaga;
	boolean disponibilidade;
	
	public Vaga(int numeroVaga, String tamanhoVaga, boolean disponibilidade) {
		this.numeroVaga = numeroVaga;
		this.tamanhoVaga = tamanhoVaga;
		this.disponibilidade = disponibilidade;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public String getTamanhoVaga() {
		return tamanhoVaga;
	}

	public void setTamanhoVaga(String tamanhoVaga) {
		this.tamanhoVaga = tamanhoVaga;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public void ocuparVaga() 
	{
		this.disponibilidade = false;
	}
	
	public void liberarVaga() 
	{
		this.disponibilidade = true;
	}
}
