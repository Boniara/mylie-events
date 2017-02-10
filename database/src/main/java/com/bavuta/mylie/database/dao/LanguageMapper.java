package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.Language;

import java.util.List;

/**
 * Created by bogdan on 11/13/2016.
 */
public interface LanguageMapper {

    Language getLanguageById(Long id);
    List<Language> getAllLanguages();
}
