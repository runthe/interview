package com.soo.interview.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CheeseMain {
  public static final int PAPER = 0;
  public static final int CHEESE = 1;
  public static final int EXPOSED_PAPER = 9;

  public static int n;
  public static int m;
  public static int[][] arr;

  public static void main(String[] args) {
    initializeArr();

    replaceEdgeExposedPaper();
    System.out.println(calculateMeltingCheeseHour(0));

    return;
  }

  private static void replaceEdgeExposedPaper() {
    for (int i = 0; i < m; i++) {
      arr[0][i] = EXPOSED_PAPER;
    }

    for (int i = 0; i < n; i++) {
      arr[i][0] = EXPOSED_PAPER;
    }

    for (int i = 0; i < m; i++) {
      arr[n - 1][i] = EXPOSED_PAPER;
    }

    for (int i = 0; i < n; i++) {
      arr[i][m - 1] = EXPOSED_PAPER;
    }
  }

  private static void findAndReplaceAroundExposedPaper() {
    nlabel:
    for (int i = 1; i < n - 1; i++) {
      mLabel:
      for (int j = 1; j < m - 1; j++) {
        if (isAroundExposedPaper(i, j)) {
          replacePaperExposedPaper(i, j);
        }
      }
    }
  }

  private static void replacePaperExposedPaper(int i, int j) {
    if (isRangeNumber(i, j) && isPaper(i, j)) {
      arr[i][j] = EXPOSED_PAPER;

      replacePaperExposedPaper(i, j - 1);
      replacePaperExposedPaper(i, j + 1);
      replacePaperExposedPaper(i - 1, j);
      replacePaperExposedPaper(i + 1, j);
    }
  }

  private static boolean isPaper(int i, int j) {
    return arr[i][j] == PAPER ? true : false;
  }

  private static boolean isAroundExposedPaper(int i, int j) {
    if (arr[i][j - 1] == EXPOSED_PAPER) {
      return true;
    }

    if (arr[i][j + 1] == EXPOSED_PAPER) {
      return true;
    }

    if (arr[i - 1][j] == EXPOSED_PAPER) {
      return true;
    }

    if (arr[i + 1][j] == EXPOSED_PAPER) {
      return true;
    }

    return false;
  }

  private static int calculateMeltingCheeseHour(int hour) {
    List exposedCheeseList = new ArrayList<int[]>();
    findAndReplaceAroundExposedPaper();

    nlabel:
    for (int i = 1; i < n - 1; i++) {
      mLabel:
      for (int j = 1; j < m - 1; j++) {
        if (isCheese(arr[i][j]) && isExposedCheese(i, j)) {
          exposedCheeseList.add(new int[]{i, j});
        }
      }
    }

    if (exposedCheeseList.size() > 0) {
      meltCheeseList(exposedCheeseList);
      return calculateMeltingCheeseHour(hour + 1);
    } else {
      return hour;
    }
  }

  private static void meltCheeseList(List<int[]> cheeseList) {
    for (int[] coord : cheeseList) {
      arr[coord[0]][coord[1]] = PAPER;
    }
  }

  private static boolean isRangeNumber(int i, int j) {
    if ((i >= 0 && i <= n - 1) && (j >= 0 && j <= m - 1)) {
      return true;
    }

    return false;
  }

  private static boolean isCheese(int v) {
    return v == CHEESE ? true : false;
  }

  private static boolean isExposedCheese(int i, int j) {
    int exposedCount = 0;

    if (isRangeNumber(i, j - 1) && arr[i][j - 1] == EXPOSED_PAPER) {
      exposedCount++;
    }

    if (isRangeNumber(i, j + 1) && arr[i][j + 1] == EXPOSED_PAPER) {
      exposedCount++;
    }

    if (isRangeNumber(i - 1, j) && arr[i - 1][j] == EXPOSED_PAPER) {
      exposedCount++;
    }

    if (isRangeNumber(i + 1, j) && arr[i + 1][j] == EXPOSED_PAPER) {
      exposedCount++;
    }

    return exposedCount >= 2 ? true : false;
  }

  private static void initializeArr() {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    arr = new int[n][m];

    nLabel:
    for (int i = 0; i < n; i++) {
      mLabel:
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(sc.next());
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