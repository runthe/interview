package com.soo.interview.ch01;

public class Test6 {

  public static void main(String[] args) {
    final int[][] omok = new int[19][19];

    makeSampleData(omok);

    //printOmok(omok);
    printOmokWinner(omok);
    printOmokTwoLineOnContinuedStonePath(omok);
  }

  private static void makeSampleData(int[][] omok) {
    for (int i = 0; i < 5; i++) {
      omok[i][1] = 2;

      if (i != 0) {
        omok[i][0] = 1;
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

  public static int printOmokWinner(int[][] omok) {
    xLabel:
    for (int i = 0; i < omok.length; i++) {
      yLabel:
      for (int j = 0; j < omok[i].length; j++) {
        if (isStone(omok[i][j])) {
          if (j < 15) {
            if (isStone(findOmokWinnerFromWidth(omok, i, j))) {
              System.out.println(omok[i][j]);
              break xLabel;
            }
          }

          if (i < 15) {
            if (isStone(findWinnerFromHeight(omok, i, j))) {
              System.out.println(omok[i][j]);
              break xLabel;

            }
          }

          if (i < 15 && j < 15) {
            if (isStone(findOmokWinnerFormDiagonal(omok, i, j))) {
              System.out.println(omok[i][j]);
              break xLabel;
            }
          }
        }
      }
    }

    return 0;
  }

  private static int findWinnerFromHeight(int[][] omok, int i, int j) {
    if (omok[i][j] == omok[i + 1][j] && omok[i][j] == omok[i + 2][j] && omok[i][j] == omok[i + 3][j] && omok[i][j] == omok[i + 4][j]) {
      return omok[i][j];
    }

    return 0;
  }

  private static int findOmokWinnerFromWidth(int[][] omok, int i, int j) {
    if (omok[i][j] == omok[i][j + 1] && omok[i][j] == omok[i][j + 2] && omok[i][j] == omok[i][j + 3] && omok[i][j] == omok[i][j + 4]) {
      return omok[i][j];
    }

    return 0;
  }

  private static int findOmokWinnerFormDiagonal(int[][] omok, int i, int j) {
    if (omok[i][j] == omok[i + 1][j + 1] && omok[i][j] == omok[i + 2][j + 2] && omok[i][j] == omok[i + 3][j + 3] && omok[i][j] == omok[i + 4][j + 4]) {
      return omok[i][j];
    }

    return 0;
  }

  private static void printOmokTwoLineOnContinuedStonePath(int[][] omok) {
    final int twoLineIndex = 1;

    for (int k = 0; k < omok[2].length; k++) {
      if (k < 18) {
        if (isStone(omok[twoLineIndex][k]) && omok[twoLineIndex][k] == omok[twoLineIndex][k + 1]) {
          System.out.println(String.format("%d %d", twoLineIndex + 1, k + 1));
          break;
        }
        if (isStone(omok[k][twoLineIndex]) && omok[k][twoLineIndex] == omok[k + 1][twoLineIndex]) {
          System.out.println(String.format("%d %d", k + 1, twoLineIndex + 1));
          break;
        }
      }
    }
  }

  public static boolean isStone(int stone) {
    return stone == 1 || stone == 2;
  }
}
