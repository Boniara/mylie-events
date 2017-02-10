package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bogdan on 1/10/2017.
 */
public interface EventImageMapper {

    void createImage(@Param("image") Image image, @Param("eventId") Long id);
    List<Image> getAllImages();
    List<Image> getAllImagesByEventId(Long userId);
    Image getImageById(Long id);
    void deleteImage(Long id);
}
