import java.util.List;
import java.io.Serializable;

public class VeiculoPremium extends Veiculo implements BonificaKms, Serializable{
	public double taxa;
	public int pontosKm;

	public VeiculoPremium(){
		super();
		this.taxa = 0.0;
		this.pontosKm = 0;
	}

	public VeiculoPremium(String matricula, String marca, String modelo, int ano, double velocidade, double preco, List<Integer> classificacao, double kms, double taxa){
		super(matricula, marca, modelo, ano, velocidade, preco, classificacao, kms);
		this.taxa = taxa;
		this.pontosKm = 0;
	}

	public VeiculoPremium(String matricula, String marca, String modelo, int ano, double velocidade, double preco, List<Integer> classificacao, double kms, double taxa, int pontosKm){
		super(matricula, marca, modelo, ano, velocidade, preco, classificacao, kms);
		this.taxa = taxa;
		this.pontosKm = pontosKm;
	}

	public VeiculoPremium(VeiculoPremium car){
		super(car);
		this.taxa = car.getTaxa();
		this.pontosKm = car.getPontosKm();
	}

	public double getTaxa(){
		return this.taxa;
	}

	public void setTaxa(double taxa){
		this.taxa = taxa;
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

	public VeiculoPremium clone(){
		return new VeiculoPremium(this);
	}

	public boolean equals(Object o){
		if(!super.equals(o)) return false;
		VeiculoPremium v = (VeiculoPremium) o;
		return v.taxa == v.getTaxa() && this.pontosKm == v.getPontosKm();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("Taxa: ").append(this.taxa).append("\nPontosKm: ").append(this.pontosKm).append("\n");
		return sb.toString();
	}

	public String toStringCSV(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toStringCSV()).append(this.taxa).append(", ").append(this.pontosKm);
		return sb.toString();
	}

	public double custoRealKm(){
		double coef = 1 + (super.getKms()/100000);
		double acrescimo = 1.1f;
		double r = super.getPreco() * acrescimo * coef * taxa;

		return r;
	}
}