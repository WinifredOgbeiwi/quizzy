package com.winningwithwynny.quizzy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Size(min = 6)
    private String password;

    private String institution;

    private int semester;

    private String picture;

    public User(String username,String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String institution, int semester, String picture) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.institution = institution;
        this.semester = semester;
        this.picture = picture;
    }
}