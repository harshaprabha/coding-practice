package problems.strings;

public class DivideStrings {

  public static void main(String[] args) {
    String dividend="12345";
    String divisor="11";
    System.out.println(new DivideStrings().divide(dividend,divisor));
  }

  String divide(String dividend, String divisor){
    String quotient="";

    String num="";
    for(int i=0;i<dividend.length();i++){

      num+=dividend.charAt(i);
      if(Integer.parseInt(num)<Integer.parseInt(divisor))
        continue;


      quotient+=Integer.parseInt(num)/Integer.parseInt(divisor);
      num=String.valueOf(Integer.parseInt(num)%Integer.parseInt(divisor));

    }

    System.out.println("Remainder="+ num);
    System.out.println("quotient="+ quotient);
    return quotient;


  }

}
