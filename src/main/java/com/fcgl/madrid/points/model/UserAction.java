package com.fcgl.madrid.points.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_action")
public class UserAction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_action_id")
    private Action action;

    // The number of times the action has happened
    private int count;

    // TODO: add @PrePersist & @PreUpdate
    private Long createdAt;
    private Long updatedAt;

    public UserAction() {

    }

    public UserAction(Long userId, Action action, int count) {
        this.userId = userId;
        this.action = action;
        this.count = count;

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

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

        final UserAction other = (UserAction) obj;
        if (!(this.id.equals(other.id))) {
            return false;
        }

        if (!(this.userId.equals(other.userId))) {
            return false;
        }

        if (!(this.action.equals(other.action))) {
            return false;
        }

        if (!(this.count == other.count)) {
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
        return action + " for user: " + userId;
    }
}
