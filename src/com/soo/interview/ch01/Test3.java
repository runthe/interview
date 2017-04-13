package com.soo.interview.ch01;


import java.util.Arrays;

public class Test3 {

  public static void main(String[] args) {
    String a = "aaa ";
    String b = "AAA";

    System.out.println("아나그램:" + isAnagram(a, b));
  }

  private static boolean isAnagram(String a, String b) {
    char[] charsA = a.trim().toLowerCase().toCharArray();
    char[] charsB = b.trim().toLowerCase().toCharArray();

    //QuickSort 정렬함d
    Arrays.sort(charsA);
    Arrays.sort(charsB);

    String newA = new String(charsA);
    String newB = new String(charsB);

    return newA.equals(newB);
  }
}
