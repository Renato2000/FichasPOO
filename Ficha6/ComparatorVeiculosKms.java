import java.util.Comparator;
import java.lang.Double;

public class ComparatorVeiculosKms implements Comparator<Veiculo>{
	public int compare(Veiculo v1, Veiculo v2){
		Double a1 = Double.valueOf(v1.getKms());
		Double a2 = Double.valueOf(v2.getKms());
		int ret = a1.compareTo(a2);
		if(ret == 0) ret = v1.getModelo().compareTo(v2.getModelo());
		return ret;
	}
}