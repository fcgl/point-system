package com.fcgl.madrid.points.model;

import javax.persistence.*;

@Entity
@Table(name = "user_point")
public class UserPoint extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long userId;

    private int totalPoints; // TODO: do we need history of points?
    private int tournamentPoints;

    public UserPoint() {

    }

    public UserPoint(Long userId, int totalPoints, int tournamentPoints) {
        this.userId = userId;
        this.totalPoints = totalPoints;
        this.tournamentPoints = tournamentPoints;
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

    @Override
    public java.lang.String toString() {
        return "UserPoint{" +
                "id=" + id +
                ", userId=" + userId +
                ", totalPoints=" + totalPoints +
                ", tournamentPoints=" + tournamentPoints +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        UserPoint userPoint = (UserPoint) object;

        if (totalPoints != userPoint.totalPoints) return false;
        if (tournamentPoints != userPoint.tournamentPoints) return false;
        if (id != null ? !id.equals(userPoint.id) : userPoint.id != null) return false;
        return userId != null ? userId.equals(userPoint.userId) : userPoint.userId == null;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + totalPoints;
        result = 31 * result + tournamentPoints;
        return result;
    }
}
