
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brunamedeiros
 */
public class doWhile {
    public static void main(String[] args) {
        double input = 0, sum = 0;
        Scanner scanf = new Scanner(System.in);
            
        do{
            System.out.println("Digite um numero positivo para ser somado ou negativo para sair: ");
            input = scanf.nextDouble();
            if(input > 0){
                sum += input;
            }
        }while(input >= 0);
        System.out.println("A soma é: " + sum);
    }
    
}
