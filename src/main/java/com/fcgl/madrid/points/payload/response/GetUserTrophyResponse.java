package com.fcgl.madrid.points.payload.response;

import com.fcgl.madrid.points.dataModel.UserTrophy;
import com.fcgl.madrid.points.payload.InternalStatus;

import java.util.List;



public class GetUserTrophyResponse {
    private InternalStatus status;
    private List<UserTrophy> userTrophies;

    public GetUserTrophyResponse(InternalStatus status, List<UserTrophy> userTrophies) {
        this.status = status;
        this.userTrophies = userTrophies;
    }

    public InternalStatus getStatus() {
        return this.status;
    }

    public List<UserTrophy> getUserTrophies() {
      return this.userTrophies;
    }

    public void setStatus(InternalStatus status) {
        this.status = status;
    }

    public void setUserTrophies(List<UserTrophy> userTrophies) {
      this.userTrophies = userTrophies;
    }
}
