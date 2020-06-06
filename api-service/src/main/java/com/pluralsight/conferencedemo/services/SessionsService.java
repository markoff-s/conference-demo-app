package com.pluralsight.conferencedemo.services;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionsService {

    private final SessionRepository sessionRepository;

    public SessionsService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Session getSessionById(Long id) {
         return sessionRepository.findById(id).orElse(null);
    }
}
