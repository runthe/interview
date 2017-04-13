package com.soo.interview.ch01;


public class Test1 {

  /**
   * Q.문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘 // 다른 자료구조를 사용할수 없는 상황이라면 어떻게 하겠는가?
   *
   * @param args
   */

  public static void main(String[] args) {
    final String duplicatedString = "justpower";
    final char[] duplicatedArray = duplicatedString.toCharArray();

    for (int i = 0; i < duplicatedArray.length - 1; i++) {
      final char temp = duplicatedArray[i];
      final char currentChar = duplicatedArray[i + 1];

      if (temp == currentChar) {
        System.out.println("같어" + i);
        break;
      }
    }
  }
}
