import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class DriveIt implements Serializable{
	private Map<String,Veiculo> cVeiculos;
	private Map<String, Comparator<Veiculo>> comparators;

	public DriveIt(){
		this.cVeiculos = new TreeMap<String,Veiculo>();
		this.comparators = new TreeMap<String,Comparator<Veiculo>>();
	}

	public DriveIt(Map<String,Veiculo> cVeiculos, Map<String, Comparator<Veiculo>> comparators){
		this.setCVeiculos(cVeiculos);
		this.comparators = comparators;
	}

	public DriveIt(DriveIt d){
		this.cVeiculos = d.getCVeiculos();
		this.comparators = d.getComparators();
	}

	public Map<String,Veiculo> getCVeiculos(){
		Map<String,Veiculo> ret = new TreeMap<String,Veiculo>();

		for(Map.Entry<String,Veiculo> a : this.cVeiculos.entrySet()){
			ret.put(a.getKey(), a.getValue());
		}

		return ret;
	}

	public Map<String,Comparator<Veiculo>> getComparators(){
		Map<String,Comparator<Veiculo>> ret = new TreeMap<String,Comparator<Veiculo>>();
		for(Map.Entry<String,Comparator<Veiculo>> c : this.comparators.entrySet()){
			ret.put(c.getKey(),c.getValue());
		}
		return ret;
	}

	public void setCVeiculos(Map<String,Veiculo> v){
		this.cVeiculos = new TreeMap<String,Veiculo>();

		for(Map.Entry<String,Veiculo> a : v.entrySet()){
			this.cVeiculos.put(a.getKey(), a.getValue());
		}
	}

	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null || o.getClass() != this.getClass()) return false;

		DriveIt d = (DriveIt) o;

		/*
			O equals dos Maps compara se os conjuntos Chave/Valor de um estão
		contidos no outro.
		*/
		return this.cVeiculos.equals(d.getCVeiculos());
	}

	public DriveIt clone(){
		return new DriveIt(this);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Veiculo v : this.cVeiculos.values()){
			sb.append(v.toString());
		}
		return sb.toString();
	}

	public boolean existeVeiculo(String cod){
		if(this.cVeiculos.get(cod) != null) return true; 
		return false;
	}

	public int quantos(){
		return this.cVeiculos.size();
	}

	public int quantos(String marca){
		int n = 0;
		for(Veiculo v : this.cVeiculos.values()){
			if(marca.equals(v.getMarca())) n += 1;
		}
		return n;
	}

	public Veiculo getVeiculo(String cod) throws VeiculoInexistenteException{
		Veiculo v = this.cVeiculos.get(cod);
		if(v == null) throw new VeiculoInexistenteException("Veiculo " + cod + " não existe.");
		return v.clone();
	}

	public void adiciona(Veiculo v) throws VeiculoRepetidoException, ValorInvalidoException{
		if(v == null) throw new ValorInvalidoException("O veículo é inválido.");
		if(this.cVeiculos.values().contains(v)) throw new VeiculoRepetidoException("O veículo é inválido.");
		this.cVeiculos.put(v.getMatricula(),v.clone());
	}

	public void adicionaComparator(String name, Comparator<Veiculo> c){
		this.comparators.put(name, c);
	}

	public List<Veiculo> getVeiculos(){
		return this.cVeiculos.values().stream()
							.map(Veiculo::clone)
							.collect(Collectors.toList());
	}

	public void adiciona(Set<Veiculo> vs){
		//vs.stream().foreach(a <- this.cVeiculos.put(a.getMatricula(),a.clone()));
		for(Veiculo v : vs){
			this.cVeiculos.put(v.getMatricula(),v.clone());
		}
	}

	public void registarAluguer(String codVeiculo, int numKms) throws VeiculoInexistenteException, ValorInvalidoException{
		Veiculo v = this.cVeiculos.get(codVeiculo);
		if(numKms < 0) throw new ValorInvalidoException(numKms + "é menor do que zero");
		if(v == null) throw new VeiculoInexistenteException("Veiculo " + codVeiculo + " não existe.");
		v.adicionaKms(numKms);
	}

	public void classificarVeiculo(String cod, int classificacao) throws VeiculoInexistenteException, ValorInvalidoException{
		if(classificacao < 0 && classificacao > 10) throw new ValorInvalidoException("Classificação " + classificacao + " é inválida");
		Integer c = Integer.valueOf(classificacao);
		Veiculo v = this.cVeiculos.get(cod);
		if(v == null) throw new VeiculoInexistenteException("Veiculo " + cod + " não existe.");
		v.adicionaClassificacao(classificacao);
	}

	public int custoRealKm(String cod) throws VeiculoInexistenteException{
		Veiculo v = this.cVeiculos.get(cod);
		if(v == null) throw new VeiculoInexistenteException("Veiculo" + cod + "não existe");
		return (int) v.custoRealKm();
	}

	public Set<Veiculo> ordenarVeiculosSet(){
		Set<Veiculo> ret = new TreeSet<>();
		this.cVeiculos.values().stream().forEach(v -> ret.add(v.clone()));
		return ret;
	}

	public List<Veiculo> ordenarVeiculosList(){
		List<Veiculo> ret = new ArrayList<>();
		this.cVeiculos.values().stream().forEach(v -> ret.add(v.clone()));
		ret.sort(new ComparatorVeiculosNat());
		return ret;
	}

	public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
		return this.cVeiculos.values().stream().sorted(c).map(Veiculo::clone).collect(Collectors.toCollection(TreeSet::new));
	}

	public Iterator<Veiculo> ordenarVeiculo(String criterio) throws ValorInvalidoException{
		Comparator<Veiculo> c = this.comparators.get(criterio);
		if(c == null) throw new ValorInvalidoException("O criterio " + criterio + " não existe.");
		Set<Veiculo> aux = ordenarVeiculos(c);
		Iterator<Veiculo> ret = aux.iterator();
		return ret;
	}

	public List<BonificaKms> daoPontos(){
		List<BonificaKms> ret = new ArrayList<>();
		for(Veiculo v : this.cVeiculos.values()){
			if(v instanceof AutocarroInteligente){
				AutocarroInteligente aux = (AutocarroInteligente) v;
				ret.add(aux.clone());
			}
			if(v instanceof VeiculoPremium){
				VeiculoPremium aux = (VeiculoPremium) v;
				ret.add(aux.clone());
			}
		}
		return ret;
	}

	public void gravaVeiculosCSV(String fileName) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(fileName);
		for(Veiculo v : this.cVeiculos.values()){
			pw.println(v.toStringCSV());
		}
		pw.flush();
		pw.close();
	}

	public void gravaEstado(String nome) throws FileNotFoundException, IOException{
		FileOutputStream fos = new FileOutputStream(nome);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.flush();
		oos.close();
	}

	public DriveIt leEstado(String nome) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(nome);
		ObjectInputStream ois = new ObjectInputStream(fis);
		DriveIt di = (DriveIt) ois.readObject();
		ois.close();
		return di;
	}
}