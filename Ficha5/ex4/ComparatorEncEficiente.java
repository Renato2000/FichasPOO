import java.util.Comparator;

public class ComparatorEncEficiente implements Comparator<EncEficiente>{
	public int compare(EncEficiente e1, EncEficiente e2){
		double n1 = e1.calculaValorDesconto();
		double n2 = e2.calculaValorDesconto();
		if(n1 > n2) return -1;
		else if(n1 < n2) return 1;
		else return 0;	
	}
}