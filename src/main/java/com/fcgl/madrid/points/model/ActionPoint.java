package com.fcgl.madrid.points.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import java.time.Instant;

@Entity
@Table(name = "action")
public class ActionPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actionId", referencedColumnName = "id")
    private Action action;
    private Integer pointValue;
    private Long createdAt;
    private Long updatedAt;

    public ActionPoint() {

    }

    public ActionPoint(Action action, Integer pointValue) {
        this.action = action;
        this.pointValue = pointValue;
        this.createdAt = Instant.now().toEpochMilli();


    }

    public Long getId() {
        return id;
    }

    public Integer getPointValue() {
        return pointValue;
    }

    public void setPointValue(Integer pointValue) {
        this.pointValue = pointValue;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
