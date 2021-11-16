import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Questao3 {

  public static void main(String args[]) throws IOException {
    System.out.println("Informe o arquivo com os dados: ");
    Scanner input = new Scanner(System.in);
    String value = input.nextLine();

    FileInputStream stream = new FileInputStream(value);
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(new FileReader(value));

    //in progress...

  } 




}