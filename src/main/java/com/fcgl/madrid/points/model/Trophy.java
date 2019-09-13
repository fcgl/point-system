package com.fcgl.madrid.points.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "trophy")
public class Trophy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfPoints;
    private String imageFileLocation;
    private String description;
    private int action_count;

    @OneToOne
    @JoinColumn(name = "trophy_action_id")
    private Action action;

    // TODO: add @PrePersist & @PreUpdate
    private Long createdAt;
    private Long updatedAt;

    public Trophy() {

    }

    public Trophy(int numberOfPoints, String imageFileLocation, String description, Action action, int action_count) {
        this.numberOfPoints = numberOfPoints;
        this.imageFileLocation = imageFileLocation;
        this.description = description;

        this.action = action;
        this.action_count = action_count;
        this.createdAt = Instant.now().toEpochMilli();
        this.updatedAt = this.createdAt;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public String getImageFileLocation() {
        return imageFileLocation;
    }

    public void setImageFileLocation(String imageFileLocation) {
        this.imageFileLocation = imageFileLocation;
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

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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

        final Trophy other = (Trophy) obj;
        if (!(this.id.equals(other.id))) {
            return false;
        }

        if (!(this.numberOfPoints == other.numberOfPoints)) {
            return false;
        }

        if (!(this.imageFileLocation.equals(other.imageFileLocation))) {
            return false;
        }

        if (!(this.description.equals(other.description))) {
            return false;
        }

        if (!(this.action == other.action)) {
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
        return "Trophy: " + description;
    }

    public int getAction_count() {
        return action_count;
    }

    public void setAction_count(int action_count) {
        this.action_count = action_count;
    }
}
