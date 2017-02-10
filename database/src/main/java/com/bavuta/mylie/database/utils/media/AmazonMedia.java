package com.bavuta.mylie.database.utils.media;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

/**
 * Created by bogdan on 2/7/2017.
 */
public class AmazonMedia {

    public String uploadFileToAmazon(File file) {
        String bucketName = file.getName();
        String keyName = file.getName();
        AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
        s3client.putObject(new PutObjectRequest(bucketName, keyName, file));
        return "https://" + bucketName + ".s3.amazonaws.com/" + keyName;
    }
}
