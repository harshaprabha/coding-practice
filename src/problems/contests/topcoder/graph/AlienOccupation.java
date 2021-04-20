package problems.contests.topcoder.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AlienOccupation {


  public static void main(String[] args) {
    int N = 123456;
    int A = 0;
    int X[] = {3, 4, 55555};
    int Y[] = {6, 7, 88888};
    int res[] = new AlienOccupation().getInfo(N, A, X, Y);

    System.out.println(res[0] + " " + res[1] + " " + res[2]);

  }

  class Planet {

    int value;
    int depth;

    Planet(int v, int d) {
      this.value = v;
      this.depth = d;
    }
  }

  int[] getInfo(int N, int A, int[] X, int[] Y) {

    int max_planets_occupied = 0;
    boolean[] visited = new boolean[N];
    int max_years = 0;
    int max_planets_in_a_year = 0;
    Map<Integer, Integer> planetCount = new HashMap<>();

    Queue<Planet> queue = new LinkedList<>();

    ((LinkedList<Planet>) queue).add(new Planet(A, 0));
    visited[A] = true;
    max_planets_occupied++;

    while (!queue.isEmpty()) {
      Planet basePlanet = queue.remove();

      if (planetCount.get(basePlanet.depth) == null) {
        planetCount.put(basePlanet.depth, 1);
      } else {
        int count = planetCount.get(basePlanet.depth);
        planetCount.put(basePlanet.depth, count + 1);
      }

      max_years = Math.max(max_years, basePlanet.depth);

      for (int i = 0; i < X.length; i++) {


          long prod = (X[i] * basePlanet.value) % N;
          long planetId = ( ((long)X[i] * (long)basePlanet.value) % N + (long) Y[i] % N) % N;
          if (planetId < N && !visited[(int) planetId]) {
            visited[(int) planetId] = true;
            max_planets_occupied++;
            ((LinkedList<Planet>) queue).add(new Planet((int) planetId, basePlanet.depth + 1));
          }

      }

    }

    int[] result = new int[3];
    result[0] = max_planets_occupied;
    result[1] = max_years;

    for (Map.Entry<Integer, Integer> entry : planetCount.entrySet()) {
      if (entry.getKey() != 0) {
        max_planets_in_a_year = Math.max(max_planets_in_a_year, entry.getValue());
      }

    }

    result[2] = max_planets_in_a_year;

    return result;
  }


}
