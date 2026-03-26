package com.practice.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/** Seat reservation simulation utilities. */
public final class ReservationSystem {

  private ReservationSystem() {}

  /**
   * Executes reserve/cancel operations and returns operation results by index.
   *
   * <p>Operation format: 0 = reserve smallest available seat, positive value = cancel that seat.
   *
   * <p>Time Complexity: O(k log n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param n total number of seats
   * @param k number of operations
   * @param seat operation array
   * @return per-operation output values
   */
  public static int[] reserveSeats(int n, int k, int[] seat) {
    PriorityQueue<Integer> availableSeats = new PriorityQueue<>();
    Set<Integer> reservedSeats = new HashSet<>();
    int[] result = new int[k];

    for (int i = 1; i <= n; i++) {
      availableSeats.offer(i);
    }

    for (int i = 0; i < k; i++) {
      if (seat[i] == 0) {
        if (!availableSeats.isEmpty()) {
          int reservedSeat = availableSeats.poll();
          reservedSeats.add(reservedSeat);
          result[i] = reservedSeat;
        } else {
          result[i] = -1;
        }
      } else {
        if (reservedSeats.contains(seat[i])) {
          reservedSeats.remove(seat[i]);
          availableSeats.offer(seat[i]);
        }
        result[i] = seat[i];
      }
    }

    return result;
  }

  /**
   * Executes reserve/cancel operations and returns only successful reserve outputs.
   *
   * <p>Operation format: 0 = reserve smallest available seat, positive value = cancel that seat.
   *
   * <p>Time Complexity: O(k log n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param n total number of seats
   * @param k number of operations
   * @param seat operation array
   * @return sequence of reserved seats in reservation order
   */
  public static int[] reserveSeats2(int n, int k, int[] seat) {
    PriorityQueue<Integer> availableCancelledSeats = new PriorityQueue<>();
    Set<Integer> currentReservations = new HashSet<>();
    int nextSmallest = 1;
    List<Integer> reservedResult = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      int val = seat[i];

      if (val == 0) {
        int seatToReserve;
        if (!availableCancelledSeats.isEmpty()) {
          seatToReserve = availableCancelledSeats.poll();
        } else if (nextSmallest <= n) {
          seatToReserve = nextSmallest++;
        } else {
          continue;
        }

        currentReservations.add(seatToReserve);
        reservedResult.add(seatToReserve);
      } else {
        if (currentReservations.contains(val)) {
          currentReservations.remove(val);
          availableCancelledSeats.add(val);
        }
      }
    }

    return reservedResult.stream().mapToInt(Integer::intValue).toArray();
  }
}
