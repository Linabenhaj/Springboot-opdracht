package be.ehb.bakkerij.controller;

import be.ehb.bakkerij.model.Event;
import be.ehb.bakkerij.repository.EventRepository;
import be.ehb.bakkerij.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
public class EventController {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public EventController(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        List<Event> laatsteEvents = eventRepository.findTop10ByOrderByTijdstipDesc();
        model.addAttribute("events", laatsteEvents);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locaties", locationRepository.findAll());
        return "new";
    }

    @PostMapping("/save")
    public String saveEvent(@Valid @ModelAttribute Event event,
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
    public String showDetails(@PathVariable("id") Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            return "redirect:/";
        }
        model.addAttribute("event", event);
        return "details";
    }
}
