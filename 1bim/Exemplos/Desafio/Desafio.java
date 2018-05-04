import java.util.Scanner;

public class Desafio{
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       System.out.printf("Digite um número inteiro:");
       int n = Integer.parseInt(input.next());
       int i = n;
       String bin = "";
       while(n!= 0){
           bin = bin + n % 2;
           n = n/2;
       }
       StringBuffer sb = new StringBuffer(bin);
       sb.reverse();
       System.out.printf("O número %d convertido é: %s \n",i, sb);
    }
}


