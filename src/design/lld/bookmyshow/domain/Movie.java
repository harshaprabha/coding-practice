package lld.bookmyshow.domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {

  private long id;
  private String name;
  List<City> cities;

  public Movie() {
    this.id = id;
    this.name = name;
    this.cities = new ArrayList<>();
  }
}
