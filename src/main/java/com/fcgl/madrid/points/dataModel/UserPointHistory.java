package com.fcgl.madrid.points.dataModel;

import javax.persistence.*;

@Entity
public class UserPointHistory extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @ManyToOne
    @JoinColumn
    private Action action;
    private String description;

    public UserPointHistory() {

    }

    public UserPointHistory(Long userId, Action action, String description) {
        this.userId = userId;
        this.action = action;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
