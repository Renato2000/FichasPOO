import java.util.Comparator;
import java.io.Serializable;

public class ComparatorVeiculosNat implements Comparator<Veiculo>, Serializable{
	public int compare(Veiculo v1, Veiculo v2){
		int ret = v1.getMarca().compareTo(v2.getMarca());
		if(ret == 0) ret = v1.getModelo().compareTo(v2.getModelo());
		return ret;
	}
}