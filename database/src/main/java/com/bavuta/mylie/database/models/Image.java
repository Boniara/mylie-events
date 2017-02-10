package com.bavuta.mylie.database.models;

import com.bavuta.mylie.database.utils.media.ImageConvertor;
import com.bavuta.mylie.database.utils.media.MediaConvertor;

/**
 * Created by bogdan on 1/10/2017.
 */
public class Image extends AbstractModel {

    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setImage(String path) {
        MediaConvertor mediaConvertor = new ImageConvertor();
        this.image = mediaConvertor.buildByteArrayFromFile(path);
    }
}
