package problems.contests.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Codec {

  public static void main(String[] args) {
    System.out.println(new Codec().encode(Collections.singletonList("helloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsmehelloworlditsme")));
  }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

      StringBuilder sb= new StringBuilder();
      for(String str:strs)
      {
        sb.append(getSize(str));
        sb.append(str);
      }
      System.out.println(sb.toString());
      return sb.toString();
    }

    String getSize(String s)
    {
      char[] size= new char[4];
      int n= s.length();
      System.out.println("n="+n);
      // extract every byte
      for(int i=3;i>=0;i--)
      {
        System.out.println("val="+(int)(n>>(8*i)&0xff));
        System.out.println("char val="+(char)(n>>(8*i)&0xff));
        size[3-i]=(char)(n>>(8*i)&0xff);
        System.out.println("byte array ="+size[3-i]);
      }
      System.out.println(new String(size));
      return new String(size);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      List<String> result= new ArrayList<>();
      int sizeLength=4;// 4 bytes
      for(int i=0;i<s.length();)
      {
        // System.out.println(s.substring(i,i+sizeLength));
        int size=getIntSize(s.substring(i,i+sizeLength));
        result.add(s.substring(i+5,i+5+1));
        i=i+5+1;
      }
      return result;
    }

    int getIntSize(String s)
    {
      int n= s.length();

      return 0;

    }

    // Encodes a list of strings to a single string.
    public String encode1(List<String> strs) {

      char delimiter=(char)257;
      StringBuilder sb= new StringBuilder();

      for(int i=0;i<strs.size();i++)
      {
        sb.append(strs.get(i));
        sb.append(delimiter);
      }

      return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode1(String s) {
      char delimiter=(char)257;
      List<String> result= new ArrayList<>();
      int j=0;
      int i=0;
      for( i=0;i<s.length();i++)
      {
        if(s.charAt(i)==257)
        {
          result.add(s.substring(j,i));
          j=i+1;
        }
      }

      return result;

    }


}
