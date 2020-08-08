//import static java.lang.System;
import java.util.Scanner;
import java.time.LocalDate;

public class Master{
	public static void main(String[] args){
		/*
		Scanner s = new Scanner(System.in);
		intArray a = new intArray();
		System.out.print("Tamanho do array: ");
		int tam = s.nextInt();		
		int[] array = new int[tam];
		
		System.out.print("Insira o array: ");
		for(int i=0; i<tam; i++)
			array[i] = s.nextInt();

		System.out.print("Primeiro indice: ");
		int n1 = s.nextInt();
		System.out.print("Segundo indice: ");
		int n2 = s.nextInt();


		//System.out.print("Menor elemento do array: " + a.menor(array) + "\n");
		System.out.print("Array entre os dois indices: ");
		int[] res = a.intervalo(array, n2, n1);
		printArray(array,n2-n1+1);
		*/

		/*
		Scanner s = new Scanner(System.in);
		arrayLocalDate p = new arrayLocalDate(LocalDate.parse("2010-10-10"), 10);
		p.insereData(LocalDate.now());
		System.out.println(p.);
		*/

		Scanner s = new Scanner(System.in);
		int[] aposta = new int[7];
		System.out.println("Insira a sua aposta: ");
		for(int i=0; i<7; i++)
			aposta[i] = s.nextInt();

		euromilhoes jogo = new euromilhoes(aposta);

		if(jogo.compara() != true){
			for(int i=0; i<50; i++){
				for(int j=0; j<i; j++)
					System.out.print("  ");
				printArray(jogo.getChave(),7);
			}
		}
		else{
			System.out.print("Você perdeu.\nA chave era: ");
			printArray(jogo.getChave(),7);
		}
	}
	public static void printArray(int[] array, int tam){
		for(int i=0; i<tam; i++) 
			System.out.print(array[i] + " ");
		System.out.println("\n");
	}
}
