package problems.contests.leetcode;

public class StringPermutation {

  public static void main(String[] args) {

    System.out.println(new StringPermutation().checkInclusion("abc","eidboavvabba"));

  }

  public boolean checkInclusion(String s1, String s2) {

    int n = s1.length();
    int[] count = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      count[s1.charAt(i) - 'a']++;
    }

    int[] copy;
    copy=count.clone();

    int c = 0;
    int start = 0;
    boolean beginning = false;
    for (int i = 0; i < s2.length(); ) {

      if (copy[s2.charAt(i) - 'a'] != 0) {
        if (beginning == false) {
          beginning = true;
          start = i;
        }
        c++;
        copy[s2.charAt(i) - 'a']--;
        i++;

      } else {
        if (beginning == true) {
          beginning = false;
          i = start + 1;
          copy = count.clone();
        }
        else i++;
        c = 0;

      }

      if (c == s1.length()) {
        return true;
      }


    }

    return c == s1.length() ? true : false;


  }

}
