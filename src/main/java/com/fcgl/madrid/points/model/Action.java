package com.fcgl.madrid.points.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "actions")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    // TODO: add @PrePersist & @PreUpdate
    private Long createdAt;
    private Long updatedAt;

    public Action() {

    }

    public Action(String description) {
        this.description = description;

        this.createdAt = Instant.now().toEpochMilli();
        this.updatedAt = createdAt;
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

        final Action other = (Action) obj;
        if (!(this.id.equals(other.id))) {
            return false;
        }

        if (!(this.description.equals(other.description))) {
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
        return "Action: " + description;
    }
}
