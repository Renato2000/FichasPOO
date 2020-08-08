import java.time.LocalDate;


public class arrayLocalDate{
	private LocalDate[] datas;
	private int numElems;

	public arrayLocalDate (LocalDate data, int n){
		this.datas = new LocalDate[n];
		this.datas[0] = data;
		this.numElems = 1;
	}

	public void insereData(LocalDate data){
		if(this.numElems < this.datas.length)
			this.datas[this.numElems++] = data;
	}

	public LocalDate dataMaisProxima(LocalDate data){
		int m=0;
		for(int i=1; i<this.numElems; i++)
			if(Math.abs(this.datas[i].getYear()-data.getYear()) < Math.abs(this.datas[m].getYear()-data.getYear()))
				m = i;
			else if(Math.abs(this.datas[i].getYear()-data.getYear()) == Math.abs(this.datas[m].getYear()-data.getYear()))
					if(Math.abs(this.datas[i].getDayOfYear()-data.getDayOfYear()) < Math.abs(this.datas[m].getDayOfYear()-data.getDayOfYear()))
						m = i;

		return this.datas[m];
	}

	//public String StringToString(){	}

	public LocalDate lastData(){
		return this.datas[numElems-1];
	}
}