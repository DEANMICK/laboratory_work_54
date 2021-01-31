package com.example.demo.Repository;

import com.example.demo.Entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findAll();
    Event findEventById(Integer id);
    Event findEventByTitle(String title);
    boolean existsEventById(Integer id);
}
