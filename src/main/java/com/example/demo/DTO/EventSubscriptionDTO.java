package com.example.demo.DTO;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.EventSubscription;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventSubscriptionDTO {

    private Integer id;
    private String email;
    private Event event;
    private LocalDateTime dateTime;

    public static EventSubscriptionDTO eventSubscriptionDTO(EventSubscription eventSubscription) {
        return EventSubscriptionDTO.builder()
                .id(eventSubscription.getId())
                .email(eventSubscription.getEmail())
                .event(eventSubscription.getEvent())
                .dateTime(eventSubscription.getDateTime())
                .build();
    }

    public static List<EventSubscriptionDTO> subscriptionDTOList(List<EventSubscription> eventSubscriptions) {
        List<EventSubscriptionDTO> eventSubscriptionDTOS = new ArrayList<>();
        for (EventSubscription eventSubscription: eventSubscriptions) {
            eventSubscriptionDTOS.add(eventSubscriptionDTO(eventSubscription));
        }
        return eventSubscriptionDTOS;
    }
}
