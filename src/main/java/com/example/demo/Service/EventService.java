package com.example.demo.Service;

import com.example.demo.DTO.EventDTO;
import com.example.demo.Entity.Event;
import com.example.demo.Repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public String addEvent(String title, String description) {
        Event event = Event.builder()
                .id(eventRepository.findAll().size() + 1)
                .title(title)
                .description(description)
                .dateTime(LocalDateTime.now())
                .build();
        eventRepository.save(event);
        return "Event is add success";
    }

    public List<EventDTO> getAllEvents() {
        return EventDTO.dtoList(eventRepository.findAll());
    }
}
