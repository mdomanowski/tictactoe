package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void wyswietlPlansze(char[][] plansza) {
        System.out.println("---------");
        System.out.println("| " + plansza[0][0] + " " + plansza[0][1] + " " + plansza[0][2] + " |");
        System.out.println("| " + plansza[1][0] + " " + plansza[1][1] + " " + plansza[1][2] + " |");
        System.out.println("| " + plansza[2][0] + " " + plansza[2][1] + " " + plansza[2][2] + " |");
        System.out.println("---------");
        }
    public static void stanGry(char[][] plansza, int[] iloscX, int[] iloscO) {
        if (plansza[0][0] == 'X' && plansza[0][1] == 'X' && plansza[0][2] == 'X' ||
                plansza[1][0] == 'X' && plansza[1][1] == 'X' && plansza[1][2] == 'X' ||
                plansza[2][0] == 'X' && plansza[2][1] == 'X' && plansza[2][2] == 'X' ||
                plansza[0][0] == 'X' && plansza[1][0] == 'X' && plansza[2][0] == 'X' ||
                plansza[0][1] == 'X' && plansza[1][1] == 'X' && plansza[2][1] == 'X' ||
                plansza[0][2] == 'X' && plansza[1][2] == 'X' && plansza[2][2] == 'X' ||
                plansza[0][0] == 'X' && plansza[1][1] == 'X' && plansza[2][2] == 'X' ||
                plansza[2][0] == 'X' && plansza[1][1] == 'X' && plansza[0][2] == 'X') {
            System.out.println("X wins");
            return;
        } else if (plansza[0][0] == 'O' && plansza[0][1] == 'O' && plansza[0][2] == 'O' ||
                plansza[1][0] == 'O' && plansza[1][1] == 'O' && plansza[1][2] == 'O' ||
                plansza[2][0] == 'O' && plansza[2][1] == 'O' && plansza[2][2] == 'O' ||
                plansza[0][0] == 'O' && plansza[1][0] == 'O' && plansza[2][0] == 'O' ||
                plansza[0][1] == 'O' && plansza[1][1] == 'O' && plansza[2][1] == 'O' ||
                plansza[0][2] == 'O' && plansza[1][2] == 'O' && plansza[2][2] == 'O' ||
                plansza[0][0] == 'O' && plansza[1][1] == 'O' && plansza[2][2] == 'O' ||
                plansza[2][0] == 'O' && plansza[1][1] == 'O' && plansza[0][2] == 'O') {
            System.out.println("O wins");
            return;
        } else {
            if (iloscO[0] + iloscX[0] == 9) {
                System.out.println("Draw");
            } else {
                System.out.println("Game not finished");
            }
        }
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

        if(iloscX[0] > iloscO[0]) {
            plansza[coord1-1][coord2-1] = 'O';
            iloscO[0]++;
        } else if (iloscX[0] == iloscO[0]) {
            plansza[coord1-1][coord2-1] = 'X';
            iloscX[0]++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] plansza = new char[3][3];
        System.out.print("Enter the cells: > ");
        String pozycje = scanner.next();
        int k = 0;
        int[] iloscX = new int[1];
        iloscX[0] = 0;
        int[] iloscO = new int[1];
        iloscO[0] = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pozycje.charAt(k) == 'X') {
                    iloscX[0]++;
                } else if (pozycje.charAt(k) == 'O') {
                    iloscO[0]++;
                }

                if (pozycje.charAt(k) == '_') {
                    plansza[i][j] = ' ';
                } else {
                    plansza[i][j] = pozycje.charAt(k);
                }
                k++;
            }
        }
        wyswietlPlansze(plansza);
        while (ruch(iloscX, iloscO, plansza) == false) {
        }
        wyswietlPlansze(plansza);
        stanGry(plansza, iloscX, iloscO);
    }
}




