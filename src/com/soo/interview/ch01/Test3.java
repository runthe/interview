package com.soo.interview.ch01;


import java.util.Arrays;

public class Test3 {

  public static void main(String[] args) {
    String a = "aaa ";
    String b = "AAA";

    System.out.println("아나그램:" + isAnagram(a, b));
    System.out.println("아나그램:" + isAnagram2(a, b));
  }

  private static String sort(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);

    return new String(chars);
  }

  private static boolean isAnagram(String a, String b) {
    a = a.trim();
    b = b.trim();

    if (a.trim().length() != b.length()) {
      return false;
    }

    a = a.toLowerCase();
    b = b.toLowerCase();

    return sort(a).equals(sort(b));
  }

  private static boolean isAnagram2(String a, String b) {
    a = a.trim().toLowerCase();
    b = b.trim().toLowerCase();

    if (a.length() != b.length()) {
      return false;
    }

    int[] letters = new int[256]; // 가정
    char[] aChars = a.toCharArray();

    //배열의 [] ++ 연산은 각 방의 값을 올려주는거임
    for (char c : aChars) { //s내의 각 문자 출현 횟수를 센다
      letters[c]++;
    }

    //다른배열을 돌면서 각 방의 값이 0으로 수렴하는지 확인 기본 배열값은 0으로 초기화 되기 떄문
    for (int i = 0; i < b.length(); i++) {
      int c = (int) b.charAt(i);
      if (--letters[c] < 0) {
        return false;
      }
    }

    System.out.println("int[] 배열:" + letters);

    return true;
  }
}
