package be.ehb.bakkerij.controller;

import be.ehb.bakkerij.model.Location;
import be.ehb.bakkerij.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "*")
public class LocationController {

    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

}
