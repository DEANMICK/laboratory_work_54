package com.example.demo.Controller;

import com.example.demo.DTO.EventDTO;
import com.example.demo.Service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class EventController {
    private final EventService eventService;

    @PostMapping("/addEvent")
    public String addEvent(@RequestParam("title") String title, @RequestParam("description") String description) {
        return eventService.addEvent(title, description);
    }

    @GetMapping("/events")
    public List<EventDTO> getAllEvent() {
        return eventService.getAllEvents();
    }
}
