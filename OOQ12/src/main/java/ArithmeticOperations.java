
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
public class ArithmeticOperations {
    public static void main(String[] args) {
        char operator;
        int firstNumber = 0, secondNumber = 0, result;
        
        Scanner scanf = new Scanner(System.in);
        
        System.out.println("Entre com a operação a ser realizada (+, - ou *): ");
        operator = scanf.next().charAt(0);
        
        System.out.println("Entre com o primeiro número: ");
        firstNumber = scanf.nextInt();
        
        System.out.println("Entre com o segundo número: ");
        secondNumber = scanf.nextInt();
        
        switch(operator){
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            default:
                System.out.println("Operação inválida");
                return;
        }
        
        System.out.println("O resultado da operação é: " + result);
    }
    
}
