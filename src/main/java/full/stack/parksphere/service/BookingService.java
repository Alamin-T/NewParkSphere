package full.stack.parksphere.service;

import full.stack.parksphere.model.AppUser;
import full.stack.parksphere.model.Booking;
import full.stack.parksphere.model.ParkingSpot;
import full.stack.parksphere.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByUser(AppUser user) {
        return bookingRepository.findByUser(user);
    }

    public List<Booking> getBookingsByParkingSpot(ParkingSpot parkingSpot) {
        return bookingRepository.findByParkingSpot(parkingSpot);
    }

    public List<Booking> getBookingsWithinRange(LocalDateTime start, LocalDateTime end) {
        return bookingRepository.findByBookingStartBetween(start, end);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setUser(updatedBooking.getUser());
                    booking.setParkingSpot(updatedBooking.getParkingSpot());
                    booking.setBookingStart(updatedBooking.getBookingStart());
                    booking.setBookingEnd(updatedBooking.getBookingEnd());
                    return bookingRepository.save(booking);
                })
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
