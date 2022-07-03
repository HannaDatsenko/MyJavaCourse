package ua.levelup;


import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        System.out.println("First table");
        for(int a = 1; a <= 9; a++){
            for(int b = 1; b <= 9; b++){
                System.out.print("" + b + "*" +  a + "=" + b * a + " ");
            }
            System.out.println("");
        }
        System.out.println("Second table");
        for(int i = 1; i <= 9; i++){
            for(int l = 1; l <= 9; l++){
                System.out.print("" + i + "*" +  l + "=" + i * l + " ");
            }
            System.out.println("");
        }

        System.out.println("Exc 3");

        System.out.println("Type the word");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println("Type the position of the letter");
        int position = scanner.nextInt();
        System.out.println(word.charAt(position-1));

        System.out.println("Exc 4");
        System.out.println("Type the word");
        Scanner exc4scanner = new Scanner(System.in);
        String exc4word = exc4scanner.nextLine();
        String result = "";
        for(int i=exc4word.length(); i>0; i--) {
            result = result + exc4word.charAt(i-1);
        }
        System.out.println(result);

        System.out.println("Exc 5");
        System.out.println("Type the sentense");
        Scanner exc5scanner = new Scanner(System.in);
        String exc5word = exc5scanner.nextLine();
        System.out.println(exc5word.replace('е', 'и'));

        System.out.println("Exc 6");
        System.out.println("Type the word");
        Scanner exc6scanner = new Scanner(System.in);
        String exc6word = exc6scanner.nextLine();
        System.out.println("Type the position of the letter k");
        int positionk = exc6scanner.nextInt();
        System.out.println("Type the position of the letter s");
        int positions = exc6scanner.nextInt();
        String firststring = exc6word.substring(0, positionk);
        String secondstring = exc6word.substring(positionk, positions-1);
        String thirdstring = exc6word.substring(positions, exc6word.length());
        String resultsecondstring= "";
        for(int i=secondstring.length(); i>0; i--) {
            resultsecondstring = resultsecondstring + secondstring.charAt(i-1);
        }
        System.out.println(firststring + resultsecondstring + thirdstring);
    }
}
