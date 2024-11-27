package full.stack.parksphere.repository;

import full.stack.parksphere.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    // Custom query method to find an AppUser by username
    Optional<AppUser> findByUsername(String username);

    // Custom query method to delete an AppUser by username
    void deleteByUsername(String username);

    // Additional methods (if needed) can be added here
}
