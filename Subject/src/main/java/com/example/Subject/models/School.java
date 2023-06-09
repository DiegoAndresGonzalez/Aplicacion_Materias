package com.example.Subject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school")
@Data
public
class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;

    private
    String name;
}
