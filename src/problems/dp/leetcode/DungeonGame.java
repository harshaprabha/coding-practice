package problems.dp.leetcode;

public class DungeonGame {

  public static void main(String[] args) {
    int[][] dungeon = {{-100, 200}};
    System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
  }

  public int calculateMinimumHP(int[][] dungeon) {

    int m = dungeon.length;
    if (m == 0) {
      return 0;
    }
    int n = dungeon[0].length;

    if (n == 0) {
      return 0;
    }

    int result = calculateMin(0, 0, 0, dungeon[0][0], m, n, dungeon);
    return result < 0 ? Math.abs(result) + 1 : 1;

  }

  int calculateMin(int i, int j, int health, int minHealth, int m, int n, int[][] dungeon)
      throws RuntimeException {

    int min = Integer.MIN_VALUE;
    if (i >= m || j >= n) {
      return min;
    }

    if (health + dungeon[i][j] < minHealth) {
      minHealth = health + dungeon[i][j];
    }
    if (i == m - 1 && j == n - 1) {
      return minHealth;
    }

    min = Math.max(calculateMin(i, j + 1, health + dungeon[i][j], minHealth, m, n, dungeon),
        calculateMin(i + 1, j, health + dungeon[i][j], minHealth, m, n, dungeon));

    return min;
  }


}
