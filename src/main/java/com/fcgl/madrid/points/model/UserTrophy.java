package com.fcgl.madrid.points.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_trophy")
public class UserTrophy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_trophy_id")
    private Trophy trophy;

    // TODO: add @PrePersist & @PreUpdate
    private Long createdAt;
    private Long updatedAt;

    public UserTrophy() {

    }

    public UserTrophy(Long userId, Trophy trophy) {
        this.userId = userId;
        this.trophy = trophy;

        this.createdAt = Instant.now().toEpochMilli();
        this.updatedAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Trophy getTrophy() {
        return trophy;
    }

    public void setTrophy(Trophy trophy) {
        this.trophy = trophy;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
