package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book implements Serializable {
    @Id
    //default -> (strategy = GenerationType.AUTO)
    @GeneratedValue
    private Long id;

    private String author;

    private String title;

    private String genre;
}
