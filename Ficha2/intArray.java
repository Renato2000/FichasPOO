import java.util.Arrays;

public class intArray{

	public static int menor(int[] array){
		int m;
		m = array[0];
		for(int i = 0; i<array.length; i++) 
			if(array[i]<m) m = array[i];
		return (m);
	}
	public static int[] intervalo(int[] array, int s, int i){
		int[] res = new int[s-i+1];
		for(int j=0; j<s-i+1; j++)
			res[j] = array[j+i];
		return (res);
	}
	public static int[] comuns(int[] a1, int[] a2){
		int tam;
		for(int i=0; i<a1.length; i++)
			for(int j=0; j<a2.length; j++)

		int[] novo = new int[tam]; 
		
	}
}
