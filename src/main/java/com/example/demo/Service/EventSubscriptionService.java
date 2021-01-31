package com.example.demo.Service;

import com.example.demo.DTO.EventDTO;
import com.example.demo.DTO.EventSubscriptionDTO;
import com.example.demo.Entity.Event;
import com.example.demo.Entity.EventSubscription;
import com.example.demo.Repository.EventRepository;
import com.example.demo.Repository.EventSubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class EventSubscriptionService {
    private final EventSubscriptionRepository eventSubscriptionRepository;
    private final EventRepository eventRepository;

    public String subscribesInEvent(Event event, String email) {
        String message;
        Event events = eventRepository.findEventById(event.getId());
        if (eventDateIsInFuture(events) && eventRepository.existsEventById(event.getId())) {
            if (!eventSubscriptionRepository.existsEventSubscriptionByEvent(events)) {
                EventSubscription eventSubscription = EventSubscription.builder()
                        .id(eventRepository.findAll().size() + 1)
                        .dateTime(LocalDateTime.now())
                        .event(events)
                        .email(email)
                        .build();
                eventSubscriptionRepository.save(eventSubscription);
                message = "Вы успешно подписались на событие. Его id-" + events.getId();
            } else {
                message = "Вы подписаны на событие. Его id-" + events.getId();
            }
        } else if (!eventRepository.existsEventById(events.getId())) {
            message = "События с таким id нет";
        } else {
            message = "Событие уже прошло";
        }
        return message;
    }

    public String deleteSubscription(Integer id, String email) {
        String message;
        if (eventSubscriptionRepository.existsEventSubscriptionByIdAndEmail(id, email)) {
            eventSubscriptionRepository.deleteEventSubscriptionByIdAndEmail(id, email);
            message = "Вы успешно удалили подписку. id=" + id + "email=" + email;
        } else {
            message = "Такой id или email не найден";
        }
        return message;
    }

    public List<EventSubscriptionDTO> getEventSubscriptionByEmail(String email) {
        return EventSubscriptionDTO.subscriptionDTOList(eventSubscriptionRepository.findEventSubscriptionByEmail(email));
    }

    public List<EventSubscriptionDTO> getAllEventSubscriptionDTO() {
        return EventSubscriptionDTO.subscriptionDTOList(eventSubscriptionRepository.findAll());
    }

    private boolean eventDateIsInFuture(Event event) {
        return event.getDateTime().isBefore(LocalDateTime.now());
    }
}
