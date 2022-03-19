package com.ventura.multidatasource.web.preferences;

import com.ventura.multidatasource.core.preferences.UserPreference;
import com.ventura.multidatasource.core.preferences.UserPreferencesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preferences")
public class UserPreferencesController {
    private UserPreferencesService service;

    public UserPreferencesController(UserPreferencesService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> savePreference(@RequestBody UserPreference preferences) {
        return service.createPreference(preferences);
    }
}
