package full.stack.parksphere.restcontrollers;

import full.stack.parksphere.model.ParkingSpot;
import full.stack.parksphere.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-spots")
public class ParkingSpotController {
    @Autowired
    private ParkingSpotService parkingSpotService;

    @GetMapping
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotService.getAllParkingSpots();
    }

    @GetMapping("/{id}")
    public ParkingSpot getParkingSpotById(@PathVariable Long id) {
        return parkingSpotService.getParkingSpotById(id)
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));
    }

    @GetMapping("/available")
    public List<ParkingSpot> getAvailableParkingSpots() {
        return parkingSpotService.getAvailableParkingSpots();
    }

    @PostMapping
    public ParkingSpot createParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        return parkingSpotService.createParkingSpot(parkingSpot);
    }

    @PutMapping("/{id}")
    public ParkingSpot updateParkingSpot(@PathVariable Long id, @RequestBody ParkingSpot updatedSpot) {
        return parkingSpotService.updateParkingSpot(id, updatedSpot);
    }

    @DeleteMapping("/{id}")
    public void deleteParkingSpot(@PathVariable Long id) {
        parkingSpotService.deleteParkingSpot(id);
    }
}
