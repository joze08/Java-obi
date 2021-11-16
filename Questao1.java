import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao1 {

  public static void main(String args[]) throws IOException, OutOfRangeException {

    System.out.println("Informe o arquivo com os dados: ");
    Scanner input = new Scanner(System.in);
    String value = input.next();

    FileInputStream stream = new FileInputStream(value);
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(reader);

    String n = br.readLine();
    int numPes = Integer.parseInt(n);
    String k = br.readLine();
    int sand = Integer.parseInt(k);

    ArrayList<Integer> tamM = new ArrayList<Integer>();
    int soma = 0, count = 0, middle, i, numStr;
    boolean aux = false;
    String parseArr = "";

    if(numPes < 1 || numPes > 10000){
      throw new OutOfRangeException();
    }
    if(sand < 1 || sand > 10000){
      throw new OutOfRangeException();
    }

    while ((i = br.read()) != -1){

      if((char)i != ' '){
        parseArr = parseArr + (char)i;
      } else {
        numStr = Integer.parseInt(parseArr);
        if(numStr < 1 || numStr > 10000){
          throw new OutOfRangeException();
        }
        tamM.add(numStr);
        parseArr = "";
      }

    }
    numStr = Integer.parseInt(parseArr);
    tamM.add(numStr);
    parseArr = "";

    for (i = 0; i < tamM.size(); i++) {
      soma += tamM.get(i);
    }

    middle = (soma / numPes);

    while (aux == false) {
      count = 0;
    
      for (i = 0; i < tamM.size(); i++) {
        count += (tamM.get(i) / middle);
      }
    
      if (count != numPes) {
        middle--;
      } else {
        aux = true;
      }
    }
    System.out.printf("O tamanho do sanduiche eh de: %d cm", middle);
  }
}


