public class Ficha1
{
    public double celsiusParaFaranheit(double graus){
        return(graus*1.8+32);
    }
    public int maximoNumeros (int a, int b){
        if(a>b) return a;
        return b;
    }
    public String criaDescricaoConta (String nome ,double saldo){
        String descricao = ("A conta " + nome + " tem um saldo de " + saldo);
        return descricao;
    }
    public double eurosParaLibras (double valor, double taxaConversao){
        return (valor * taxaConversao);
    }
}
