public class Lampada{
	private char modo;
	private double consumo;
	private double tempo;
	private double tempoTotal;

	public Lampada(){
		this.modo = 'D';
		this.consumo = 0.0;
		this.tempo = 0;
		this.tempoTotal = 0;
	}

	public Lampada(char modo, double consumo, double tempo, double tempoTotal){
		this.modo = modo;
		this.consumo = consumo;
		this.tempo = tempo;
		this.tempoTotal = tempoTotal;
	}

	public Lampada(Lampada l){
		this.modo = l.getModo();
		this.consumo = l.getConsumo();
		this.tempo = l.getTempo();
		this.tempoTotal = l.getTempoTotal();
	}

	public char getModo(){
		return this.modo;
	} 

	public double getConsumo(){
		return this.consumo;
	}

	public double getTempo(){
		return this.tempo;
	}

	public double getTempoTotal(){
		return this.tempoTotal;
	}

	public void setModo(char modo){
		this.modo = modo;
	}

	public void setConsumo(double consumo){
		this.consumo = consumo;
	}

	public void setTempo(double tempo){
		this.tempo = tempo;
	}

	public void setTempoTotal(double tempoTotal){
		this.tempoTotal = tempoTotal;
	}

	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		Lampada l = (Lampada) o;
		return(this.modo == l.getModo() &&
		 	this.consumo == l.getConsumo() &&
		 	this.tempo == l.getTempo() &&
		 	this.tempoTotal == l.getTempoTotal());
	}

	public Lampada clone(){
		return new Lampada(this);
	}

	public void lampON(){
		this.modo = 'L';
	}

	public void lampOFF(){
		this.modo = 'D';
	}

	public void lampECO(){
		this.modo = 'E';
	}

	public double totalConsumo(){
		return this.tempoTotal * this.consumo;
	}

	public double periodoConsumo(){
		return this.tempo * this.consumo;
	}

	public void resetPeriodo(){
		setTempo(0);
	}
}