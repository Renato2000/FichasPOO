import java.util.Map; 
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TurmaAlunos{
	private Map<String, Aluno> alunos;
	private String nome;
	private String codigo;

	public TurmaAlunos(){
		this.alunos = new HashMap<>();
		this.nome = new String();
		this.codigo = new String();
	}

	public TurmaAlunos(Map<String, Aluno> als, String nomeTurma, String codigoTurma){
		this.nome = nomeTurma;
		this.codigo = codigoTurma;
		setAlunos(als);	
	}

	public TurmaAlunos(TurmaAlunos ta){
		this.nome = ta.getNome();
		this.codigo = ta.getCodigo();
		setAlunos(ta.getAlunos());
	}

	public String getNome(){
		return this.nome;
	}

	public String getCodigo(){
		return this.codigo;
	}

	public Map<String, Aluno> getAlunos(){
		Map<String, Aluno> ret = new HashMap<String, Aluno>();
		for(Map.Entry<String, Aluno> e : alunos.entrySet()){
			ret.put(e.getKey(), e.getValue().clone());
		}
		return ret;
	}

	public Map<String, Aluno> getAlunos2(){
		Map<String, Aluno> ret = new HashMap<String, Aluno>();
		alunos.forEach((a,b) -> ret.put(a,b.clone()));
		return ret;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}

	public void setAlunos(Map<String, Aluno> als){
		this.alunos = new HashMap<>();
		als.entrySet().forEach(e -> this.alunos.put(e.getKey(), e.getValue().clone()));
	}

	public TurmaAlunos clone(){
		return new TurmaAlunos(this);
	}

	public int compareTo(TurmaAlunos a){
		return this.nome.compareTo(a.getNome());
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Turma: ").append(this.nome).append("\n")
			.append("Codigo: ").append(this.codigo).append("\n")
			.append(this.alunos);
		return sb.toString();
	}

	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		TurmaAlunos t = (TurmaAlunos) o;

		return this.nome.equals(t.getNome()) &&
			this.codigo.equals(t.getCodigo()) &&
			this.alunos.equals(t.getAlunos());
	}

	public void insereAluno(Aluno a){
		this.alunos.put(a.getNumero(), a.clone());
	}

	public Aluno getAluno(String codAluno){
		this.alunos.get(codAluno).clone();
	}

	public Aluno removeAluno(String codAluno){
		this.alunos.remove(codAluno);
	}

	public Set<String> todosOsCodigos(){
		//Se nao copiar os dados para uma nova estrutura, eles
		//ainda vão estar ligados ao respetivo valor,
		//revelando informação interna.
		return new TreeSet<String>(this.alunos.keySet());
	}

	public Set<Aluno> alunosOrdemAlfabetica(){
		Set<Aluno> ret = new TreeSet<>(); //Ao contrario do HashSet, na TreeSet a informação vai ficar ordenada(unsa o compareTo);
		for(Aluno a  : alunos.values()){
			ret.add(a);
		}
		return ret;
	}

	public Set<Aluno> alunosOrdemAlfabeticaStream(){
		return this.alunos.values()
							.stream()
							.sorted()
							.map(Aluno::clone)
							.collect(Collectors.toCollection(TreeSet::new));
	}

	public Set<Aluno> alunosOrdemDecrescenteNumero(){
		Set<Aluno> ret = new TreeSet<>(new ComparatorAlunoNumero());
		for(Aluno a : this.alunos.values()){
			ret.put(a.clone());
		}
		return ret;
	}
}