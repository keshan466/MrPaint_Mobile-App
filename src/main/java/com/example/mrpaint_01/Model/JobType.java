package com.example.mrpaint_01.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobType {
    @SerializedName("jobID")
    @Expose
    private Integer jobID;
    @SerializedName("jobType")
    @Expose
    private String jobType;

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

}
