package com.bavuta.mylie.database.services;

import com.bavuta.mylie.database.dao.EventImageMapper;
import com.bavuta.mylie.database.models.Event;
import com.bavuta.mylie.database.models.Image;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 1/10/2017.
 */

@Service
public class EventImageService {

    @Autowired
    private EventImageMapper eventImageMapper;

    @Transactional(rollbackFor = Exception.class)
    public Image createImage(Image image, Event event) {
        eventImageMapper.createImage(image, event.getId());
        return image;
    }

    @Transactional(rollbackFor = Exception.class)
    public Image getImageById(Long id) {
        return eventImageMapper.getImageById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Image> getAllImages() {
        return eventImageMapper.getAllImages();
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Image> getAllImagesByEventId(Long id) {
        List<Image> imageList = eventImageMapper.getAllImagesByEventId(id);
        return imageList;
    }
}
