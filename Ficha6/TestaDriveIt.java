import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestaDriveIt{
	public static void main(String []args){
		DriveIt d = new DriveIt();

		List<Integer> classif = new ArrayList<Integer>();

		Veiculo v1 = new VeiculoNormal("AA-11-AA", "BMW", "vroom vroom fast", 2015, 90, 20, classif, 0);
		Veiculo v2 = new VeiculoNormal("AA-12-AA", "Mercedes-Benz", "vroom vroom medium-fast", 2012, 75, 15, classif, 50000);
		VeiculoOcasiao v3 = new VeiculoOcasiao("AA-13-AA", "Audi", "vroom vroom", 1998, 50, 20, classif, 100000, false);
		Veiculo v4 = new VeiculoPremium("BB-11-BB", "Smart", "veiculo premium", 2020, 120, 30, classif, 12, 100, 1);
		AutocarroInteligente v5 = new AutocarroInteligente("ZZ-22-ZZ", "Renault", "autocarro", 2012, 80, 10, classif, 30, 90, 35);

		try{
			d.adiciona(v1);
		}
		catch(VeiculoRepetidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(ValorInvalidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		try{
			d.adiciona(v2);
		}
		catch(VeiculoRepetidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(ValorInvalidoException e){
			System.out.println("Erro: " + e.getMessage());
		}		
		v3.ativarPromocao();
		try{
			d.adiciona(v3);
		}
		catch(VeiculoRepetidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(ValorInvalidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		v3.desativarPromocao();
		try{
			d.adiciona(v4);
		}
		catch(VeiculoRepetidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(ValorInvalidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		try{
			d.adiciona(v5);
		}
		catch(VeiculoRepetidoException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(ValorInvalidoException e){
			System.out.println("Erro: " + e.getMessage());
		}	

		int custo;
		try{
			custo = d.custoRealKm("AA-11-AA");
			System.out.println("Custo real v: " + custo + "\n"); //22
		}
		catch(VeiculoInexistenteException e){
			System.out.println(e);
		}
		try{
			custo = d.custoRealKm("AA-13-AA");
			System.out.println("Custo real vOcasiao: " + custo + "\n"); //33
		}
		catch(VeiculoInexistenteException e){
			System.out.println(e);
		}
		System.out.println("Custo real vOcasiao sem promocao: " + (int) v3.custoRealKm() + "\n"); //44

		System.out.println("Veiculos ordenados: " + d.ordenarVeiculosList() + "\n");

		d.adicionaComparator("Natural", new ComparatorVeiculosNat());
		try{
			Iterator<Veiculo> it = d.ordenarVeiculo("Natural");
			while(it.hasNext()){
				Veiculo v = it.next();
				System.out.println(v.toString());
			}
		}
		catch(ValorInvalidoException e){
			System.out.println(e);
		}

		System.out.println("\n========================\nVeiculos que dão pontos:\n========================\n");
		List<BonificaKms> daoPontos = d.daoPontos();
		for(BonificaKms v : daoPontos){
			System.out.println(v);
		}

		DriveIt di2 = new DriveIt();;

		try{
			d.gravaEstado("TestFile");
		}
		catch(FileNotFoundException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
		}
		try{
			 di2 = d.leEstado("TestFile");
		}
		catch(FileNotFoundException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
		}
		catch(ClassNotFoundException e){
			System.out.println("Erro: " + e.getMessage());
		}
		try{
			di2.gravaVeiculosCSV("Veiculos");
		}
		catch(FileNotFoundException e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
}