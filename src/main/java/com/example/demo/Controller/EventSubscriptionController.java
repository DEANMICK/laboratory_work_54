package com.example.demo.Controller;

import com.example.demo.DTO.EventSubscriptionDTO;
import com.example.demo.Entity.Event;
import com.example.demo.Service.EventSubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class EventSubscriptionController {
    private final EventSubscriptionService eventSubscriptionService;

    @PostMapping("/addSubscriber/{event}")
    public String addSubscriber(@RequestParam("event") Event event, @RequestParam("email") String email) {
        return eventSubscriptionService.subscribesInEvent(event, email);
    }

    @GetMapping("/subscriptions")
    public List<EventSubscriptionDTO> getSubscriberByEmail(@RequestParam("email") String email) {
        return eventSubscriptionService.getEventSubscriptionByEmail(email);
    }

    @GetMapping("/getAllSubscriptions")
    public List<EventSubscriptionDTO> getAll() {
        return eventSubscriptionService.getAllEventSubscriptionDTO();
    }
}
