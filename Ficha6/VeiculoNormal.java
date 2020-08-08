import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class VeiculoNormal extends Veiculo implements Serializable{
	public VeiculoNormal(){
		super();
	}

	public VeiculoNormal(String matricula, String marca, String modelo, int ano, double velocidade, double preco, List<Integer> classificacao, double kms){
		super(matricula, marca, modelo, ano, velocidade, preco, classificacao, kms);
	}

	public VeiculoNormal(VeiculoNormal car){
		super(car);		
	}

	public VeiculoNormal clone(){
		return new VeiculoNormal(this);
	}

	public boolean equals(Object o){
		return super.equals(o);
	}

	public String toString(){
		return super.toString();
	}

	public String toStringCSV(){
		return super.toStringCSV();
	}

	public double custoRealKm(){
		double coef = 1 + (super.getKms()/100000);
		double acrescimo = 1.1f;
		double r = super.getPreco() * acrescimo * coef;

		return r;
	}
}
