package com.fcgl.madrid.points.model.response;

import com.fcgl.madrid.points.model.UserTrophy;
import com.fcgl.madrid.points.model.InternalStatus;

import java.util.List;



public class GetUserTrophyResponse {
    private InternalStatus status;
    private UserTrophy userTrophy;
    private List<UserTrophy> userTrophies;

    public GetUserTrophyResponse(InternalStatus status, UserTrophy userTrophy, List<UserTrophy> userTrophies) {
        this.status = status;
        this.userTrophy = userTrophy;
        this.userTrophies = userTrophies;
    }

    public InternalStatus getStatus() {
        return this.status;
    }

    public UserTrophy geUserTrophy() {
        return this.userTrophy;
    }

    public List<UserTrophy> getUserTrophies() {
      return this.userTrophies;
    }

    public void setStatus(InternalStatus status) {
        this.status = status;
    }

    public void setTrophy(UserTrophy userTrophy) {
        this.userTrophy = userTrophy;
    }

    public void setUserTrophies(List<UserTrophy> userTrophies) {
      this.userTrophies = userTrophies;
    }
}
