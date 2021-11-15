import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Questao2 {

  public static void main(String args[]) throws IOException {
    
  /*   System.out.println("Informe o arquivo com os dados: ");
    Scanner input = new Scanner(System.in);
    String value = input.next();

    FileInputStream stream = new FileInputStream(value);
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(reader);

    int i;
    String br1;
    br1 = br.readLine();

    System.out.println("Linha: " + br1);

    while ((i = br.read()) != -1){

      if((char)i != ' '){
        parseArr = parseArr + (char)i;
      } else {
        numStr = Integer.parseInt(parseArr);
        tamM.add(numStr);
        parseArr = "";
      }

    } */

    //=======================
    int nVendedores = 4, lLigacoes = 6;
    ArrayList<Integer> timeCall = new ArrayList<Integer>();
    timeCall.add(5);
    timeCall.add(2);
    timeCall.add(3);
    timeCall.add(3);
    timeCall.add(4);
    timeCall.add(9);
    //=======================

    int i, countEnd = 0;
    boolean loop = true;
    ArrayList<Vendedores> vendedoresList = new ArrayList<Vendedores>();

    for(i=1; i<=nVendedores; i++){
      vendedoresList.add(new Vendedores(i));
    }

    while(loop == true) {

      for(i=0; i<nVendedores; i++){

        if( (!vendedoresList.get(i).getInCall()) && (!timeCall.isEmpty()) ){
          vendedoresList.get(i).addCall( timeCall.remove( timeCall.size()-1 ) );
          countEnd++;
        }else if(vendedoresList.get(i).getInCall()){
          vendedoresList.get(i).runningCall();
        }

        /* if(vendedoresList.get(i).getInCall()){
          vendedoresList.get(i).runningCall();
        }else if((!vendedoresList.get(i).getInCall()) && (!timeCall.isEmpty())){
          vendedoresList.get(i).addCall( timeCall.remove( timeCall.size()-1 ) );
          countEnd++;
        } */
      }

      if(countEnd == nVendedores) {
        loop = false;
      }
      countEnd = 0;

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

