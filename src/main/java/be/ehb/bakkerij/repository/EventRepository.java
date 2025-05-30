// src/main/java/be/ehb/bakkerij/repository/EventRepository.java
package be.ehb.bakkerij.repository;

import be.ehb.bakkerij.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findTop10ByOrderByTijdstipDesc();

}
