package be.ehb.bakkerij.controller;

import be.ehb.bakkerij.model.Event;
import be.ehb.bakkerij.model.Location;
import be.ehb.bakkerij.repository.EventRepository;
import be.ehb.bakkerij.repository.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventController(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/")
    public String showEvents(Model model) {
        model.addAttribute("events", eventRepository.findTop10ByOrderByTijdstipDesc());
        return "index";
    }

    @GetMapping("/new")
    public String newEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locations", locationRepository.findAll());
        return "new";
    }

    @PostMapping("/events")
    public String saveEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + id));
        model.addAttribute("event", event);
        return "details";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
