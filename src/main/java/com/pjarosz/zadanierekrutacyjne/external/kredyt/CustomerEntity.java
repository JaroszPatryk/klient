package com.pjarosz.zadanierekrutacyjne.external.kredyt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 28)
    private String name;
    @Column(nullable = false, unique = true, length = 28)
    private String surname;
    @Column(nullable = false, unique = true, length = 15)
    private Long peselNumber;
}
