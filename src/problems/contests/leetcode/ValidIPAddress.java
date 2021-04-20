package problems.contests.leetcode;

public class ValidIPAddress {

  public static void main(String[] args) {
    System.out.println(new ValidIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
  }

  public String validIPAddress(String IP) {

    int n = IP.length();
    boolean ipV4 = IP.contains(".") ? true : false;
    boolean ipV6 = IP.contains(":") ? true : false;

    if ((ipV4 && ipV6) || (!ipV4 && !ipV6)) {
      return "Neither";
    }

    int separatorCount = 0;
    int addressCount = 0;

    StringBuilder num = new StringBuilder();
    for (int i = 0; i < n; i++) {

      if (IP.charAt(i) == '.' || IP.charAt(i) == ':') {
        if (ipV4 && ((addressCount <= 0 || addressCount > 3)
            || Integer.valueOf(num.toString()) > 255)) {
          return "Neither";
        }

        if (ipV6 && ((Integer.valueOf(num.toString()) != 0) || addressCount != 4)) {
          return "Neither";
        }

        separatorCount++;
        addressCount = 0;
        num = new StringBuilder();

      } else {
        if (ipV4 && !Character.isDigit(IP.charAt(i))) {
          return "Neither";
        }
        if (ipV6 && !Character.isLetterOrDigit(IP.charAt(i))) {
          return "Neither";
        }
        if (ipV4 && addressCount == 0 && IP.charAt(i) == '0') {
          return "Neither";
        }

        num.append(IP.charAt(i));
        addressCount++;
      }

    }

    if (addressCount == 0 || (ipV4 && Integer.valueOf(num.toString()) > 255)) {
      return "Neither";
    }

    return separatorCount == 3 && ipV4 ? "IPv4" : separatorCount == 7 && ipV6 ? "IPv6" : "Neither";
  }

}
