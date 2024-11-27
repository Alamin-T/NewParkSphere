package full.stack.parksphere.repository;

import full.stack.parksphere.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    // Custom query method to find all available parking spots
    List<ParkingSpot> findByIsAvailable(Boolean isAvailable);
}
