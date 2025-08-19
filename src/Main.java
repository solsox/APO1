import java.text.Normalizer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa una frase:");
        String frase = sc.nextLine();

        // Normalizar: quitar acentos y convertir a mayúsculas
        frase = Normalizer.normalize(frase, Normalizer.Form.NFD)
                          .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                          .replaceAll("[^A-Za-z]", "") // quitar espacios y signos
                          .toUpperCase();

        boolean esPalindromo = true;
        for (int i = 0; i < frase.length() / 2; i++) {
            if (frase.charAt(i) != frase.charAt(frase.length() - 1 - i)) {
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo) {
            System.out.println("¡Sí es palíndromo!");
        } else {
            System.out.println("No es palíndromo.");
        }

        sc.close();
    }
}