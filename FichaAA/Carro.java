public class Carro{
	private String marca;
	private String modelo;
	private int ano;
	private double consumo;
	private double kms;
	private double mediaConsumo;
	private double uConsumo;
	private double uMediaConsumo;
	private double regeneracao;
	private boolean ligado;

	public Carro(){
		this.marca = "";
		this.modelo = "";
		this.ano = 2000;
		this.consumo = 0.0;
		this.kms = 0.0;
		this.mediaConsumo = 0.0;
		this.uConsumo = 0.0;
		this.regeneracao = 0.0;
		this.uMediaConsumo = 0.0;
		this.ligado = false;
	}

	public Carro(String marca, String modelo, int ano, double consumo, double kms, double mediaConsumo, double uConsumo, double uMediaConsumo, double regeneracao, boolean ligado){
		this.marca = new String(marca);
		this.modelo = new String(modelo);
		this.ano = ano;
		this.consumo = consumo;
		this.kms = kms;
		this.mediaConsumo = mediaConsumo;
		this.uConsumo = uConsumo;
		this.uMediaConsumo = uMediaConsumo;
		this.regeneracao = regeneracao;
		this.ligado = ligado;
	}
	
	public Carro(Carro object){	
		this.marca = new String(object.getMarca());
		this.modelo = new String(object.getModelo());
		this.ano = object.getAno();
		this.consumo = object.getConsumo();
		this.kms = object.getKms();
		this.mediaConsumo = object.getMediaConsumo();
		this.uConsumo = object.getUConsumo();
		this.uMediaConsumo = object.getUMediaConsumo();
		this.regeneracao = object.getRegeneracao();
		this.ligado = object.getLigado();	
	}
	
	public String getMarca(){	
		return new String(this.marca);
	}

	public String getModelo(){
		return new String(this.modelo);
	}

	public int getAno(){
		return this.ano;
	}

	public double getConsumo(){
		return this.consumo;
	}

	public double getKms(){
		return this.kms;
	}

	public double getMediaConsumo(){
		return this.mediaConsumo;
	}

	public double getUConsumo(){
		return this.uConsumo;
	}

	public double getUMediaConsumo(){
		return this.uMediaConsumo;
	}

	public double getRegeneracao(){
		return this.regeneracao;
	}

	public boolean getLigado(){
		return this.ligado;
	}

	public void ligaCarro(){
		this.ligado = true;
	}
	
	public void desligaCarro(){
		this.ligado = false;
	}

	public void resetUltimaViagem(){
		this.uConsumo = 0.0;
		this.uMediaConsumo = 0.0;
	}

	public void avancaCarro(double metros, double velocidade){
		this.kms = this.kms + metros * velocidade;
	}

	public void travaCarro(double metros){
		this.kms = this.kms + metros / 1000;
	}
}
