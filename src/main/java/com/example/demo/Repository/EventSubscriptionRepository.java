package com.example.demo.Repository;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.EventSubscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSubscriptionRepository extends CrudRepository<EventSubscription, Integer> {
    List<EventSubscription> findAll();
    EventSubscription findEventSubscriptionById(Integer id);
    List<EventSubscription> findEventSubscriptionByEmail(String email);
    boolean existsEventSubscriptionByEvent(Event event);
    boolean existsEventSubscriptionByIdAndEmail(Integer id, String email);
    void deleteEventSubscriptionByIdAndEmail(Integer id, String email);
}
