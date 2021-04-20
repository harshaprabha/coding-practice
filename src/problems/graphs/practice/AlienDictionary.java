//package problems.graphs.practice;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class AlienDictionary {
//
//  public static void main(String[] args) {
//    String A[] = {"wrt", "wrf", "er", "ett", "rftt"};
//    System.out.println(new AlienDictionary().alienOrder(A));
//  }
//
//  public String alienOrder(String[] words) {
//
//    Map<String,List<String>> graph= new HashMap<>();
//
//
//    int n = words.length;
//    String result = "";
//    //create graph and indegree array
//
//
//    for (int i = 0; i < 26; i++) {
//      graph.add(new LinkedList<>());
//    }
//
//    Set<Integer> vertices = new HashSet<>();
//
//    int[] indegree = new int[26];
//
//    for (String word : words) {
//      for (int i = 0; i < word.length(); i++) {
//        vertices.add(word.charAt(i) - 'a');
//        if (i - 1 >= 0 && word.charAt(i - 1) != word.charAt(i)
//            && graph.get(word.charAt(i - 1) - 'a') != null && !graph.get(word.charAt(i - 1) - 'a')
//            .contains(word.charAt(i) - 'a')) {
//          graph.get(word.charAt(i - 1) - 'a').add(word.charAt(i) - 'a');
//          indegree[word.charAt(i) - 'a']++;
//        }
//
//      }
//    }//for
//
//    while (true) {
//      int i = -1;
//      // start with 0 indegree vertices one at a time and do TS
//      for (i = 0; i < 26; i++) {
//        // pick with indegree zero
//        if (indegree[i] == 0 && vertices.contains(i)) {
//          break;
//        }
//
//      } //for
//
//      if (i == 26) // no vertices with indegree zero
//      {
//        break;
//      }
//
//      result += (char) (i + 97);// add char to result
//      indegree[i] = -1; // visit them by marking to -1
//
//      //
//      for (Integer edge : graph.get(i)) {
//        // remove edge
//        indegree[edge]--;
//      }
//
//    }//while
//
//    return result;
//
//  }
//}
