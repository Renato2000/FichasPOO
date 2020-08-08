import java.lang.Math;

public class euromilhoes{
	private int[] chave;
	private int[] aposta;

	public euromilhoes (int[] input){
		gerachave();
		this.aposta = input;
	}	

	public void gerachave(){//Verificar se não gera nrs iguais
		this.chave = new int[7];
		for(int i=0; i<5; i++){
			this.chave[i] = 1 + (int) (50 * Math.random());
			for(int j=0; j<i; j++)
				while(this.chave[i] == this.chave[j])
					this.chave[i] = 1 + (int) (50 * Math.random());

		}
		for(int i=5; i<7; i++){
			this.chave[i] = 1 + (int) (12 * Math.random());
			for(int j=0; j<i; j++)
				while(this.chave[i] == this.chave[j])
					this.chave[i] = 1 + (int) (12 * Math.random());
		}
	}

	public boolean compara(){
		for(int i=0; i<7; i++)
			if(this.chave[i] != this.aposta[i]) return false;
		return true;
	}

	public int[] getChave(){
		return this.chave;
	}
}