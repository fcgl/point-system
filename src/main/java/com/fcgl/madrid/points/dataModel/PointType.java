package com.fcgl.madrid.points.dataModel;

public class PointType {

    //Example Description: Willbury's Bread, 1,78 €
    public static final PointType SCANNED = new PointType("SCANNED", "%s, $s %s");
    //Example Description: Tips, Show student ID at...
    public static final PointType FORUM_POST = new PointType("FORUM POST", "%s");
    public static final PointType FORUM_COMMENT = new PointType("FORUM COMMENT", "%s");
    public static final PointType RECEIPT_UPLOAD = new PointType("RECEIPT UPLOAD", "$s");
    public static final PointType FRIEND_REFFERAL = new PointType("REFERRAL", "Thank you for the referral");

    private String type;
    private String description;

    public PointType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
