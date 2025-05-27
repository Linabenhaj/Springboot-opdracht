package be.ehb.bakkerij.controller;

import be.ehb.bakkerij.model.Event;
import be.ehb.bakkerij.model.Location;
import be.ehb.bakkerij.repository.EventRepository;
import be.ehb.bakkerij.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public String showEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locations", locationRepository.findAll());
        return "event-form";
    }

    @PostMapping
    public String submitEventForm(@ModelAttribute @Valid Event event) {
        eventRepository.save(event);
        return "redirect:/events";
    }

}
