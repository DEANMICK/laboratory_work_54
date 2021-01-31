package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "subscription")
public class EventSubscription {

    @Id
    private Integer id;
    private Event event;
    private String email;
    private LocalDateTime dateTime;
}
