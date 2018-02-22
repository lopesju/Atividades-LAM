import java.util.Scanner;
import java.util.Random;

public class Exercicio3{
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       Random r = new Random();
       int num = r.nextInt(10) + 1;
       int t = 3;
       do{
           System.out.printf("Digite um número inteiro:");
           int n = Integer.parseInt(input.next());
           if(n==num){
               System.out.printf("Você acertou!!");
               }else{
                   System.out.println("Você errou");
                   t--;
              }
           }while(t!=0);
        System.out.printf("O número era: %d \n", num);
    }
}

