package full.stack.parksphere.service;

import full.stack.parksphere.model.ParkingSpot;
import full.stack.parksphere.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpot> getParkingSpotById(Long id) {
        return parkingSpotRepository.findById(id);
    }

    public List<ParkingSpot> getAvailableParkingSpots() {
        return parkingSpotRepository.findByIsAvailable(true);
    }

    public ParkingSpot updateParkingSpot(Long id, ParkingSpot updatedSpot) {
        return parkingSpotRepository.findById(id)
                .map(spot -> {
                    spot.setLocation(updatedSpot.getLocation());
                    spot.setIsAvailable(updatedSpot.getIsAvailable());
                    return parkingSpotRepository.save(spot);
                })
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));
    }

    public void deleteParkingSpot(Long id) {
        parkingSpotRepository.deleteById(id);
    }
}
