package be.ehb.bakkerij.controller;

import be.ehb.bakkerij.model.Event;
import be.ehb.bakkerij.model.Location;
import be.ehb.bakkerij.repository.EventRepository;
import be.ehb.bakkerij.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("events", eventRepository.findTop10ByOrderByTijdstipDesc());
        return "index";
    }

    @GetMapping("/new")
    public String showNewEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locaties", locationRepository.findAll());
        return "new";
    }

    @PostMapping("/new")
    public String submitNewEvent(@Valid @ModelAttribute("event") Event event,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("locaties", locationRepository.findAll());
            return "new";
        }
        eventRepository.save(event);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String showEventDetails(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ongeldig ID: " + id));
        model.addAttribute("event", event);
        return "details";
    }
}
