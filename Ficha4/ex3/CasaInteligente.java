import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Iterator;

public class CasaInteligente{
	private List<Lampada> lampadas; 

	public CasaInteligente(){
		this.lampadas = new ArrayList<Lampada>();
	}
	
	public CasaInteligente(List<Lampada> l){
		this.setLampadas(lampadas);
	}

	public CasaInteligente(CasaInteligente c){
		this.setLampadas(c.getLampadas());
	}

	public List<Lampada> getLampadas(){
		return getLampadasExternalIterator();
	}

	//Iterador externo
	public List<Lampada> getLampadasExternalIterator(){
		ArrayList<Lampada> aux = new ArrayList<>();
		for(Lampada l : this.lampadas){
			aux.add(l.clone());
		}
		return aux;
	}

	//Iterador interno
	public List<Lampada> getLampadasInternalIterator(){
		return this.lampadas
						.stream()
						.map(Lampada::clone)
						.collect(Collectors.toList());
	}

	public List<Lampada> getLampadasIterator(){
		ArrayList<Lampada> res = new ArrayList<>();
		Iterator<Lampada> it = this.lampadas.iterator();
		while(it.hasNext()){
			Lampada l = it.next();
			res.add(l.clone());
		}
		return res;
	}

	public void setLampadas(List<Lampada> l){
		setLampadasExternalIterator(l);
	}

	//Iterador externo
	public void setLampadasExternalIterator(List<Lampada> ls){
		this.lampadas = new ArrayList<>();
		for(Lampada l : ls)
			this.lampadas.add(l.clone());
	}

	//Iterador interno
	public void setLampadasInternalIterator(List<Lampada> ls){
		this.lampadas = ls.stream().map(Lampada::clone).collect(Collectors.toList());
	}

	public void setLampadasIterator(List<Lampada> ls){
		this.lampadas = new ArrayList<>();
		Iterator<Lampada> it = ls.iterator();
		while(it.hasNext()){
			Lampada l = it.next();
			this.lampadas.add(l.clone());
		}
	}

	public CasaInteligente clone(){
		return new CasaInteligente(this);
	}

	/*
	public String toString(){

	}
	*/

	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || o.getClass() != this.getClass()) return false;
		CasaInteligente ci = (CasaInteligente) o;

		return ci.getLampadas().stream().allMatch(a -> this.lampadas.contains(a));
	}

	public void addLampada(Lampada l){
		this.lampadas.add(l);
	}

	public void ligaLampadaNormal(int index){
		this.lampadas.get(index).lampON();
	}

	public void ligaLampadaEco(int index){
		this.lampadas.get(index).lampECO();
	}


	public int qtEmEcoExternalIterator(){
		int ac = 0;
		for(Lampada l : this.lampadas)
			if(l.getModo() == 'E')
				ac++;
		return ac;
	}
	
	public int qtEmECOIt(){
		int ac = 0;
		Iterator<Lampada> it = this.lampadas.iterator();
		while(it.hasNext()){
			Lampada l = it.next();
			if(l.getModo() == 'E')
				ac++;
		}
		return ac;
	}	

	public int qtEmEcoInternalIterator(){
		return (int) lampadas
						.stream()
						.filter(l->l.getModo() == 'E')
						.count();
	}

	public void removeLampada(int index){
		this.lampadas.remove(index);
	}

	public void ligaTodasEco(){
		this.lampadas.stream().forEach(l -> l.lampECO());
	}

	public void ligaTodasMax(){
		this.lampadas.stream().forEach(l -> l.lampON());
	}

	public double consumoTotal(){
		return (double) this.lampadas.stream().mapToDouble(Lampada::totalConsumo).sum();
	}

	public void reset(){
		for(Lampada l : lampadas)
			l.resetPeriodo();
	}
}