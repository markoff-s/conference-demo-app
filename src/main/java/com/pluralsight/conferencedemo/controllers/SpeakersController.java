package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndPoints.API + EndPoints.v1 + EndPoints.Speakers)
public class SpeakersController {

    private final SpeakerRepository speakerRepository;

    public SpeakersController(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @GetMapping
    public List<Speaker> getAllSpeakers() {
        return speakerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/{id}")
    public Speaker getSpeakerById(@PathVariable Long id) {
        return speakerRepository.findById(id).orElse(null);
    }
}
