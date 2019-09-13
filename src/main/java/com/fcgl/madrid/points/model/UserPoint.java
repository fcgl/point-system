package com.fcgl.madrid.points.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_point")
public class UserPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long userId;

    private int totalPoints; // TODO: do we need history of points?
    private int tournamentPoints;

    // TODO: add @PrePersist & @PreUpdate
    private Long createdAt;
    private Long updatedAt;

    public UserPoint() {

    }

    public UserPoint(Long userId, int totalPoints, int tournamentPoints) {
        this.userId = userId;
        this.totalPoints = totalPoints;
        this.totalPoints = tournamentPoints;

        this.createdAt = Instant.now().toEpochMilli();
        this.updatedAt = this.createdAt;
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

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTournamentPoints() {
        return tournamentPoints;
    }

    public void setTournamentPoints(int tournamentPoints) {
        this.tournamentPoints = tournamentPoints;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final UserPoint other = (UserPoint) obj;
        if (!(this.id.equals(other.id))) {
            return false;
        }

        if (!(this.userId.equals(other.userId))) {
            return false;
        }

        if (!(this.totalPoints == other.totalPoints)) {
            return false;
        }

        if (!(this.tournamentPoints == other.tournamentPoints)) {
            return false;
        }

        if (!(this.createdAt.equals(other.createdAt))) {
            return false;
        }

        return (this.updatedAt.equals(other.updatedAt));
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // FIXME
    }

    @Override
    public String toString() {
        return "User (" + userId + ") has " + totalPoints + " points.";
    }
}
