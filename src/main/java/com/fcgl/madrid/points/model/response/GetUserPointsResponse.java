package com.fcgl.madrid.points.model.response;

import com.fcgl.madrid.points.model.UserPoint;
import com.fcgl.madrid.points.model.InternalStatus;


public class GetUserPointsResponse {
    private InternalStatus status;
    private UserPoint userPoint;

    public GetUserPointsResponse(InternalStatus status, UserPoint userPoint) {
        this.status = status;
        this.userPoint = userPoint;
    }

    public InternalStatus getStatus() {
        return this.status;
    }

    public UserPoint getUserPoint() {
        return this.userPoint;
    }

    public void setStatus(InternalStatus status) {
        this.status = status;
    }



    public void setUserPoint(UserPoint userPoint) {
        this.userPoint = userPoint;
    }
}
