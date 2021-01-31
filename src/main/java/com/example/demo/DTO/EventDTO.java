package com.example.demo.DTO;

import com.example.demo.Entity.Event;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventDTO {

    private Integer id;
    private LocalDateTime dateTime;
    private String title;
    private String description;

    public static EventDTO eventDTO(Event event) {
        return EventDTO.builder()
                .id(event.getId())
                .dateTime(event.getDateTime())
                .title(event.getTitle())
                .description(event.getDescription())
                .build();
    }

    public static List<EventDTO> dtoList(List<Event> events) {
        List<EventDTO> eventDTOS = new ArrayList<>();
        for (Event event: events) {
            eventDTOS.add(eventDTO(event));
        }
        return eventDTOS;
    }
}
