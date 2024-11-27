package full.stack.parksphere.repository;

import full.stack.parksphere.model.Booking;
import full.stack.parksphere.model.ParkingSpot;
import full.stack.parksphere.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Find bookings by user
    List<Booking> findByUser(AppUser user);

    // Find bookings for a specific parking spot
    List<Booking> findByParkingSpot(ParkingSpot parkingSpot);

    // Find bookings within a specific time range
    List<Booking> findByBookingStartBetween(LocalDateTime start, LocalDateTime end);
}
