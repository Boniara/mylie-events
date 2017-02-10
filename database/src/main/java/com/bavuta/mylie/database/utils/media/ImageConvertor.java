package com.bavuta.mylie.database.utils.media;

import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by bogdan on 1/10/2017.
 */
public class ImageConvertor implements MediaConvertor {

    private InputStream inputStream;

    @Override
    public byte[] buildByteArrayFromFile(String path) {
        return imageToByteArray(path);
    }

    private byte[] imageToByteArray(String path) {

        byte[] image = null;

        BufferedImage bufferedImage = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            inputStream = ImageConvertor.class.getClass().getResourceAsStream(path);
            bufferedImage = ImageIO.read(inputStream);
            byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, FilenameUtils.getExtension(path), byteArrayOutputStream);
            image = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}
