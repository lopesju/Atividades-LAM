import java.util.Scanner;

public class Exercicio1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String nome = "";
        System.out.printf("Digite o nome:");
        nome = input.next();
        System.out.printf("Digite o número de horas:");
        float horas = Float.parseFloat(input.next());
        System.out.printf("Digite o valor pago por hora:");
        float valorH = Float.parseFloat(input.next());
        float valorR = horas * valorH;
        System.out.printf("O valor a ser recebido é: %f \n", valorR);
    }
}
