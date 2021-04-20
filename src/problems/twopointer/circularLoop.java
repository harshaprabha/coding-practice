package problems.twopointer;

public class circularLoop {

  public static void main(String[] args) {
    int nums[]={2,-1,1,-4,-1};
    System.out.println(new circularLoop().circularArrayLoop(nums));
  }

  public boolean circularArrayLoop(int[] nums) {


      int n= nums.length;
      int left=0;
      int len=0;
      int right=0;
      boolean forward=nums[0]>0?true:false;

      while(true)
      {
        right=((nums[right]%n+right%n) +n)%n;
        if(forward==(nums[right]>0))
        {
          len++;
        }
        else
        {
          forward=nums[right]>0;
          len=0;
          left=right;
        }

        if(left==right && len!=0)
        break;

      }
      return len>1?true:false;

    }

  }


