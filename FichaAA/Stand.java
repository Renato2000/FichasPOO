public class Stand{
	public Carro[] carros;
	public int  tam;

	public Stand(){
		this.carros = new Carro[1];
		this.carros[0] = new Carro();
		this.tam = 1;
	}



	public Stand(Stand object){
		this.carros = object.getCarros();
		this.tam = object.getTam();
	}

	public int getTam(){
		return this.tam;
	}

	public Carro[] getCarros(){
		Carro[] novo = new Carro[this.tam];
		for(int i=0; i<tam; i++)
			novo[i] = new Carro(this.carros[i]);
		return novo;
	}

	public Stand clone(Stand object){
		return new Stand(object);
	}
}