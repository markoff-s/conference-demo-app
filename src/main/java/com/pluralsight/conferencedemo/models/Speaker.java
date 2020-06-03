package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@Data
public class Speaker extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "speaker_id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "title", nullable = false, length = 40)
    private String title;

    @Column(name = "company", nullable = false, length = 50)
    private String company;

    @Column(name = "speaker_bio", nullable = false, length = 2000)
    private String bio;

    @Column(name = "speaker_photo", columnDefinition = "BLOB")
    @Lob
    private byte[] photo;

    @ManyToMany(mappedBy = "speakers") //fetch = FetchType.LAZY
    @JsonIgnore
    private List<Session> sessions;
}
