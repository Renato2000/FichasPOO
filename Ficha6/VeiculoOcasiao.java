import java.util.List;
import java.io.Serializable;

public class VeiculoOcasiao extends Veiculo implements Serializable{
	private boolean promocao;

	public VeiculoOcasiao(){
		super();
		this.promocao = false;
	}

	public VeiculoOcasiao(String matricula, String marca, String modelo, int ano, double velocidade, double preco, List<Integer> classificacao, double kms, boolean promocao){
		super(matricula, marca, modelo, ano, velocidade, preco, classificacao, kms);
		this.promocao = promocao;
	}

	public VeiculoOcasiao(VeiculoOcasiao car){
		super(car);
		this.promocao = car.getPromocao();
	}

	public boolean getPromocao(){
		return this.promocao;
	}

	public void setPromocao(boolean promocao){
		this.promocao = promocao;
	}

	public VeiculoOcasiao clone(){
		return new VeiculoOcasiao(this);
	}

	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null || o.getClass() != this.getClass()) return false;

		VeiculoOcasiao v = (VeiculoOcasiao) o;

		return super.equals(v) && this.promocao == v.getPromocao();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("Promocao? ").append(this.promocao).append("\n");
		return sb.toString();
	}

	public String toStringCSV(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toStringCSV()).append(", ").append(this.promocao);
		return sb.toString();
	}


	public double custoRealKm(){
		double coef = 1 + (super.getKms()/100000);
		double acrescimo = 1.1;
		double c = super.getPreco() * acrescimo * coef;
		if(this.promocao == true) c = c * 0.75;
		return c;
	}

	public void ativarPromocao(){
		this.promocao = true;
	}

	public void desativarPromocao(){
		this.promocao = false;
	}
}