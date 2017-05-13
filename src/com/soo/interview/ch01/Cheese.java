package com.soo.interview.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cheese {
  public static final int PAPER = 0;
  public static final int CHEESE = 1;
  public static final int EXPOSED_PAPER = 2;

  public static int n;
  public static int m;
  public static int[][] arr;

  //좌표 캐쉬해야함

  public static void main(String[] args) {
    initializeArr();
    //printArr();
    System.out.println("Hour::" + calculateMeltingCheeseHour(0));

    return;
  }

  private static int calculateMeltingCheeseHour(int hour) {
    List exposedCheeseList = new ArrayList<int[]>();

    nlabel:
    for (int i = 1; i < n; i++) {
      mLabel:
      for (int j = 1; j < m; j++) {
        if (isCheese(arr[i][j])) {
          if (isExposedCheese(i, j)) {
            exposedCheeseList.add(new int[]{i, j});
          }
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

    if (isRangeNumber(i, j - 1) && arr[i][j - 1] == PAPER) {
      exposedCount++;
    }

    if (isRangeNumber(i, j + 1) && arr[i][j + 1] == PAPER) {
      exposedCount++;
    }

    if (isRangeNumber(i - 1, j) && arr[i - 1][j] == PAPER) {
      exposedCount++;
    }

    if (isRangeNumber(i + 1, j) && arr[i + 1][j] == PAPER) {
      exposedCount++;
    }

    return exposedCount >= 2 ? true : false;
  }

  private static boolean isExposedPaper(int i, int j) {
    //north, south, east, and west
    //i j++ j--
    //i++ i-- j

    return true;
  }

  /*
  private static boolean isEdgePaper(int i, int j) {
    if ((i == 0) || (j == 0)) {
      return true;
    } else {
      return false;
    }
  }
  */

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
