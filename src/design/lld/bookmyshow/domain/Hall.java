package lld.bookmyshow.domain;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import java.util.ArrayList;
import java.util.List;


public class Hall {
  private long id;
  private Cinema cinema;
  private List<Seat> seat;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Cinema getCinema() {
    return cinema;
  }

  public void setCinema(Cinema cinema) {
    this.cinema = cinema;
  }

  public List<Seat> getSeat() {
    return seat;
  }

  public void setSeat(List<Seat> seat) {
    this.seat = seat;
  }

  public Hall(long id, Cinema cinema)
  {
    this.id=id;
    this.cinema=cinema;
    this.seat= new ArrayList<>();
  }


}
