import java.util.Scanner;

public class main
{
    public static void ex1(String args[])
    {
        Ficha1 f1 = new Ficha1();
        Scanner s = new Scanner(System.in);
        
        System.out.println("Graus: ");
        double temp = s.nextDouble();
        temp = f1.celsiusParaFaranheit(temp);
        System.out.println("Faranheits: " + temp);
    }   
    public static void ex2(String args[]){
        Ficha1 f1 = new Ficha1();
        Scanner s = new Scanner(System.in);
        
        int a,b;
        
        System.out.print("1º numero: ");
        a = s.nextInt();
        System.out.print("2º numero: ");
        b = s.nextInt();
        a = f1.maximoNumeros(a,b);
        System.out.println("Maior numero: " + a);
    }
    public static void ex3(String args[]){
        Ficha1 f1 = new Ficha1();
        Scanner s = new Scanner(System.in);
        
        int saldo;
        String nome;
        
        System.out.print("Nome da conta: ");
        nome = s. nextLine(); 
        System.out.print("Saldo da conta:");
        saldo = s.nextInt();
        
        System.out.println(f1.criaDescricaoConta(nome, saldo));
    }
    public static void ex4(String args[]){
        Ficha1 f1 = new Ficha1();
        Scanner s = new Scanner(System.in);
        
        System.out.print("Valor: ");
        int valor = s.nextInt();
        System.out.print("Taxa: ");
        double taxa = s.nextDouble();
        
        System.out.println(valor + " euros correspondem a " + f1.eurosParaLibras(valor, taxa) + " libras");
    }
    public static void ex5(String args[]){
        Ficha1 f1 = new Ficha1();
        Scanner s = new Scanner(System.in);
        
        System.out.print("1º valor: ");
        int n1 = s.nextInt();
        System.out.print("2º valor: ");
        int n2 = s.nextInt();
        
        //Definir a media
        System.out.println("O maior valor e: " + Math.max(n1,n2) + " e a media e: " + (n1+n2)/2);
    }
}
