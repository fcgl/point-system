package com.fcgl.madrid.points.dataModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "action")
public class Action extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;
    private Integer points;

    @OneToMany(mappedBy = "action")
    private List<UserPointHistory> userPointHistories;

    public Action() {

    }

    public Action(PointType pointType, int points) {
        this.description = pointType.getDescription();
        this.type = pointType.getType();
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
