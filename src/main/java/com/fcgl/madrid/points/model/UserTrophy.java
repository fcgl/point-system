package com.fcgl.madrid.points.model;

import javax.persistence.*;

@Entity
@Table(name = "user_trophy")
public class UserTrophy extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_trophy_id")
    private Trophy trophy;

    private int count;

    public UserTrophy() {

    }

    public UserTrophy(Long userId, Trophy trophy, int count) {
        this.userId = userId;
        this.trophy = trophy;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
