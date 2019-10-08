package com.fcgl.madrid.points.dataModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "trophy")
public class Trophy extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfPoints;
    private String imageFileLocation;
    private String description;
    private int actionCount;
    private String emojiName;

    @OneToOne
    @JoinColumn(name = "trophy_action_id")
    @JsonBackReference
    private Action action;

    public Trophy() {

    }

    public Trophy(int numberOfPoints, String imageFileLocation, String description, Action action, int actionCount, String emojiName) {
        this.numberOfPoints = numberOfPoints;
        this.imageFileLocation = imageFileLocation;
        this.description = description;

        this.action = action;
        this.actionCount = actionCount;
        this.emojiName = emojiName;
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

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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

        return this.action == other.action;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // FIXME
    }

    @Override
    public String toString() {
        return "Trophy: " + description;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    public String getEmojiName() {
        return emojiName;
    }

    public void setEmojiName(String emojiName) {
        this.emojiName = emojiName;
    }
}
