package lld.bookmyshow.domain;

import java.util.List;

public class Cinema {
  private long id;
  private City city;
  private List<Hall> halls;

  public Cinema(long id,City city){
    this.id=id;
    this.city=city;
  }

}
