package lld.bookmyshow.service;

import java.util.List;
import lld.bookmyshow.domain.Hall;
import lld.bookmyshow.domain.Seat;

public interface BookingManager {

  void holdSeats(Hall hall, List<Seat> seats);

  boolean checkSeatAvailability(Hall hall, List<Seat> seats);

}
