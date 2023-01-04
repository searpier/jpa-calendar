package com.spring.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

}
