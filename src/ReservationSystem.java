import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ReservationSystem {
  // Build a seat reservation system (a function)
  // that performs one of the following operations k times:
  // fetches the smallest number unreserved seat then reserves it and returns it's number,
  // cancels a seat reservation for seat[i].
  // The result should be an array containing the reserved seat numbers.
  // The function takes the following 3 parameters and returns the solution:
  // int N represents the number of seats, int k represents the number of operations
  // int[] seat represents the details of operations

  //     The Logic
  // Available Seats: We use a PriorityQueue to store all seats that are currently unreserved. This
  // gives us the "smallest" seat instantly.

  // Tracking: We use a HashSet to keep track of which seats are currently reserved so we don't try
  // to cancel a seat that isn't even taken.

  // Operations: * If seat[i] == 0: Fetch and remove the smallest from the queue, add to the
  // reserved set.

  // If seat[i] > 0: Add that seat number back into the queue and remove it from the reserved set.

  public static int[] reserveSeats(int N, int k, int[] seat) {
    PriorityQueue<Integer> availableSeats = new PriorityQueue<>();
    Set<Integer> reservedSeats = new HashSet<>();
    int[] result = new int[k];

    // Initialize the priority queue with all seat numbers
    for (int i = 1; i <= N; i++) {
      availableSeats.offer(i);
    }

    for (int i = 0; i < k; i++) {
      if (seat[i] == 0) {
        // Reserve the smallest available seat
        if (!availableSeats.isEmpty()) {
          int reservedSeat = availableSeats.poll();
          reservedSeats.add(reservedSeat);
          result[i] = reservedSeat;
        } else {
          result[i] = -1; // No seats available
        }
      } else {
        // Cancel the reservation for seat[i]
        if (reservedSeats.contains(seat[i])) {
          reservedSeats.remove(seat[i]);
          availableSeats.offer(seat[i]);
        }
        result[i] = seat[i]; // Return the cancelled seat number
      }
    }

    return result;
  }

  public static int[] reserveSeats2(int N, int k, int[] seat) {
    // Tracks seats that were reserved then CANCELLED (available again)
    PriorityQueue<Integer> availableCancelledSeats = new PriorityQueue<>();
    // Tracks currently reserved seats to validate cancellations
    Set<Integer> currentReservations = new HashSet<>();

    // Pointer for the next never-before-reserved seat
    int nextSmallest = 1;

    List<Integer> reservedResult = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      int val = seat[i];

      if (val == 0) {
        // OPERATION: RESERVE
        int seatToReserve;
        // Priority 1: Take the smallest seat that was previously cancelled
        if (!availableCancelledSeats.isEmpty()) {
          seatToReserve = availableCancelledSeats.poll();
        } else if (nextSmallest <= N) {
          // Priority 2: Take the next brand new seat
          seatToReserve = nextSmallest++;
        } else {
          continue; // All seats N are taken
        }

        currentReservations.add(seatToReserve);
        reservedResult.add(seatToReserve);
      } else {
        // OPERATION: CANCEL (val is the seat number)
        if (currentReservations.contains(val)) {
          currentReservations.remove(val);
          availableCancelledSeats.add(val);
        }
      }
    }

    // Convert result list to array
    return reservedResult.stream().mapToInt(Integer::intValue).toArray();
  }

  public static int[] reserveSeats3(int N, int k, int[] seat) {
    // Tracks seats that were reserved then CANCELLED (available again)
    PriorityQueue<Integer> availableCancelledSeats = new PriorityQueue<>();
    // Tracks currently reserved seats to validate cancellations
    Set<Integer> currentReservations = new HashSet<>();

    // Pointer for the next never-before-reserved seat
    int nextSmallest = 1;

    List<Integer> reservedResult = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      int val = seat[i];

      if (val == 0) {
        // OPERATION: RESERVE
        int seatToReserve;
        // Priority 1: Take the smallest seat that was previously cancelled
        if (!availableCancelledSeats.isEmpty()) {
          seatToReserve = availableCancelledSeats.poll();
        } else if (nextSmallest <= N) {
          // Priority 2: Take the next brand new seat
          seatToReserve = nextSmallest++;
        } else {
          continue; // All seats N are taken
        }

        currentReservations.add(seatToReserve);
        reservedResult.add(seatToReserve);
      } else {
        // OPERATION: CANCEL (val is the seat number)
        if (currentReservations.contains(val)) {
          currentReservations.remove(val);
          availableCancelledSeats.add(val);
        }
      }
    }

    // Convert result list to array
    return reservedResult.stream().mapToInt(Integer::intValue).toArray();
  }
}
