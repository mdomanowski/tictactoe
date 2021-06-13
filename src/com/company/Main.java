package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void wyswietlPlansze(char[][] plansza) {
        System.out.println("---------");
        System.out.println("| " + plansza[0][0] + " " + plansza[0][1] + " " + plansza[0][2] + " |");
        System.out.println("| " + plansza[1][0] + " " + plansza[1][1] + " " + plansza[1][2] + " |");
        System.out.println("| " + plansza[2][0] + " " + plansza[2][1] + " " + plansza[2][2] + " |");
        System.out.println("---------");
    }

    public static boolean stanGry(char[][] plansza, int[] iloscX, int[] iloscO) {
        if (plansza[0][0] == 'X' && plansza[0][1] == 'X' && plansza[0][2] == 'X' ||
                plansza[1][0] == 'X' && plansza[1][1] == 'X' && plansza[1][2] == 'X' ||
                plansza[2][0] == 'X' && plansza[2][1] == 'X' && plansza[2][2] == 'X' ||
                plansza[0][0] == 'X' && plansza[1][0] == 'X' && plansza[2][0] == 'X' ||
                plansza[0][1] == 'X' && plansza[1][1] == 'X' && plansza[2][1] == 'X' ||
                plansza[0][2] == 'X' && plansza[1][2] == 'X' && plansza[2][2] == 'X' ||
                plansza[0][0] == 'X' && plansza[1][1] == 'X' && plansza[2][2] == 'X' ||
                plansza[2][0] == 'X' && plansza[1][1] == 'X' && plansza[0][2] == 'X') {
            System.out.println("X wins");
            return true;
        } else if (plansza[0][0] == 'O' && plansza[0][1] == 'O' && plansza[0][2] == 'O' ||
                plansza[1][0] == 'O' && plansza[1][1] == 'O' && plansza[1][2] == 'O' ||
                plansza[2][0] == 'O' && plansza[2][1] == 'O' && plansza[2][2] == 'O' ||
                plansza[0][0] == 'O' && plansza[1][0] == 'O' && plansza[2][0] == 'O' ||
                plansza[0][1] == 'O' && plansza[1][1] == 'O' && plansza[2][1] == 'O' ||
                plansza[0][2] == 'O' && plansza[1][2] == 'O' && plansza[2][2] == 'O' ||
                plansza[0][0] == 'O' && plansza[1][1] == 'O' && plansza[2][2] == 'O' ||
                plansza[2][0] == 'O' && plansza[1][1] == 'O' && plansza[0][2] == 'O') {
            System.out.println("O wins");
            return true;
        } else {
            if (iloscO[0] + iloscX[0] == 9) {
                System.out.println("Draw");
                return true;
            }
        }
        return false;
    }

    public static boolean ruchGracza(int[] iloscX, int[] iloscO, char[][] plansza) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: > ");
        String Coord1 = scanner.next();
        try {
            int coord = Integer.parseInt(Coord1);

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return true;
        }
        String Coord2 = scanner.next();
        try {
            int coord = Integer.parseInt(Coord2);

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return true;
        }

        int coord1 = Integer.parseInt(Coord1);
        int coord2 = Integer.parseInt(Coord2);

        if (coord1 < 1 || coord1 > 3 || coord2 < 1 || coord2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        }
        if (plansza[coord1 - 1][coord2 - 1] == 'X' || plansza[coord1 - 1][coord2 - 1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }

        if (iloscX[0] > iloscO[0]) {
            plansza[coord1 - 1][coord2 - 1] = 'O';
            iloscO[0]++;
        } else if (iloscX[0] == iloscO[0]) {
            plansza[coord1 - 1][coord2 - 1] = 'X';
            iloscX[0]++;
        }
        return false;
    }

    public static void ruchBota(int[] iloscO, int[] iloscX, char[][] plansza) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        boolean wolny = false;
        if (iloscO[0] + iloscX[0] == 9) {
            return;
        }
        while (!wolny) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (plansza[x][y] != 'X' && plansza[x][y] != 'O') {
                if (iloscX[0] > iloscO[0]) {
                    plansza[x][y] = 'O';
                    iloscO[0]++;
                } else if (iloscX[0] == iloscO[0]) {
                    plansza[x][y] = 'X';
                    iloscX[0]++;
                }
                wolny = true;
            }
        }
    }

    public static void ruchBotaMedium(int[] iloscO, int[] iloscX, char[][] plansza) {
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        boolean wolny = false;
        if (iloscO[0] + iloscX[0] == 9) {
            return;
        }
        char znacznik = 0;
        char znacznikPrzeciwnik = 0;
        if (iloscX[0] > iloscO[0]) {
            znacznik = 'O';
            znacznikPrzeciwnik = 'X';
            iloscO[0]++;
        } else if (iloscX[0] == iloscO[0]) {
            znacznik = 'X';
            znacznikPrzeciwnik = 'O';
            iloscX[0]++;
        }
        if (plansza[0][0] == znacznikPrzeciwnik && plansza[2][2] == znacznikPrzeciwnik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik;
        } else if (plansza[0][0] == znacznikPrzeciwnik && plansza[1][1] == znacznikPrzeciwnik && plansza[2][2] == ' ') {
            plansza[2][2] = znacznik;
        } else if (plansza[1][1] == znacznikPrzeciwnik && plansza[2][2] == znacznikPrzeciwnik && plansza[0][0] == ' ') {
            plansza[0][0] = znacznik; //skos lewa góra
        } else if (plansza[2][0] == znacznikPrzeciwnik && plansza[1][1] == znacznikPrzeciwnik && plansza[0][2] == ' ') {
            plansza[0][2] = znacznik;
        } else if (plansza[0][2] == znacznikPrzeciwnik && plansza[1][1] == znacznikPrzeciwnik && plansza[2][0] == ' ') {
            plansza[2][0] = znacznik;
        } else if (plansza[0][2] == znacznikPrzeciwnik && plansza[2][0] == znacznikPrzeciwnik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik; //skos prawa góra
        } else if (plansza[0][0] == znacznikPrzeciwnik && plansza[1][0] == znacznikPrzeciwnik && plansza[2][0] == ' ') {
            plansza[2][0] = znacznik;
        } else if (plansza[0][0] == znacznikPrzeciwnik && plansza[2][0] == znacznikPrzeciwnik && plansza[1][0] == ' ') {
            plansza[1][0] = znacznik;
        } else if (plansza[2][0] == znacznikPrzeciwnik && plansza[1][0] == znacznikPrzeciwnik && plansza[0][0] == ' ') {
            plansza[0][0] = znacznik; // lewy pion
        } else if (plansza[0][2] == znacznikPrzeciwnik && plansza[1][2] == znacznikPrzeciwnik && plansza[2][2] == ' ') {
            plansza[2][2] = znacznik;
        } else if (plansza[0][2] == znacznikPrzeciwnik && plansza[2][2] == znacznikPrzeciwnik && plansza[1][2] == ' ') {
            plansza[1][2] = znacznik;
        } else if (plansza[1][2] == znacznikPrzeciwnik && plansza[2][2] == znacznikPrzeciwnik && plansza[0][2] == ' ') {
            plansza[0][2] = znacznik; // prawy pion
        } else if (plansza[0][1] == znacznikPrzeciwnik && plansza[1][1] == znacznikPrzeciwnik && plansza[2][1] == ' ') {
            plansza[2][1] = znacznik;
        } else if (plansza[0][1] == znacznikPrzeciwnik && plansza[2][1] == znacznikPrzeciwnik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik;
        } else if (plansza[2][1] == znacznikPrzeciwnik && plansza[1][1] == znacznikPrzeciwnik && plansza[0][1] == ' ') {
            plansza[0][1] = znacznik; // środek pion
        } else if (plansza[0][1] == znacznikPrzeciwnik && plansza[0][2] == znacznikPrzeciwnik && plansza[0][0] == ' ') {
            plansza[0][0] = znacznik;
        } else if (plansza[0][0] == znacznikPrzeciwnik && plansza[0][2] == znacznikPrzeciwnik && plansza[0][1] == ' ') {
            plansza[0][1] = znacznik;
        } else if (plansza[0][1] == znacznikPrzeciwnik && plansza[0][0] == znacznikPrzeciwnik && plansza[0][2] == ' ') {
            plansza[0][2] = znacznik; // góra poziom
        } else if (plansza[1][0] == znacznikPrzeciwnik && plansza[1][2] == znacznikPrzeciwnik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik;
        } else if (plansza[1][2] == znacznikPrzeciwnik && plansza[1][1] == znacznikPrzeciwnik && plansza[1][0] == ' ') {
            plansza[1][0] = znacznik;
        } else if (plansza[1][1] == znacznikPrzeciwnik && plansza[1][0] == znacznikPrzeciwnik && plansza[1][2] == ' ') {
            plansza[1][2] = znacznik; // środek poziom
        } else if (plansza[2][1] == znacznikPrzeciwnik && plansza[2][2] == znacznikPrzeciwnik && plansza[2][0] == ' ') {
            plansza[2][0] = znacznik;
        } else if (plansza[2][0] == znacznikPrzeciwnik && plansza[2][2] == znacznikPrzeciwnik && plansza[2][1] == ' ') {
            plansza[2][1] = znacznik;
        } else if (plansza[2][0] == znacznikPrzeciwnik && plansza[2][1] == znacznikPrzeciwnik && plansza[2][2] == ' ') {
            plansza[2][2] = znacznik; // dół poziom
        } else if (plansza[0][0] == znacznik && plansza[2][2] == znacznik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik;
        } else if (plansza[0][0] == znacznik && plansza[1][1] == znacznik && plansza[2][2] == ' ') {
            plansza[2][2] = znacznik;
        } else if (plansza[1][1] == znacznik && plansza[2][2] == znacznik && plansza[0][0] == ' ') {
            plansza[0][0] = znacznik; //skos lewa góra
        } else if (plansza[2][0] == znacznik && plansza[1][1] == znacznik && plansza[0][2] == ' ') {
            plansza[0][2] = znacznik;
        } else if (plansza[0][2] == znacznik && plansza[1][1] == znacznik && plansza[2][0] == ' ') {
            plansza[2][0] = znacznik;
        } else if (plansza[0][2] == znacznik && plansza[2][0] == znacznik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik; //skos prawa góra
        } else if (plansza[0][0] == znacznik && plansza[1][0] == znacznik && plansza[2][0] == ' ') {
            plansza[2][0] = znacznik;
        } else if (plansza[0][0] == znacznik && plansza[2][0] == znacznik && plansza[1][0] == ' ') {
            plansza[1][0] = znacznik;
        } else if (plansza[2][0] == znacznik && plansza[1][0] == znacznik && plansza[0][0] == ' ') {
            plansza[0][0] = znacznik; // lewy pion
        } else if (plansza[0][2] == znacznik && plansza[1][2] == znacznik && plansza[2][2] == ' ') {
            plansza[2][2] = znacznik;
        } else if (plansza[0][2] == znacznik && plansza[2][2] == znacznik && plansza[1][2] == ' ') {
            plansza[1][2] = znacznik;
        } else if (plansza[1][2] == znacznik && plansza[2][2] == znacznik && plansza[0][2] == ' ') {
            plansza[0][2] = znacznik; // prawy pion
        } else if (plansza[0][1] == znacznik && plansza[1][1] == znacznik && plansza[2][1] == ' ') {
            plansza[2][1] = znacznik;
        } else if (plansza[0][1] == znacznik && plansza[2][1] == znacznik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik;
        } else if (plansza[2][1] == znacznik && plansza[1][1] == znacznik && plansza[0][1] == ' ') {
            plansza[0][1] = znacznik; // środek pion
        } else if (plansza[0][1] == znacznik && plansza[0][2] == znacznik && plansza[0][0] == ' ') {
            plansza[0][0] = znacznik;
        } else if (plansza[0][0] == znacznik && plansza[0][2] == znacznik && plansza[0][1] == ' ') {
            plansza[0][1] = znacznik;
        } else if (plansza[0][1] == znacznik && plansza[0][0] == znacznik && plansza[0][2] == ' ') {
            plansza[0][2] = znacznik; // góra poziom
        } else if (plansza[1][0] == znacznik && plansza[1][2] == znacznik && plansza[1][1] == ' ') {
            plansza[1][1] = znacznik;
        } else if (plansza[1][2] == znacznik && plansza[1][1] == znacznik && plansza[1][0] == ' ') {
            plansza[1][0] = znacznik;
        } else if (plansza[1][1] == znacznik && plansza[1][0] == znacznik && plansza[1][2] == ' ') {
            plansza[1][2] = znacznik; // środek poziom
        } else if (plansza[2][1] == znacznik && plansza[2][2] == znacznik && plansza[2][0] == ' ') {
            plansza[2][0] = znacznik;
        } else if (plansza[2][0] == znacznik && plansza[2][2] == znacznik && plansza[2][1] == ' ') {
            plansza[2][1] = znacznik;
        } else if (plansza[2][0] == znacznik && plansza[2][1] == znacznik && plansza[2][2] == ' ') {
            plansza[2][2] = znacznik; // dół poziom
        } else {
            while (!wolny) {
                int x = random.nextInt(3);
                int y = random.nextInt(3);
                if (plansza[x][y] != 'X' && plansza[x][y] != 'O') {
                    plansza[x][y] = znacznik;
                    wolny = true;
                }
            }
        }
    }

    public static void czyszczenie(int[] iloscO, int[] iloscX, char[][] plansza) {
        iloscO[0] = 0;
        iloscX[0] = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plansza[i][j] = ' ';
            }
        }
    }

    public static String goodInput() {
        Scanner scanner = new Scanner(System.in);
        String initial;
        while (true) {
            System.out.print("Input command: ");
            initial = scanner.nextLine();
            if (("exit").equals(initial)) {
                return "exit";
            } else if (("start user user").equals(initial) || ("start user easy").equals(initial) || ("start easy user").equals(initial) ||
                    ("start easy easy").equals(initial) || ("start user medium").equals(initial) || ("start medium user").equals(initial) ||
                    ("start medium easy").equals(initial) || ("start easy medium").equals(initial) || ("start medium medium").equals(initial)) {
                return initial;
            } else {
                System.out.println("Bad coordinates!");
                System.out.println(initial);
            }
        }
    }

    public static void BestRuchBota(int[] iloscX, int[] iloscO, char[][] plansza) {
        System.out.println("Making move level \"hard\"");

        if (iloscO[0] + iloscX[0] == 9) {
            return;
        }
        char z = 0;
        char zP = 0;
        if (iloscX[0] > iloscO[0]) {
            z = 'O';
            zP = 'X';
        } else if (iloscX[0] == iloscO[0]) {
            z = 'X';
            zP = 'O';
        }

        int najlepszyWynik = Integer.MIN_VALUE;
        int wynik;

        //funkcja minimax wylicza wynik dla każdego wolnego pola
        for (int i = 0; i < 3; i++ ) {
            for (int j = 0; j < 3; j++) {
                if (plansza[i][j] != 'X' && plansza[i][j] != 'O'){
                    plansza[i][j] = z;
                    wynik = minimax(plansza, 0, true, iloscX, iloscO, z, zP);
                    plansza[i][j] = ' ';
                    if (wynik > najlepszyWynik) {
                        najlepszyWynik = wynik;
                        NajlepszyRuch.i = i;
                        NajlepszyRuch.j = j;
                    }
                }
            }
        }
        plansza[NajlepszyRuch.i][NajlepszyRuch.j] = z;
        if (z == 'X') {
            iloscX[0]++;
        } else if (z == 'O') {
            iloscO[0]++;
        }
    }
    public static int minimax(char[][] plansza, int depth, boolean isMaximizing, int[] iloscX, int[] iloscO, char z, char zP) {
        boolean result = stanGry(plansza, iloscX, iloscO);

        if (result) {

        }

        if (isMaximizing) {
            int najlepszyWynik = Integer.MIN_VALUE;
            int wynik;
            for (int i = 0; i < 3; i++ ) {
                for (int j = 0; j < 3; j++) {
                    if (plansza[i][j] != 'X' && plansza[i][j] != 'O'){
                        plansza[i][j] = z;
                        wynik = minimax(plansza, depth + 1, false, iloscX, iloscO,z, zP);
                        plansza[i][j] = ' ';
                        if (wynik > najlepszyWynik) {
                            najlepszyWynik = wynik;
                        }
                    }
                }
            }
            return najlepszyWynik;
        } else {
            int najlepszyWynik = Integer.MAX_VALUE;
            int wynik;
            for (int i = 0; i < 3; i++ ) {
                for (int j = 0; j < 3; j++) {
                    if (plansza[i][j] != 'X' && plansza[i][j] != 'O'){
                        plansza[i][j] = zP;
                        wynik = minimax(plansza, depth + 1, true, iloscX, iloscO,z, zP);
                        plansza[i][j] = ' ';
                        if (wynik < najlepszyWynik) {
                            najlepszyWynik = wynik;
                        }
                    }
                }
            }
            return najlepszyWynik;
        }
    }
    public class NajlepszyRuch {
        public static int i;
        public static int j;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] plansza = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plansza[i][j] = ' ';
            }
        }
        int[] iloscX = new int[1];
        int[] iloscO = new int[1];

        while (true) {
            String initial = goodInput();
            if(("exit").equals(initial)) {
                return;
            }
            wyswietlPlansze(plansza);
            while (!stanGry(plansza, iloscX, iloscO)) {
                if (initial.contains("start user")) {
                    while (ruchGracza(iloscX, iloscO, plansza)) {
                    }
                } else if (initial.contains("start easy")) {
                    ruchBota(iloscO, iloscX, plansza);
                } else if (initial.contains("start medium")) {
                    ruchBotaMedium(iloscO, iloscX, plansza);
                }
                wyswietlPlansze(plansza);
                if (stanGry(plansza, iloscX, iloscO)) {
                    break;
                }
                if (initial.contains("user user") || initial.contains("easy user") || initial.contains("medium user")) {
                    ruchGracza(iloscX, iloscO, plansza);
                } else if (initial.contains("user easy") || initial.contains("easy easy") || initial.contains("medium easy")) {
                    ruchBota(iloscO, iloscX, plansza);
                } else if (initial.contains("user medium") || initial.contains("easy medium") || initial.contains("medium medium")) {
                    ruchBotaMedium(iloscO, iloscX, plansza);
                }
                wyswietlPlansze(plansza);
                if (stanGry(plansza, iloscX, iloscO)) {
                    break;
                }
            }
            czyszczenie(iloscO, iloscX, plansza);
        }
    }
}




