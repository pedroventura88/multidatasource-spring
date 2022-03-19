package com.ventura.multidatasource.core.preferences.impl;

import com.ventura.multidatasource.core.preferences.UserPreference;
import com.ventura.multidatasource.core.preferences.UserPreferencesRepository;
import com.ventura.multidatasource.core.preferences.UserPreferencesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceServiceImpl implements UserPreferencesService {

    private UserPreferencesRepository repository;

    public UserPreferenceServiceImpl(UserPreferencesRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Void> createPreference(UserPreference userPreference) {
        UserPreference preferences = UserPreference.builder()
                .optionName(userPreference.getOptionName())
                .username(userPreference.getUsername())
                .build();
        repository.save(preferences);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
