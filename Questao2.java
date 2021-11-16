import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao2 {

  public static void main(String args[]) throws IOException, OutOfRangeException {
    
    System.out.println("Informe o arquivo com os dados: ");
    Scanner input = new Scanner(System.in);
    String value = input.next();
    //FileInputStream stream = new FileInputStream(value);
    //InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(new FileReader(value));

    String br1;
    String firstLine[] = new String[2];
    br1 = br.readLine();
    firstLine = br1.split(" ");


    int i, countEnd = 0, nVendedores, lLigacoes, parseArr;
    boolean loop = true;
    String j;

    ArrayList<Integer> ligacoesList = new ArrayList<Integer>();
    nVendedores = Integer.parseInt(firstLine[0]);
    lLigacoes = Integer.parseInt(firstLine[1]);
    int intermed[] = new int[lLigacoes];

    while ((j = br.readLine()) != null){
      parseArr = Integer.parseInt(j);
      ligacoesList.add(parseArr);
    }

    if(nVendedores < 1 || nVendedores > 1000) {
      throw new OutOfRangeException();
    }
    if(lLigacoes < 1 || lLigacoes > 1000000) {
      throw new OutOfRangeException();
    }

    //GAMBIARRA, ESSA PARTE PODE SER MELHORADA (inverter a lista de tempos de ligacao)
    for(i=0; i<lLigacoes; i++){
      intermed[i] = ligacoesList.remove( ligacoesList.size()-1 );
      if(intermed[i] < 1 || intermed[i] > 30) {
        throw new OutOfRangeException();
      }
    }
    for(i=0; i<lLigacoes; i++){
      ligacoesList.add(intermed[i]);
    }
    //========================================
    
    ArrayList<Vendedores> vendedoresList = new ArrayList<Vendedores>();

    for(i=1; i<=nVendedores; i++){
      vendedoresList.add(new Vendedores(i));
    }

    while(loop == true) {

      countEnd = 0;

      for(i=0; i<nVendedores; i++){

        if( vendedoresList.get(i).getInCall() ){
          vendedoresList.get(i).runningCall();
        }

        if( (!vendedoresList.get(i).getInCall()) && (!ligacoesList.isEmpty()) ){
          vendedoresList.get(i).addCall(ligacoesList.remove( ligacoesList.size()-1 ));
          
        } else if ((!vendedoresList.get(i).getInCall()) && (ligacoesList.isEmpty())){
          countEnd++;

        }

      }

      if(countEnd == nVendedores) {
        loop = false;
      }

    }

    for(i=0; i<nVendedores; i++){
    System.out.printf("Vendedor: %d / N de ligacoes: %d", vendedoresList.get(i).getId(), vendedoresList.get(i).getCalls());
    System.out.println("");

    }

  }
}

class Vendedores{

  private int id;
  private boolean inCall = false;
  private int minCall;
  private int calls = 0;

  public Vendedores(int id){
    this.id = id;
  }

  public int getId() {
    return id;
  };

  public boolean getInCall() {
    return inCall;
  }

  public int getMinCall() {
    return minCall;
  }

  public int getCalls() {
    return calls;
  }

  public boolean addCall(int min) {
    if(inCall == false && minCall == 0) {
      minCall = min;
      calls++;
      inCall = true;
      return true;
    } else {
      return false;
    }
  }

  public void runningCall() {
    minCall--;
    if(minCall == 0) {
      inCall = false;
    }
  }

}