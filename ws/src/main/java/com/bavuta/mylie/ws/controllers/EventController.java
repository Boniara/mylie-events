package com.bavuta.mylie.ws.controllers;

import com.bavuta.mylie.database.models.Event;
import com.bavuta.mylie.database.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bogdan on 1/9/2017.
 */

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Event> getAllEvents() {
        return eventService.getAllEventes();
    }
}
