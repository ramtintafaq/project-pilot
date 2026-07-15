package it.tafaq.project_pilot.user.domain;

import jakarta.persistence.*;

import lombok.AccessLevel;

import lombok.Getter;

import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity

@Table(

        name = "users",

        uniqueConstraints = {

                @UniqueConstraint(

                        name = "uk_users_email",

                        columnNames = "email"

                )

        }

)

@Getter

@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)

    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)

    private String lastName;

    @Column(name = "email", nullable = false, length = 255)

    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)

    private String passwordHash;

    @Enumerated(EnumType.STRING)

    @Column(name = "status", nullable = false, length = 30)

    private UserStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)

    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)

    private Instant updatedAt;

    @Column(name = "deleted_at")

    private Instant deletedAt;

    @Column(name = "deleted_by")

    private Long deletedBy;

}
