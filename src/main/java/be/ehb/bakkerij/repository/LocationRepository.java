package be.ehb.bakkerij.repository;

import be.ehb.bakkerij.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
