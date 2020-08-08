import java.util.Map; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.List;
import java.time.LocalDate;

public class GestaoEncomenda{
	private Map<String,EncEficiente> gesEnc;

	public GestaoEncomenda(){
		this.gesEnc = new HashMap<>();
	}

	public GestaoEncomenda(Map<String,EncEficiente> encomenda){
		this.setGesEnc(encomenda);
	}

	public GestaoEncomenda(GestaoEncomenda outraEnc){
		this.setGesEnc(outraEnc.getGesEnc());
	}

	public Map<String,EncEficiente> getGesEnc(){
		Map<String,EncEficiente> ret = new HashMap<>();
		for(Map.Entry<String,EncEficiente> a : this.gesEnc.entrySet())
			ret.put(a.getKey(),a.getValue());
		return ret;
	}

	public void setGesEnc(Map<String,EncEficiente> g){
		this.gesEnc = new HashMap<>();
		for(Map.Entry<String,EncEficiente> a : g.entrySet())
			this.gesEnc.put(a.getKey(),a.getValue());
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,EncEficiente> a : this.gesEnc.entrySet())
			sb.append("Codigo da encomenda: ")
				.append(a.getKey())
				.append("\n")
				.append(a.getValue().toString())
				.append("\n");
		return sb.toString();
	}

	public GestaoEncomenda clone(){
		return new GestaoEncomenda(this);
	}

	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		GestaoEncomenda e = (GestaoEncomenda) o;
		return(e.getGesEnc().values().stream().allMatch(a -> this.gesEnc.containsValue(a)));
	}

	public Set<String> todosCodigosEnc(){
		/*
		Set<String> ret = new Set<>();
		for(String k : this.gesEnc.keySet())
			ret.put(k);
		return ret;
		*/
		return this.gesEnc.keySet();
	}

	public void addEncomenda(EncEficiente enc){
		this.gesEnc.put(enc.getNrEncomenda(), enc.clone());
	}

	public EncEficiente getEncomenda(String codEnc){
		return this.gesEnc.get(codEnc).clone();
	}	

	public void removeEncomenda(String codEnc){
		this.gesEnc.remove(codEnc);
	}

	public String encomendaComMaisProdutos(){
		String ret = new String();
		int m = 0;
		int n;
		for(String s : this.gesEnc.keySet()){
			n = this.gesEnc.get(s).numeroTotalProdutos();
			if(n > m){
				m = n;
				ret = s;
			}
		}
		return ret;
	}

	public Set<String> encomendasComProduto(String codProd){
		Set<String> ret = new HashSet<>();
		for(String s : this.gesEnc.keySet()){
			if(this.gesEnc.get(s).existeProdutoEncomenda(codProd)) ret.add(s);
		}
		return ret;
	}

	public Set<String> encomendasAposData(LocalDate d){
		Set<String> ret = new HashSet<>();
		for(String s : this.gesEnc.keySet()){
			if(d.isAfter(this.gesEnc.get(s).getData())){
				ret.add(s);
			}
		}
		return ret;
	}

	public Set<EncEficiente> encomendasValorDecrescente(){
		Set<EncEficiente> ret = new TreeSet<>(new ComparatorEncEficiente());
		for(EncEficiente e : this.gesEnc.values()){
			ret.add(e.clone());
		}
		return ret;
	}

	public Map<String,List<String>> encomendasDeProduto(){
		Map<String,List<String>> ret = new HashMap<>();
		for(String codEnc : this.gesEnc.keySet()){
			List<String> refs = this.gesEnc.get(codEnc)
											.getLinhaEncomenda()
											.stream()
											.map(LinhaEncomenda::getReferencia)
											.collect(Collectors.toList());
			for(String ref : refs){
				if(ret.get(ref) == null){
					List<String> novo = new ArrayList<>(); 
					novo.add(codEnc);
					ret.put(ref, novo);
				}
				else{
					ret.get(ref).add(codEnc);
				}
			}			
		}
		return ret;
	}
}