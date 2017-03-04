package com.jarvisventures.homeline.subproject.subprojectdetail;

import com.jarvisventures.homeline.subproject.Subproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class CurrentSubProjects {

    public static Subproject currentSubProject;

    public static void setCurrentSubProject(Subproject s){
        currentSubProject = s;
    }

    public static Subproject getCurrentSubProject() { return currentSubProject; }


}
