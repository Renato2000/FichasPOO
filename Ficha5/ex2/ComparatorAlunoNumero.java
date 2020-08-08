import java.util.Comparator;

public class ComparatorAlunoNumero implements Comparator<Aluno>{
	public int compare(Aluno a1, Aluno a2){
		String numA1 = a1.getNumero();
		String numA2 = a2.getNumero();
		//if(numA1.compareTo(numA2) < 0) return 1;
		//if(numA1.compareTo(numA2) > 0) return -1;
		return (numA1.compareTo(numA2) * -1);
	}
}