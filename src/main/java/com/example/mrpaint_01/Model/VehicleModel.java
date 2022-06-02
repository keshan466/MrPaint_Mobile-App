package com.example.mrpaint_01.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleModel {
    @SerializedName("ModelNumber")
    @Expose
    private String ModelNumber;
    @SerializedName("MakeID")
    @Expose
    private int MakeID;
    @SerializedName("Description")
    @Expose
    private String Description;

    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String modelNumber) {
        ModelNumber = modelNumber;
    }

    public int getMakeID() {
        return MakeID;
    }

    public void setMakeID(int makeID) {
        MakeID = makeID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
