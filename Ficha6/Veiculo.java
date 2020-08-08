import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public abstract class Veiculo implements Comparable<Veiculo>, Serializable{
	private String matricula;
	private String marca;
	private String modelo;
	private int ano;
	private double velocidade;
	private double preco;
	private ArrayList<Integer> classificacao;
	private double kms;

	public Veiculo(){
		this.matricula = new String();
		this.marca = new String();
		this.modelo = new String();
		this.ano = 0;
		this.velocidade = 0.0;
		this.preco = 0.0;
		this.classificacao = new ArrayList<>();
		this.kms = 0.0;
	}

	public Veiculo(String matricula, String marca, String modelo, int ano, double velocidade, double preco, List<Integer> classificacao, double kms){
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.velocidade = velocidade;
		this.preco = preco;
		this.setClassificacao(classificacao);
		this.kms = kms;
	}

	public Veiculo(Veiculo car){
		this.matricula = car.getMatricula();
		this.marca = car.getMarca();
		this.modelo = car.getModelo();
		this.ano = car.getAno();
		this.velocidade = car.getVelocidade();
		this.preco = car.getPreco();
		this.setClassificacao(car.getClassificacao());
		this.kms = car.getKms();			
	}

	public String getMatricula(){
		return this.matricula;
	}

	public String getMarca(){
		return this.marca;
	}

	public String getModelo(){
		return this.modelo;
	}

	public int getAno(){
		return this.ano;
	}

	public double getVelocidade(){
		return this.velocidade;
	}

	public double getPreco(){
		return this.preco;
	}

	public List<Integer> getClassificacao(){
		List<Integer> ret = new ArrayList<Integer>();
		for(Integer i : this.classificacao){
			ret.add(i);
		}
		return ret;
	}

	public double getKms(){
		return this.kms;
	}

	public void setMatricula(String matricula){
		this.matricula = matricula;
	}

	public void setMarca(String marca){
		this.marca = marca;
	}

	public void setModelo(String modelo){
		this.modelo = modelo;
	}

	public void setAno(int ano){
		this.ano = ano;
	}

	public void setVelocidade(double velocidade){
		this.velocidade = velocidade;
	}

	public void setPreco(double preco){
		this.preco = preco;
	}

	public void setClassificacao(List<Integer> classificacao){
		this.classificacao = new ArrayList<Integer>();
		for(Integer i : classificacao){
			this.classificacao.add(i);
		}
	}

	public void setKms(double kms){
		this.kms = kms;
	}

	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		
		Veiculo v = (Veiculo) o;

		return(this.matricula.equals(v.getMatricula())
			&& this.marca.equals(v.getMarca())
			&& this.modelo.equals(v.getModelo())
			&& this.ano == v.getAno()
			&& this.velocidade == v.getVelocidade()
			&& this.preco == v.getPreco()
			&& this.classificacao == v.getClassificacao()
			&& this.kms == v.getKms());
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append("Matricula: ").append(this.matricula).append("\n")
			.append("Marca: ").append(this.marca).append("\n")
			.append("Modelo: ").append(this.modelo).append("\n")
			.append("Ano: ").append(this.ano).append("\n")
			.append("Velocidade: ").append(this.velocidade).append("\n")
			.append("Preco p/ Km: ").append(this.preco).append("\n")
			.append("Kms: ").append(this.kms).append("\n")
			.append("Avaliações: ");

		for(Integer i : this.classificacao){
			sb.append(i.toString()).append(" ");
		}

		return sb.append("\n").toString();
	}

	public String toStringCSV(){
		StringBuilder sb = new StringBuilder();

		sb.append(this.matricula).append(", ")
			.append(this.marca).append(", ")
			.append(this.modelo).append(", ")
			.append(this.ano).append(", ")
			.append(this.velocidade).append(", ")
			.append(this.preco).append(", ")
			.append(this.kms).append(", ");

		for(Integer i : this.classificacao){
			sb.append(i.toString()).append(", ");
		}

		return sb.toString();
	}

	public abstract Veiculo clone();

	public abstract double custoRealKm();

	public void adicionaKms(double kms){
		this.kms += kms;
	}

	public void adicionaClassificacao(Integer classificacao){
		this.classificacao.add(classificacao);
	}

	public int compareTo(Veiculo v){
		int ret = this.getMarca().compareTo(v.getMarca());
		if(ret == 0) ret = this.getModelo().compareTo(v.getModelo());
		return ret;
	}
}
