package full.stack.parksphere.restcontrollers;

import full.stack.parksphere.model.Booking;
import full.stack.parksphere.model.AppUser;
import full.stack.parksphere.model.ParkingSpot;
import full.stack.parksphere.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        AppUser user = new AppUser();
        user.setId(userId); // Assume AppUser is retrieved elsewhere
        return bookingService.getBookingsByUser(user);
    }

    @GetMapping("/parking-spot/{spotId}")
    public List<Booking> getBookingsByParkingSpot(@PathVariable Long spotId) {
        ParkingSpot spot = new ParkingSpot();
        spot.setId(spotId); // Assume ParkingSpot is retrieved elsewhere
        return bookingService.getBookingsByParkingSpot(spot);
    }

    @GetMapping("/range")
    public List<Booking> getBookingsWithinRange(
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end) {
        return bookingService.getBookingsWithinRange(start, end);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
