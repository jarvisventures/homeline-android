package com.jarvisventures.homeline.project;

import com.jarvisventures.homeline.subproject.Subproject;

import java.util.ArrayList;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class CurrentProject {


    public static Project currentProject;


    public static void setCurrentProject(Project p){
        currentProject = p;
    }


    public static Project getCurrentProject() {
        return currentProject;
    }



}
