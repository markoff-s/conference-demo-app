package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
public class Session extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "session_id")
    private Long id;

    @Column(name = "session_name", nullable = false, length = 80)
    private String name;

    @Column(name = "session_description", nullable = false, length = 1024)
    private String description;

    @Column(name = "session_length", nullable = false)
    private Integer length;

    @ManyToMany //fetch = FetchType.LAZY
    @JoinTable(
            name = "session_speakers",
            joinColumns = {@JoinColumn(name = "session_id")},
            inverseJoinColumns = {@JoinColumn(name = "speaker_id")})
    private List<Speaker> speakers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
