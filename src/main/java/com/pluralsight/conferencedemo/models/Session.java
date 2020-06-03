package com.pluralsight.conferencedemo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
@Data
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
}
