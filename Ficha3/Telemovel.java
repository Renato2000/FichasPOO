public class Telemovel{
	private String marca; //Marca do telemovel
	private String modelo; //Modelo do telemovel
	private int displayX; //Dimensoes do display em X x Y
	private int displayY; 
	private int totalMensagens; //Espaço para mensagens
	private int totalFotosApps; //Espaço para fotos e apps
	private int totalFotos; //Espaço para fotos
	private int totalApps; //Espaço para apps
	private int totalOcup; //Espaço ocupado
	private int nrFotos; //Nr de fotos
	private int nrApps; //Nr de apps
	private String[] nomesApps;

	//Criar os metodos usuais

	public Telemovel(){
		this.marca = "";
		this.modelo = "";
		this.displayX = 0;
		this.displayY = 0;
		this.totalFotosApps = 0;
		this.totalFotos = 0;
		this.totalApps = 0;
		this.totalOcup = 0;
		this.nrFotos = 0;
		this.nrApps = 0;
		this.nomesApps = "";
	}

	public Telemovel(String cmarca, String cmodelo, int cdisplayX, int cdisplayY,int ctotalMensagens, int ctotalFotosApps, int ctotalFotos, int ctotalApps, int ctotalOcup, int cnrFotos, int cnrApps, String[] cnomesApps){
		this.marca = cmarca;
		this.modelo = cmodelo;
		this.displayX = cdisplayX;
		this.displayY = cdisplayY;
		this.totalFotosApps = ctotalFotosApps;
		this.totalFotos = ctotalFotos;
		this.totalApps = ctotalApps;
		this.totalOcup = ctotalOcup;
		this.nrFotos = cnrFotos;
		this.nrApps = cnrApps;
		this.nomesApps = cnomesApps;
	}

	public Telemovel(Telemovel tel){
		this.marca = tel.getMarca();
		this.modelo = tel.getModelo();
		this.displayX = tel.getDisplayX();
		this.displayY = tel.getDisplayY();
		this.totalFotosApps = tel.getTotalFotosApps();
		this.totalFotos = tel.getTotalFotos();
		this.totalApps = tel.getTotalApps();
		this.totalOcup = tel.getTotalOcup();
		this.nrFotos = tel.getNrFotos();
		this.nrApps = tel.getNrApps();
		this.nomesApps = tel.getNomesApps();
	}

	public boolean existeEspaco(int numeroBytes){
		return (numeroBytes < (this.totalFotosApps - this.totalOcup));
	}

	//Guardar o apontador ou criar um novo array?
	//Onde guardar a app?
	public void instalaApp(String nome, int tamanho){
		if(tamanho < this.totalApps){
			this.totalApps = this.totalApps + tamanho;
		}
		//String[this.nrApps] = nome;
	}

	public void recebeMeg(String meg){
		this.totalMensagens = this.totalMensagens + meg.length();
	}

	public double tamMedioApps(){
		double res;
		res = this.totalApps / this.nrApps;
		return res;
	}

	//public String maiorMeg(){}

	public void removeApp(String nome, int tamanho){

	}
}