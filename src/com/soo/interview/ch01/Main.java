package com.soo.interview.ch01;

import java.util.Scanner;

class Main {

  public static int[][] arr = new int[19][19];
  public static int size = 19;

  public static void main(String[] args) {
    initializeArr();

    printOmokWinner(arr);

    return;
  }

  private static void initializeArr() {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        arr[i][j] = Integer.parseInt(sc.next());
      }
    }
  }

  public static void printOmokWinner(int[][] omok) {
    int stone = 0;

    xLabel:
    for (int i = 0; i < omok.length; i++) {
      yLabel:
      for (int j = 0; j < omok[i].length; j++) {
        if (isStone(omok[i][j])) {
          if (j < 15) {
            if (isStone(findOmokWinnerFromWidth(omok, i, j))) {
              stone = omok[i][j];
              break xLabel;
            }
          }

          if (i < 15) {
            if (isStone(findWinnerFromHeight(omok, i, j))) {
              stone = omok[i][j];
              break xLabel;
            }
          }

          if (i < 15 && j < 15) {
            if (isStone(findOmokWinnerFormPlusDiagonal(omok, i, j))) {
              stone = omok[i][j];
              break xLabel;
            }
          }

          if (i < 15 && j > 4) {
            if (isStone(findOmokWinnerFormMinusDiagonal(omok, i, j))) {
              stone = omok[i][j];
              break xLabel;
            }
          }

        }
      }
    }

    if (!isStone(stone)) {
      System.out.println(stone);
    }
  }

  private static int findWinnerFromHeight(int[][] omok, int i, int j) {
    if (isWinnerFromHeight(omok, i, j)) {
      if (i + 5 < size) {
        if ((omok[i][j] == omok[i + 5][j])) {
          return 0;
        }
      }

      if (i - 1 >= 0) {
        if (omok[i][j] == omok[i - 1][j]) {
          return 0;
        }
      }

      System.out.println(omok[i][j]);
      System.out.println(String.format("%d %d", i + 1, j + 1));
      return omok[i][j];
    }

    return 0;
  }

  private static int findOmokWinnerFromWidth(int[][] omok, int i, int j) {
    if (isWinnerFromWidth(omok, i, j)) {

      if (j + 5 < size) {
        if ((omok[i][j] == omok[i][j + 5])) {
          return 0;
        }
      }

      if (j - 1 >= 0) {
        if (omok[i][j] == omok[i][j - 1]) {
          return 0;
        }
      }

      System.out.println(omok[i][j]);
      System.out.println(String.format("%d %d", i + 1, j + 1));
      return omok[i][j];
    }

    return 0;
  }

  private static int findOmokWinnerFormPlusDiagonal(int[][] omok, int i, int j) {
    if (isWinnerFromPlusDiagonal(omok, i, j)) {

      if (i + 5 < size && j + 5 < size) {
        if (omok[i][j] == omok[i + 5][j + 5]) {
          return 0;
        }
      }

      if (i - 1 >= 0 && j - 1 >= 0) {
        if (omok[i][j] == omok[i - 1][j - 1]) {
          return 0;
        }
      }

      System.out.println(omok[i][j]);
      System.out.println(String.format("%d %d", i + 1, j + 1));
      return omok[i][j];
    }

    return 0;
  }

  private static int findOmokWinnerFormMinusDiagonal(int[][] omok, int i, int j) {
    if (isWinnerFromMinusDiagonal(omok, i, j)) {
      if (i + 5 < size && j - 5 >= 0) {
        if (omok[i][j] == omok[i + 5][j - 5]) {
          return 0;
        }
      }

      if (i - 1 >= 0 && j - 2 >= 0) {
        if (omok[i][j] == omok[i - 1][j - 2]) {
          return 0;
        }
      }

      System.out.println(omok[i][j]);
      System.out.println(String.format("%d %d", (i + 4) + 1, (j - 4) + 1));
      return omok[i][j];
    }

    return 0;
  }

  private static boolean isWinnerFromHeight(int[][] omok, int i, int j) {
    return omok[i][j] == omok[i + 1][j] && omok[i][j] == omok[i + 2][j] && omok[i][j] == omok[i + 3][j] && omok[i][j] == omok[i + 4][j];
  }

  private static boolean isWinnerFromWidth(int[][] omok, int i, int j) {
    return omok[i][j] == omok[i][j + 1] && omok[i][j] == omok[i][j + 2] && omok[i][j] == omok[i][j + 3] && omok[i][j] == omok[i][j + 4];
  }

  private static boolean isWinnerFromPlusDiagonal(int[][] omok, int i, int j) {
    return omok[i][j] == omok[i + 1][j + 1] && omok[i][j] == omok[i + 2][j + 2] && omok[i][j] == omok[i + 3][j + 3] && omok[i][j] == omok[i + 4][j + 4];
  }

  private static boolean isWinnerFromMinusDiagonal(int[][] omok, int i, int j) {
    return omok[i][j] == omok[i + 1][j - 1] && omok[i][j] == omok[i + 2][j - 2] && omok[i][j] == omok[i + 3][j - 3] && omok[i][j] == omok[i + 4][j - 4];
  }

  public static boolean isStone(int stone) {
    return stone == 1 || stone == 2;
  }
}
