package com.soo.interview.ch01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Maze {
  public static int n;
  public static int m;
  public static int[][] arr;

  public static final int STREET = 0;


  public static void main(String[] args) {
    initializeArr();
    Integer step = move(0, 0, 0, n - 1, 0);

    System.out.println(step);
    printArr();

    return;
  }

  private static Integer move(int step, int currentI, int currentJ, int nextI, int nextJ) {
    if (currentI == 0 && currentJ == m - 1) {
      return step;
    } else {
      step++;
      List<int[]> nextStepCoords = getNextStepCoords(currentI, currentJ, nextI, nextJ);

      if (nextStepCoords.size() > 0) {
        int minStepCount = 0;

        for (int[] nextStepCoord : nextStepCoords) {
          int moveStepCount = move(step, nextI, nextJ, nextStepCoord[0], nextStepCoord[1]);

          if (minStepCount == 0 || minStepCount > moveStepCount) {
            minStepCount = moveStepCount;
          }
        }
        return minStepCount;
      }
    }

    return -1;
  }

  private static List<int[]> getNextStepCoords(int currentI, int currentJ, int nextI, int nextJ) {
    int eastI = nextI;
    int eastJ = nextJ + 1;
    int westI = nextI;
    int westJ = nextJ - 1;
    int northI = nextI - 1;
    int northJ = nextJ;
    int southI = nextI + 1;
    int southJ = nextJ;

    List<int[]> nextStepCoord = new ArrayList<int[]>();

    if (isRangeNumber(eastI, eastJ) && !(currentI == eastI && currentJ == eastJ) && isStreet(arr[eastI][eastJ])) {
      nextStepCoord.add(new int[]{eastI, eastJ});
    }

    if (isRangeNumber(westI, westJ) && !(currentI == westI && currentJ == westJ) && isStreet(arr[westI][westJ])) {
      nextStepCoord.add(new int[]{westI, westJ});
    }

    if (isRangeNumber(northI, northJ) && !(currentI == northI && currentJ == northJ) && isStreet(arr[northI][northJ])) {
      nextStepCoord.add(new int[]{northI, northJ});
    }

    if (isRangeNumber(southI, southJ) && !(currentI == southI && currentJ == southJ) && isStreet(arr[southI][southJ])) {
      nextStepCoord.add(new int[]{southI, southJ});
    }

    return nextStepCoord;
  }

  private static boolean isRangeNumber(int i, int j) {
    if ((i >= 0 && i <= n - 1) && (j >= 0 && j <= m - 1)) {
      return true;
    }

    return false;
  }

  private static boolean isStreet(int value) {
    return value == STREET ? true : false;
  }

  private static void initializeArr() {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    arr = new int[n][m];

    nLabel:
    for (int i = 0; i < n; i++) {
      String[] lines = sc.next().split("");

      mLabel:
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(lines[j]);
      }
    }
  }

  private static void printArr() {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println("");
    }
  }
}