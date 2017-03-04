package com.jarvisventures.homeline.subproject;

import com.jarvisventures.homeline.project.FindProjectItems;
import com.jarvisventures.homeline.project.Project;

import java.util.ArrayList;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public interface FindSubProjects {

    interface OnFinishedListener {
        void onFinished(ArrayList<Subproject> items);
    }

    void findItems(FindSubProjects.OnFinishedListener listener, String listName);
}
