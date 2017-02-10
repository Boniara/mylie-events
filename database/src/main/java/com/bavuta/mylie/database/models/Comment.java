package com.bavuta.mylie.database.models;

/**
 * Created by bogdan on 2/7/2017.
 */
public class Comment extends AbstractModel {

    private String comment;
    private Integer likes;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
