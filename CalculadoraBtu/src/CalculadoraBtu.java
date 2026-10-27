import java.util.Scanner;
import java.util.Locale;
public class CalculadoraBtu {
    //método com as recomendações
    static void recomendar(double btu) {
        if (btu <= 10000) {
            System.out.println("Aparelho recomendado: 9.000 BTUs!");
        } else if (btu <= 14500) {
            System.out.println("Aparelho recomendado: 12.000 BTUs!");
        } else if (btu <= 19000) {
            System.out.println("Aparelho recomendado: 18.000 BTUs!");
        } else if (btu <= 25000) {
            System.out.println("Aparelho recomendado: 24.000 BTUs!");
        } else if (btu <= 37000) {
            System.out.println("Aparelho recomendado: de 30.000 a 36.000 BTUs!");
        } else {
            System.out.println("Aparelho recomendado: acima de 36.000 BTUs!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CALCULADORA DE BTU");
        //informações sobre o ambiente
        System.out.print("Altura: ");
        double altura = sc.nextDouble();

        System.out.print("Largura: ");
        double largura = sc.nextDouble();

        System.out.print("Comprimento: ");
        double comprimento = sc.nextDouble();

        System.out.print("Qntd Eletrodomésticos: ");
        int eletro = sc.nextInt();

        System.out.print("Qntd Pessoas: ");
        int pessoas = sc.nextInt();
        sc.nextLine();

        System.out.print("Há incidência do sol? ");
        String sol = sc.nextLine();
        //fim das informações
        sc.close();

        //Variaveis das equações
        double btuUm = altura * largura * comprimento * 600 + (pessoas * 600 - 600) + (eletro * 600);
        double btuDois = altura * largura * comprimento * 800 + (pessoas * 800 - 800) + (eletro * 800);
        double btuTres = largura * comprimento * 600 + (pessoas * 600 - 600) + (eletro * 600);
        double btuQuatro = largura * comprimento * 800 + (pessoas * 800 - 800) + (eletro * 800);
        //variavel que guarda o resultado escolhido
        double btuFinal;

        //condicionais
        if (altura >= 3 && sol.toLowerCase().equals("sim")) {
            if (pessoas > 1) {
                btuFinal = btuDois + 800.00;
            } else {
                btuFinal = btuDois;
            }
        } else if (altura >= 3 && !sol.toLowerCase().equals("sim")) {
            if (pessoas > 1) {
                btuFinal = btuUm + 600.00;
            } else {
                btuFinal = btuUm;
            }
        } else if (altura < 3 && sol.toLowerCase().equals("sim")) {
            if (pessoas > 1) {
                btuFinal = btuQuatro + 800.00;
            } else {
                btuFinal = btuQuatro;
            }
        } else {
            if (pessoas > 1) {
                btuFinal = btuTres + 600;
            } else {
                btuFinal = btuTres;
            }
        }

        //mostra o calculo e a recomendação
        System.out.println(btuFinal + " BTUs!");
        recomendar(btuFinal);

    }
}
