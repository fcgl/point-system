package com.fcgl.madrid.points.model;

import javax.persistence.*;

@Entity
@Table(name = "action")
public class Action extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int points;

    public Action() {

    }

    public Action(String description, int points) {
        this.description = description;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Action other = (Action) obj;
        if (!(this.id.equals(other.id))) {
            return false;
        }

        return this.description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // FIXME
    }

    @Override
    public String toString() {
        return "Action: " + description;
    }
}
