import java.util.Scanner; //leitura de dados

public class ValidData {
    public static void main(String[] args) {
        int dia;
        int mes;
        int ano;
        boolean bissexto = false;
        
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o dia:\n");    
        dia = ler.nextInt();
        System.out.print("Digite o mes:\n");
        mes = ler.nextInt();
        System.out.print("Digite o ano:\n");
        ano = ler.nextInt();
        
        if(ano > 0){
            if(mes >= 1 && mes <= 12) {
                // Data Válida
                if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) {
                    if(dia >= 1 && dia <= 31) {
                        System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
                    } else {
                        // Dia inválido
                        System.out.println("Data Inválida");
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if(dia >= 1 && dia <= 30) {
                        System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
                    } else {
                        // Dia inválido
                        System.out.println("Data Inválida");
                    }
                } else if (mes == 2) {
                    // Se o mês é fevereiro, é necessário saber se o ano é bissexto ou não, ou seja, se fevereiro tem 28 ou 29 dias.
                    if((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)){
                        if(dia > 29 || dia <= 0){
                            // Dia inválido
                            System.out.println("Data Inválida");
                        }else{
                            System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
                        }
                    }
                    else if(dia > 28){
                        System.out.println("Data Inválida");
                    }
                    else{
                        System.out.println("Data Válida. A data digitada foi: " + dia + "/" + mes + "/" + ano);
                    }
                }
            } else {
                // Mes invalido
                System.out.println("Data Inválida");
            }
        } else {
            // Amo invalido
            System.out.println("Data Inválida");
        }
    }
}