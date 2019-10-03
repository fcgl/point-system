package com.fcgl.madrid.points.dataModel;

import javax.persistence.*;

@Entity
@Table(name = "user_action")
public class UserAction extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_action_id")
    private Action action;

    // The number of times the action has happened
    private int count;

    public UserAction() {

    }

    public UserAction(Long userId, Action action, int count) {
        this.userId = userId;
        this.action = action;
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

        return this.count == other.count;
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
