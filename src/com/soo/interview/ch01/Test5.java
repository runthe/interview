package com.soo.interview.ch01;

public class Test5 {

  public static void main(String[] args) {
    int[][] omok = new int[19][19];

    makeSampleData(omok);

    printOmok(omok);
    getOmokWinner(omok);
  }

  private static void makeSampleData(int[][] omok) {
    for (int i = 0; i < 5; i++) {
      omok[0][i] = 1;

      if (i != 0) {
        omok[i][0] = 2;
      }
    }
  }

  public static int printOmok(int[][] omok) {
    for (int i = 0; i < omok.length; i++) {
      System.out.println();
      for (int j = 0; j < omok[i].length; j++) {
        System.out.print(omok[i][j] + " ");
      }
    }

    return 0;
  }

  public static int getOmokWinner(int[][] omok) {
    for (int i = 0; i < omok.length; i++) {
      for (int j = 0; j < omok[i].length; j++) {
        if (isStone(omok[i][j])) {

          findOmokFromWidth(omok, i, j);
          findOmokFromHeight(omok, i, j);
        }
      }
    }

    return 0;
  }

  private static void findOmokFromHeight(int[][] omok, int i, int j) {
    if (omok[i][j] == omok[i + 1][j] && omok[i][j] == omok[i + 2][j] && omok[i][j] == omok[i + 3][j] && omok[i][j] == omok[i + 3][j]) {
      System.out.println("Winner" + omok[i][j]);
    }
  }

  private static void findOmokFromWidth(int[][] omok, int i, int j) {
    if (omok[i][j] == omok[i][j + 1] && omok[i][j] == omok[i][j + 2] && omok[i][j] == omok[i][j + 3] && omok[i][j] == omok[i][j + 4]) {
      System.out.println("Winner" + omok[i][j]);
    }
  }

  public static boolean isStone(int stone) {
    return stone == 1 || stone == 2;
  }
}
