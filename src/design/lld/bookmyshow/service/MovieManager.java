package lld.bookmyshow.service;

import java.util.Arrays;
import java.util.Arrays.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lld.bookmyshow.domain.City;
import lld.bookmyshow.domain.Movie;

public class MovieManager {

  private Map<City, Set<Movie>> cityMovieMap;
  Set<int[][]> visited= new HashSet<>();
  static int[][] board={{1,2,3},{4,5,0}};

  public static void main(String[] args) {

    System.out.println(Arrays.deepToString(board));
  }
  void addMovie(Movie movie){


    Arrays.copyOf(board,board.length);

  }

}
