package com.fcgl.madrid.points.payload.request;

import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;

public class PostUserAction {
    @NotNull
    private Long userID;
    @NotNull
    private Long actionID;
    @NotNull
    private String description;

    public PostUserAction(Long userID, Long actionID, String description) {
        this.userID = userID;
        this.actionID = actionID;
        this.description = description;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getActionID() {
        return actionID;
    }

    public void setActionID(Long actionID) {
        this.actionID = actionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
