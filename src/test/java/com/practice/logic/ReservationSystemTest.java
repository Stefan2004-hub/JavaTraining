package com.practice.logic;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ReservationSystemTest {

  @Test
  void reserveSeats_ShouldReturnPerOperationOutputs() {
    int[] ops = {0, 0, 1, 0};
    assertArrayEquals(new int[] {1, 2, 1, 1}, ReservationSystem.reserveSeats(5, 4, ops));
  }

  @Test
  void reserveSeats2_ShouldReturnReservationSequence() {
    int[] ops = {0, 0, 1, 0};
    assertArrayEquals(new int[] {1, 2, 1}, ReservationSystem.reserveSeats2(5, 4, ops));
  }

  @Test
  void reserveSeats3_ShouldHandleNoSeatAvailableEdgeCase() {
    int[] ops = {0, 0, 0};
    assertArrayEquals(new int[] {1, 2}, ReservationSystem.reserveSeats3(2, 3, ops));
  }
}
