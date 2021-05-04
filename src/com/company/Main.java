package com.company;

import java.util.InputMismatchException;
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
    public static boolean ruch(int[] iloscX, int[] iloscO, char[][] plansza) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: > ");
        String Coord1 = scanner.next();
        try {
            int coord = Integer.parseInt(Coord1);

        } catch (NumberFormatException e){
            System.out.println("You should enter numbers!");
            return false;
        }
        String Coord2 = scanner.next();
        try {
            int coord = Integer.parseInt(Coord2);

        } catch (NumberFormatException e){
            System.out.println("You should enter numbers!");
            return false;
        }

        int coord1 = Integer.parseInt(Coord1);
        int coord2 = Integer.parseInt(Coord2);

        if (coord1 < 1 || coord1 > 3 || coord2 < 1 || coord2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (plansza[coord1 - 1][coord2 - 1] == 'X' || plansza[coord1 - 1][coord2 - 1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        plansza[coord1-1][coord2-1] = 'X';
        iloscX[0]++;
        return true;
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
                plansza[x][y] = 'O';
                wolny = true;
                iloscO[0]++;
            }
        }
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
        iloscX[0] = 0;
        int[] iloscO = new int[1];
        iloscO[0] = 0;
        wyswietlPlansze(plansza);
        while (!stanGry(plansza, iloscX, iloscO)) {
            while (!ruch(iloscX, iloscO, plansza)) {
            }
            wyswietlPlansze(plansza);
            if (stanGry(plansza, iloscX, iloscO)) {
                return;
            }
            ruchBota(iloscO, iloscX, plansza);
            wyswietlPlansze(plansza);
            stanGry(plansza, iloscX, iloscO);
        }
    }
}




