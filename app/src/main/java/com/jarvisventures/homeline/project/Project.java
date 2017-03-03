package com.jarvisventures.homeline.project;

import com.jarvisventures.homeline.subproject.Subproject;

import java.util.List;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class Project {

    List<Subproject> subprojectList;
    String name;
    String description;
    String start_date;
    String end_date;
    Integer budget;

    public Project(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
