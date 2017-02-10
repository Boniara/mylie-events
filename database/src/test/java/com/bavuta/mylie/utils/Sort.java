package com.bavuta.mylie.utils;

import com.bavuta.mylie.database.models.AbstractModel;

import java.util.Comparator;

/**
 * Created by bogdan on 2/7/2017.
 */
public class Sort implements Comparator<AbstractModel> {

    @Override
    public int compare(AbstractModel o1, AbstractModel o2) {
        return (int)(o1.getId() - o2.getId());
    }
}
