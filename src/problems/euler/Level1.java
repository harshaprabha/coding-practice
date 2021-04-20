package problems.euler;

public class Level1 {

  public static void main(String[] args) {


    int count=0;
    int sum=0;
    int val=0;
    while(true)
    {
      if(count==100)
      {
        System.out.println(sum);
        break;
      }

      sum+=val;
      val=val+2;
      count++;

    }
  }

}
