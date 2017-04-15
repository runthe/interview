package com.soo.interview.ch01;


public class Test5 {

  public static void main(String[] args) {
    int[][] omok = new int[19][19];

    setTestData(omok);

    printOmokPan(omok);

    System.out.println("");
    System.out.println("who is winner" + findWhoisOmokWinner(omok));
  }

  private static void setTestData(int[][] omok) {
    for (int i = 0; i < 5; i++) {
      omok[i][i] = 1;
    }

    for (int i = 0; i < 4; i++) {
      omok[i+5][i+5] = 2;
    }
  }

  private static int findWhoisOmokWinner(int[][] omok) {
    int winner = 0;

    xLabel:
    for (int i = 0; i < omok.length; i++) {
      yLabel:
      for (int j = 0; j < omok[i].length; j++) {
        final int value = omok[i][j];

        if (isStone(value)) {
          final int topValue = findOmokWinnerTop(omok, i, j);

          if (isStone(topValue)) {
            winner = topValue;
            break xLabel;
          }
          final int bottomValue = findOmokWinnerBottom(omok, i, j);

          if (isStone(bottomValue)) {
            winner = bottomValue;
            break xLabel;
          }
          final int rightValue = findOmokWinnerRight(omok, i, j);

          if (isStone(rightValue)) {
            winner = rightValue;
            break xLabel;
          }
          final int leftValue = findOmokWinnerLeft(omok, i, j);

          if (isStone(leftValue)) {
            winner = leftValue;
            break xLabel;
          }
          final int diagonalTopValue = findOmokWinnerDiagonalTop(omok, i, j);

          if (isStone(diagonalTopValue)) {
            winner = diagonalTopValue;
            break xLabel;
          }
          final int diagonalBottomValue = findOmokWinnerDiagonalBottom(omok, i, j);

          if (isStone(diagonalBottomValue)) {
            winner = diagonalBottomValue;
            break xLabel;
          }
        }
      }
    }

    return winner;
  }

  public static void printOmokPan(int[][] omok) {
    for (int i = 0; i < omok.length; i++) {
      System.out.println("");
      for (int j = 0; j < omok[i].length; j++) {
        System.out.print(omok[i][j] + " ");
      }
    }
  }

  public static boolean isStone(int value) {
    return value != 0 ? true : false;
  }

  public static boolean isPossiblePlus(int value) {
    return value <= 15;
  }

  public static boolean isPossibleMinus(int value) {
    return value >= 5;
  }

  private static int findOmokWinnerTop(int[][] omok, int i, int j) {
    if (isPossiblePlus(i)) {
      final int value = omok[i][j];

      for (int t = 1; t < 5; t++) {
        if (!(value == omok[i + t][j])) {
          break;
        } else {
          if (t == 4) {
            return value;
          }
        }
      }
    }

    return 0;
  }

  private static int findOmokWinnerBottom(int[][] omok, int i, int j) {
    if (isPossibleMinus(i)) {
      final int value = omok[i][j];

      for (int t = 1; t < 5; t++) {
        if (!(value == omok[i - t][j])) {
          break;
        } else {
          if (t == 4) {
            return value;
          }
        }
      }
    }

    return 0;
  }

  private static int findOmokWinnerRight(int[][] omok, int i, int j) {
    if (isPossiblePlus(j)) {
      final int value = omok[i][j];

      for (int t = 1; t < 5; t++) {
        if (!(value == omok[i][j + t])) {
          break;
        } else {
          if (t == 4) {
            return value;
          }
        }
      }
    }

    return 0;
  }

  private static int findOmokWinnerLeft(int[][] omok, int i, int j) {
    if (isPossibleMinus(j)) {
      final int value = omok[i][j];

      for (int t = 1; t < 5; t++) {
        if (!(value == omok[i][j - t])) {
          break;
        } else {
          if (t == 4) {
            return value;
          }
        }
      }
    }

    return 0;
  }

  private static int findOmokWinnerDiagonalTop(int[][] omok, int i, int j) {
    if (isPossiblePlus(i) && isPossiblePlus(j)) {
      final int value = omok[i][j];

      for (int t = 1; t < 5; t++) {
        if (!(value == omok[i + t][j + t])) {
          break;
        } else {
          if (t == 4) {
            return value;
          }
        }
      }
    }

    return 0;
  }

  private static int findOmokWinnerDiagonalBottom(int[][] omok, int i, int j) {
    if (isPossibleMinus(i) && isPossibleMinus(j)) {
      final int value = omok[i][j];

      for (int t = 1; t < 5; t++) {
        if (!(value == omok[i - t][j - t])) {
          break;
        } else {
          if (t == 4) {
            return value;
          }
        }
      }
    }

    return 0;
  }
}
