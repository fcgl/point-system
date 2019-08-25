package com.fcgl.madrid.points.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionPointTest {

    private ActionPoint actionPoint;
    @Before
    public void setUp() throws Exception {
        Action action = new Action("testing action");
        actionPoint = new ActionPoint(action, new Integer(50));
    }

    @Test
    public void getPointValue() {
        assertEquals(actionPoint.getPointValue(), new Integer(50));
    }

    @Test
    public void setPointValue() {
        actionPoint.setPointValue(new Integer(40));
        assertEquals(actionPoint.getPointValue(), new Integer(40));

    }
}
