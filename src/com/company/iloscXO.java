package com.company;

public class iloscXO {
    static int[] iloscX = new int[1];
    static int[] iloscO = new int[1];
    public void pokaziloscXO () {
        System.out.println(iloscX[0]);
        System.out.println(iloscO[0]);
    }
    public void addX() { iloscX[0]++; }
    public void addO() { iloscO[0]++; }
    public void clearXO() {
        iloscO[0] = 0;
        iloscX[0] = 0;
    }

    public static int getIloscO() {
        return iloscO[0];
    }
    public static int getIloscX() {
        return iloscX[0];
    }
}
