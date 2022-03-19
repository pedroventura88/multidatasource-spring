package com.ventura.multidatasource.core.preferences;

import org.springframework.http.ResponseEntity;

public interface UserPreferencesService {
    ResponseEntity<Void> createPreference(UserPreference userPreference);
}
