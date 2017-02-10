package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.Event;

import java.util.List;

/**
 * Created by bogdan on 11/7/2016.
 */
public interface EventMapper {

    Event getEventById(Long id);
    List<Event> getAllEvents();
    Long createEvent(Event event);
    void updateEvent(Event event);
    void deleteEventById(Long id);
}
