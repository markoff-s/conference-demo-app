package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.services.SessionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(EndPoints.API + EndPoints.v1 + EndPoints.Sessions)
public class SessionsController {

    private final SessionsService sessionsService;

    public SessionsController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessions = sessionsService.getAllSessions();

        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {

        // this works fine without any annotations
         Session session = sessionsService.getSessionById(id);

        // this only works with @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) on the BaseEntity
//        Session session = sessionRepository.getOne(id);

        if (session == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found");

        return new ResponseEntity<>(session, HttpStatus.OK);
    }
}
