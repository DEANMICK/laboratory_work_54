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
@Document(collection = "events")
public class Event {

    @Id
    private Integer id;
    private LocalDateTime dateTime;
    private String title;
    private String description;
}
