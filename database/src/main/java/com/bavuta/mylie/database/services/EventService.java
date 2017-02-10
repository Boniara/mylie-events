package com.bavuta.mylie.database.services;

import com.bavuta.mylie.database.dao.EventImageMapper;
import com.bavuta.mylie.database.dao.EventMapper;
import com.bavuta.mylie.database.models.Event;
import com.bavuta.mylie.database.models.Image;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bogdan on 12/20/2016.
 */

@Service
public class EventService {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private EventImageMapper eventImageMapper;

    @Transactional(rollbackFor = Exception.class)
    public Event createEvent(Event event) {
        eventMapper.createEvent(event);
        return event;
    }

    @Transactional(rollbackFor = Exception.class)
    public Event getEventById(Long id) {
        Event event = eventMapper.getEventById(id);
        event.setImageList(eventImageMapper.getAllImagesByEventId(id));
        return event;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Event> getAllEventes() {
        List<Event> eventList = eventMapper.getAllEvents();
        for(Event event: eventList) {
            List<Image> imageList = eventImageMapper.getAllImagesByEventId(event.getId());
            event.setImageList(imageList);
        }
        return eventList;
    }

    @Transactional(rollbackFor = Exception.class)
    public Event updateEvent(Event event) {
        eventMapper.updateEvent(event);
        Event updatingEvent = eventMapper.getEventById(event.getId());
        return updatingEvent;
    }

    @Transactional(rollbackFor = Exception.class)
    public Event deleteEventById(Long id) {
        Event event = eventMapper.getEventById(id);
        eventMapper.deleteEventById(id);
        return event;
    }
}
