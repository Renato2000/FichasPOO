import java.util.List;
import java.io.Serializable;

public class AutocarroInteligente extends Veiculo implements BonificaKms, Serializable{
	private double taxaOcupacao;
	private int pontosKm;

	public AutocarroInteligente(){
		super();
		this.taxaOcupacao = 0.0;
		this.pontosKm = 0;
	}

	public AutocarroInteligente(String matricula, String marca, String modelo, int ano, double velocidade, double preco, List<Integer> classificacao, double kms, double taxaOcupacao){
		super(matricula, marca, modelo, ano, velocidade, preco, classificacao, kms);
		this.taxaOcupacao = taxaOcupacao;
	}

	public AutocarroInteligente(String matricula, String marca, String modelo, int ano, double velocidade, double preco, List<Integer> classificacao, double kms, double taxaOcupacao, int pontosKm){
		super(matricula, marca, modelo, ano, velocidade, preco, classificacao, kms);
		this.taxaOcupacao = taxaOcupacao;
		this.pontosKm = pontosKm;
	}

	public AutocarroInteligente(AutocarroInteligente car){
		super(car);
		this.taxaOcupacao = car.getTaxaOcupacao();
		this.pontosKm = car.getPontosKm();
	}

	public double getTaxaOcupacao(){
		return this.taxaOcupacao;
	}

	public AutocarroInteligente clone(){
		return new AutocarroInteligente(this);
	}

	public boolean equals(Object o){
		if(!super.equals(o)) return false;
		AutocarroInteligente v = (AutocarroInteligente) o;
		return this.taxaOcupacao == v.getTaxaOcupacao() && this.pontosKm == v.getPontosKm();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("Taxa ocupação: ").append(this.taxaOcupacao).append("\nPontosKm: ").append(this.pontosKm).append("\n");
		return sb.toString();
	}

	public String toStringCSV(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toStringCSV()).append(this.taxaOcupacao).append(", ").append(this.pontosKm);
		return sb.toString();
	}

	public void setTaxaOcupacao(double taxaOcupacao){
		this.taxaOcupacao = taxaOcupacao;
	}

	public int getPontosKm(){
		return this.pontosKm;
	}

	public void setPontosKm(int pontosKm){
		this.pontosKm = pontosKm;
	}

	public int getPontosAcomulados(){
		return (int) super.getKms() * this.pontosKm;
	}

	public double custoRealKm(){
		double coef = 1 + (super.getKms()/100000);
		double acrescimo = 1.1f;
		double r = super.getPreco() * acrescimo * coef;

		if(this.taxaOcupacao < 0.61) r = r * 0.5;
		else r = r * 0.75;

		return r;
	}	
}