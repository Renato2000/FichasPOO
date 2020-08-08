public class LinhaDeEncomenda{
	public String codigo;
	public String descricao;
	public int precoAntesImposto;
	public int quantidade;
	public int percentagemImposto;
	public int percentagemDesconto;

	public LinhaDeEncomenda(){
		this.codigo = "";
		this.descricao = "";
		this.precoAntesImposto = 0;
		this.quantidade = 0;
		this.percentagemImposto = 0;
		this.percentagemDesconto = 0;
	}

	public LinhaDeEncomenda(String codigo, String descricao, int precoAntesImposto, int quantidade, int percentagemImposto, int percentagemDesconto){
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoAntesImposto = precoAntesImposto;
		this.quantidade = quantidade;
		this.percentagemImposto = percentagemImposto;
		this.percentagemDesconto = percentagemDesconto;
	}

	public LinhaDeEncomenda(LinhaDeEncomenda l){
		this.codigo = l.getCodigo();
		this.descricao = l.getDescricao();
		this.precoAntesImposto = l.getPrecoAntesImposto();
		this.quantidade = l.getQuantidade();
		this.percentagemImposto = l.getPercentagemImposto();
		this.percentagemDesconto = l.getPercentagemDesconto();
	}

	public String getCodigo(){
		return new String (this.codigo);
	}

	public String getDescricao(){
		return new String (this.descricao);
	}

	public int getPrecoAntesImposto(){
		return this.precoAntesImposto;
	}

	public int getQuantidade(){
		return this.quantidade;
	}

	public int getPercentagemImposto(){
		return this.percentagemImposto;
	}

	public int getPercentagemDesconto(){
		return this.percentagemDesconto;
	}

	public void setCodigo(String codigo){
		this.codigo = new String (codigo);
	}

	public void setDescricao(String descricao){
		this.descricao = new String (descricao);
	}

	public void setPrecoAntesImposto(int preco){
		this.precoAntesImposto = preco;
	}

	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}

	public void setPercentagemImposto(int imposto){
		this.percentagemImposto = imposto;
	}

	public void setPercentagemDesconto(int desconto){
		this.percentagemDesconto = desconto;
	}

	public LinhaDeEncomenda clone(){
		return new LinhaDeEncomenda(this);
	}

	public double calculaValorLinhaEnc(){
		return (this.precoAntesImposto + this.valorImposto()) - this.calculaValorDesconto();
	}

	private double valorImposto(){
		return this.precoAntesImposto * this.percentagemImposto / 100;
	}

	public double calculaValorDesconto(){
		return this.precoAntesImposto * this.percentagemDesconto / 100;
	}
}