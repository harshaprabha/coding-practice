package lld.bookmyshow.service;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import lld.bookmyshow.domain.Hall;
import lld.bookmyshow.domain.Seat;
import lld.bookmyshow.domain.SeatStatus;

public class BookingManagerImpl implements BookingManager {

  ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  ReadLock readLock = lock.readLock();
  WriteLock writeLock = lock.writeLock();

  @Override
  public boolean checkSeatAvailability(Hall hall, List<Seat> seats) {

    readLock.lock();

    try {
      if (hall.getSeat().get(seats.get(0).getId()).getStatus().equals(SeatStatus.AVAILABLE)) {
        // block it
      }
    }
    finally{
      readLock.unlock();
    }

    return false;
  }

  @Override
  public void holdSeats(Hall Hall, List<Seat> seats) {

    writeLock.lock();

    writeLock.unlock();

  }


}
