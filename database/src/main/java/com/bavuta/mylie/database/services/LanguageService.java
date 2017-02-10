package com.bavuta.mylie.database.services;

import com.bavuta.mylie.database.dao.LanguageMapper;
import com.bavuta.mylie.database.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bogdan on 12/20/2016.
 */

@Service
public class LanguageService {

    @Autowired
    private LanguageMapper languageMapper;

    @Transactional(rollbackFor = Exception.class)
    public Language getLanguageById(Long id) {
        Language language = languageMapper.getLanguageById(id);
        return language;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Language> getAllLanguages() {
        List<Language> languageList = languageMapper.getAllLanguages();
        return languageList;
    }
}
