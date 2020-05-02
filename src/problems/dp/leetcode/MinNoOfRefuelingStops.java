package problems.dp.leetcode;

public class MinNoOfRefuelingStops {


  public static void main(String[] args) {
    int target = 100;
    int startfuel = 25;
    int[][] stations = {{25,25},{50,25},{75,25}};
    System.out.println(new MinNoOfRefuelingStops().minRefuelStops(target, startfuel, stations));
  }

  public int minRefuelStops(int target, int startFuel, int[][] stations) {

    if (startFuel >= target) {
      return 0;
    }

    int n_stations = stations.length;

    //No station and less fuel
    if (n_stations == 0) {
      return -1;
    }

    int result = minStops(startFuel, 0, 0,target, stations, 0);
    return result == Integer.MAX_VALUE ? -1 : result;

  }

  int minStops(int fuelLeft, int i, int dist, int target, int[][] stations, int count) {
    int min_Stops = Integer.MAX_VALUE;

    if (i == stations.length) {
      if (dist+fuelLeft >= target) {
        return count;
      } else {
        return min_Stops;
      }
    }
    int diff=stations[i][0]-dist;
    // have fuel to reach station
    if (diff <= fuelLeft) {

      fuelLeft = fuelLeft - diff; // distance travelled to reach station
      min_Stops = Math.min(minStops(fuelLeft + stations[i][1], i + 1, stations[i][0],target, stations, count + 1),
          minStops(fuelLeft, i + 1, stations[i][0],target, stations, count));  // Fill or dont fill
    }

    return min_Stops;
  }

}
