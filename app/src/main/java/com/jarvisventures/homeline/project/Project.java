package com.jarvisventures.homeline.project;

import com.jarvisventures.homeline.subproject.Subproject;

import java.util.List;

/**
 * Created by klaytonerekson on 3/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("subprojects")
    @Expose
    private List<Subproject> subprojects = null;
    @SerializedName("owners")
    @Expose
    private List<Owner> owners = null;
    @SerializedName("clients")
    @Expose
    private List<Object> clients = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Subproject> getSubprojects() {
        return subprojects;
    }

    public void setSubprojects(List<Subproject> subprojects) {
        this.subprojects = subprojects;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public List<Object> getClients() {
        return clients;
    }

    public void setClients(List<Object> clients) {
        this.clients = clients;
    }
}
