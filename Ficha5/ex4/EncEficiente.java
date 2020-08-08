import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class EncEficiente{
	//Variáveis de instancia
	List<LinhaEncomenda> linhaEncomenda;
	String nome;
	String nif;
	String morada;
	String nrEncomenda;
	LocalDate data;

	/**
	 * Construtores da classe EncEficiente.
     * Declaração dos construtores por omissão (vazio),
     * parametrizado e de cópia.

    /**
     * Contrutor por omissão de EncEficiente.
     */
	public EncEficiente(){
		this.setLinhaEncomenda(new ArrayList<LinhaEncomenda>());
		this.setNome("");
		this.setNif("");
		this.setMorada("");
		this.setNrEncomenda("");
		this.setData(LocalDate.parse("2000-01-01"));
	}
	
    /**
     * Construtor parametrizado de EncEficiente.
     */	
	public EncEficiente(ArrayList<LinhaEncomenda> linhaEncomenda, String nome, String nif, String morada, String nrEncomenda, LocalDate data){
		this.setLinhaEncomenda(linhaEncomenda);
		this.setNome(nome);
		this.setNif(nif);
		this.setMorada(morada);
		this.setNrEncomenda(nrEncomenda);
		this.setData(data);
	}

    /**
     * Construtor de cópia de EncEficiente.
     * Aceita como parâmetro outra EncEficiente e utiliza os métodos
     * de acesso aos valores das variáveis de instância.
     */
	public EncEficiente(EncEficiente o){
		this.setLinhaEncomenda(o.getLinhaEncomenda());
		this.setNome(o.getNome());
		this.setNif(o.getNif());
		this.setMorada(o.getMorada());
		this.setNrEncomenda(o.getNrEncomenda());
		this.setData(o.getData());
	}
  
    /**
     * métodos de instância
     */
  
    /**
     * Devolve o array list da EncEficiente.
     * 
     * @return array list da EncEficiente.
     */
	public ArrayList<LinhaEncomenda> getLinhaEncomenda(){
		ArrayList<LinhaEncomenda> returnLE = new ArrayList<>();
		for(LinhaEncomenda l: linhaEncomenda)
			returnLE.add(l.clone());
		return returnLE;
	}
   
    /**
     * Devolve a String nome.
     * 
     * @return String nome da EncEficiente.
     */
	public String getNome(){
		return new String(this.nome);
	}

    /**
     * Devolve a String NIF da EncEficiente.
     * 
     * @return String NIF da EncEficiente.
     */
	public String getNif(){
		return new String(this.nif);
	}

    /**
     * Devolve String morada da EncEficiente.
     * 
     * @return String morada da EncEficiente.
     */
	public String getMorada(){
		return new String(this.morada);
	}

    /**
     * Devolve o número de encomendas da EncEficiente.
     * 
     * @return número de encomendas da EncEficiente.
     */
	public String getNrEncomenda(){
		return this.nrEncomenda;
	}

    /**
     * Devolve a data da EncEficiente.
     * 
     * @return LocalDate data da EncEficiente.
     */
	public LocalDate getData(){
		return this.data;
	}
    
    /**
     * Actualiza o arraylist.
     * 
     * @param linha nova array list da EncEficiente
     */
	public void setLinhaEncomenda(ArrayList<LinhaEncomenda> linha){
		this.linhaEncomenda = new ArrayList<>();
		for(LinhaEncomenda l : linha)
			this.linhaEncomenda.add(l.clone());
	}

    /**
     * Actualiza o nome.
     * 
     * @param nome novo nome da EncEficiente
     */
	public void setNome(String nome){
		this.nome = nome;
	}

    /**
     * Actualiza o NIFt.
     * 
     * @param nif novo NIF da EncEficiente
     */
	public void setNif(String nif){
		this.nif = nif;
	}

    /**
     * Actualiza a morada.
     * 
     * @param morada nova morada da EncEficiente
     */
	public void setMorada(String morada){
		this.morada = morada;
	}

    /**
     * Actualiza o número de encomendas.
     * 
     * @param nr nova número de encomendas da EncEficiente
     */
	public void setNrEncomenda(String nr){
		this.nrEncomenda = nr;
	}

    /**
     * Actualiza a data.
     * 
     * @param data nova data da EncEficiente
     */
	public void setData(LocalDate data){
		this.data = data;
	}

    /**
     * Método que compara duas EncEficiente.
     * @return booleano que é verdadeiro quando as duas EncEficiente forem iguais.
     */
	public boolean equals(Object obj){
		if(obj==this) return true;
		if(obj==null || obj.getClass() != this.getClass()) return false;
		EncEficiente e = (EncEficiente) obj;
		if(this.linhaEncomenda.size() != e.getLinhaEncomenda().size()) return false;
		return e.getLinhaEncomenda().stream().allMatch(a -> this.linhaEncomenda.contains(a)) &&
			this.nome.equals(e.getNome()) &&
			this.nif.equals(e.getNif()) &&
			this.morada.equals(e.getMorada()) &&
			this.nrEncomenda == e.getNrEncomenda() &&
			this.data.equals(e.getData());
	}

    /**
     * Método que devolve a representação em String da EncEficiente.
     * @return String com as informações da EncEficiente
     */
	public String toString(){
		Iterator<LinhaEncomenda> it = this.linhaEncomenda.iterator();
		LinhaEncomenda elem;
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + this.nome + "\nNIF:" + this.nif + "\nMorada: " + this.morada + "\nNr de encomenda: " + this.nrEncomenda + "\nData: " + this.data + "\nLinhas de encomenda: ");

		while(it.hasNext()){
			elem = it.next();
			sb.append(elem.toString()).append("\n");
		}

		return sb.append("\n").toString();
	}

    /**
     * Método que faz uma cópia do objecto receptor da mensagem.
     * Para tal invoca o construtor de cópia.
     * 
     * @return objecto clone do objecto que recebe a mensagem.
     */
	public EncEficiente clone(){
		return new EncEficiente(this);
	}

    /**
     * Método que calcula o valor total da encomenda
     * 
     * @return valor total da encomenda.
     */
	public double calculaValorTotal(EncEficiente encomenda){
		Iterator<LinhaEncomenda> it = this.linhaEncomenda.iterator();
		LinhaEncomenda elem;
		double total = 0.0;

		while(it.hasNext()){
			elem = it.next();
			total = total + elem.calculaValorLinhaEnc();
		}

		return total;
	}

    /**
     * Método que calcula o valor do desconto
     * 
     * @return valor de desconto da encomenda.
     */
	public double calculaValorDesconto(){
		Iterator<LinhaEncomenda> it = this.linhaEncomenda.iterator();
		LinhaEncomenda elem;
		double total = 0.0;

		while(it.hasNext()){
			elem = it.next();
			total = total + elem.calculaValorDesconto();
		}

		return total;
	}

    /**
     * Método que calcula o numero de produtos da encomenda
     * 
     * @return número de produtos.
     */
	public int numeroTotalProdutos(){
		Iterator<LinhaEncomenda> it = this.linhaEncomenda.iterator();
		LinhaEncomenda elem;
		int total = 0;

		while(it.hasNext()){
			elem = it.next();
			total = total + elem.getQuantidade();
		}

		return total;
	}

    /**
     * Método que verifica se um dado produto existe na encomenda, usando a referencia.
     * 
     * @return boleano que é verdadeiro quando o produto existe na encomenda.
     */
	public boolean existeProdutoEncomenda(String refProduto){
		Iterator<LinhaEncomenda> it = this.linhaEncomenda.iterator();
		LinhaEncomenda elem;
		boolean res = false;

		while(it.hasNext() && res == false){
			elem = it.next();
			if(refProduto.equals(elem.getReferencia())) res = true;
		}

		return res;
	}

    /**
     * Método que adiciona uma linha de encomenda à EncEficiente
     */
	public void adicionaLinha(LinhaEncomenda linha){
		this.linhaEncomenda.add(linha);
	}

    /**
     * Método que remove um produto da encomenda.
     */
	public void removeProduto(String codProduto){
		Iterator<LinhaEncomenda> it = this.linhaEncomenda.iterator();
		LinhaEncomenda elem;

		while(it.hasNext()){
			elem = it.next();
			if(codProduto.equals(elem.getReferencia())) this.linhaEncomenda.remove(elem);
		}
	}
}