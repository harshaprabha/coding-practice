package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    System.out.println(new TwoSum().twoSum(new ArrayList<>(Arrays.asList(2, 11, -2, 15, 3, 7)), 9));
  }

  class ArrayElement {

    int value;
    int index;

    ArrayElement(int v, int i) {
      this.value = v;
      this.index = i;
    }
  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> twoSum(final List<Integer> A, int B) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<ArrayElement> arrList = new ArrayList<ArrayElement>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A.size(); i++) {
      arrList.add(new ArrayElement(A.get(i), i));
    }

    Collections.sort(arrList, new Comparator<ArrayElement>() {
      @Override
      public int compare(ArrayElement o1, ArrayElement o2) {
        return o1.value - o2.value;
      }
    });
    int left = 0;
    int right = arrList.size() - 1;

    while (left != right) {
      int sum = arrList.get(left).value + arrList.get(right).value;
      if (sum == B) {
        int leftIndex = arrList.get(left).index;
        int rightIndex = arrList.get(right).index;
        int key = leftIndex < rightIndex ? leftIndex : rightIndex;
        int value = leftIndex > rightIndex ? leftIndex : rightIndex;

        if (!map.containsKey(key) || value < map.get(key)) {
          map.put(key, value);
        }

        if (left != right - 1 && arrList.get(right).value == arrList.get(right - 1).value) {
          right--;
        } else {
          break;
        }

      } else if (sum < B) {
        left++;
      } else {
        right--;
      }
    }

    if (left >= right) {
      return result;
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      result.add(entry.getKey() + 1);
      result.add(entry.getValue() + 1);

    }

    return result;

  }

}
