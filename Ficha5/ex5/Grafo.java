import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Grafo{
	private Map<Integer, Set<Integer>> adj;

	public Grafo(){
		//this.adj = new HashMap<Integer, Set<Integer>>();
		this.adj = new HashMap<>();
	}

	public Grafo(Map<Integer, Set<Integer>> adj){
		//this.adj = adj; Em agregação
		this.adj = new HashMap<>();
		for(Map.Entry<Integer, Set<Integer>> e : adj.entrySet()){
			adj.put(e.getKey(), new TreeSet(e.getValue()));
		}
	}

	public Grafo(Grafo g){
		this.adj = g.getAdj();
	}

	public void addArco(Integer vOrig, Integer vDest){
		//if(!adj.containsKey(vOrig)) adj.put(vOrig, new TreeSet<>()); //O vertice de origem pode não existir
		adj.putIfAbsent(vOrig, new TreeSet<>());
		
		//if(!adj.containsKey(vDest)) adj.put(vOrig, new TreeSet<>()); //O vertice de destino pode não existir
		adj.putIfAbsent(vDest, new TreeSet<>());
		
		adj.get(vOrig).add(vDest);
	}

	public boolean inSink(Integer v){
		/*
		if(!this.adj.containsKey(v)) return false;
		else return this.adj.get(v).isEmpty();
		*/
		return this.adj.containsKey(v) && this.adj.get(v).isEmpty();
	}

	public boolean isSource(Integer v){
		boolean vIsSource = this.adj.containsKey(v);
		Iterator<Set<Integer>> i = this.adj.values().iterator();
		
		while(i.hasNext() && vIsSource){
			Set<Integer> aux = i.next();
			if(aux.contains(v)) vIsSource = false;
		}
		
		return vIsSource;
	}

	public int size(){
		int r = this.adj.size(); //Nrº de vertices

		for(Set<Integer> s : this.adj.values()){
			r += s.size();
		}

		return r;
	}

	public int sizeStream(){
		int r = this.adj.size(); //Nrº de vertices

		r += this.adj.values().stream().mapToInt(s -> s.size()).sum();
	
		return r;
	}

	public boolean haCaminho(Integer vOrig, Integer vDest){
		return haCaminho(vOrig, vDest, new TreeSet<>());
	}

	private boolean haCaminho(Integer vOrig, Integer vDest, Set<Integer> visitados){
		boolean existe = false;
		if(vOrig == vDest) existe = true;
		else if(!adj.containsKey(vOrig)) existe = false;
		else if(!adj.containsKey(vDest)) existe = false;
		else if(visitados.contains(vOrig)) existe  = false;
		else{
			Iterator<Integer> i = adj.get(vOrig).iterator();
			existe = false;
			visitados.add(vOrig);
			while(i.hasNext() && !existe){
				Integer novaOrigem = i.next();
				existe = haCaminho(novaOrigem, vDest, visitados);
			}
		}
		return existe;
	}
	
	public List<Integer> getCaminho(Integer vOrig, Integer vDest){
		return getCaminho(vOrig, vDest, new TreeSet<>());
	}

	private List<Integer> getCaminho(Integer vOrig, Integer vDest, Set<Integer> visitados){
		List<Integer> caminho;
		if(!adj.containsKey(vOrig)) caminho = null;
		else if(!adj.containsKey(vDest)) caminho = null;
		else if(vOrig == vDest){
			caminho = new ArrayList<>();
			caminho.add(vOrig);
			caminho.add(vDest);
		}
		else if(visitados.contains(vOrig)) caminho = null;
		else{
			Iterator<Integer> i = adj.get(vOrig).iterator();
			caminho = null;
			visitados.add(vOrig);
			while(i.hasNext() && caminho == null){
				Integer novaOrigem = i.next();
				caminho = getCaminho(novaOrigem, vDest, visitados);
				if(caminho != null) caminho.add(0, vOrig);
			}
		}

		return caminho;
	}

	public boolean haCaminhoAlternativo(Integer vOrig, Integer vDest){
		return(getCaminho(vOrig, vDest) != null);
	}

	public Set<Map.Entry<Integer, Integer>> fanOut(Integer v){
		Set<Map.Entry<Integer, Integer>> res = new TreeSet<>();
		for(Integer i : this.adj.get(v)){
			res.add(new SimpleEntry<>(v,i));
		}
		return res;
	}

	public Set<Map.Entry<Integer, Integer>> fanIn(Integer v){
		Set<Map.Entry<Integer, Integer>> res = new TreeSet<>();
		for(Entry<Integer, Set<Integer>> e : this.adj.entrySet()){
			if(e.getValue().contains(v)){
				res.add(new SimpleEntry<>(e.getKey(), v));
			}
		}
		return res;
	}
}