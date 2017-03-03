package com.jarvisventures.homeline.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public interface FindProjectItems{

    interface OnFinishedListener {
        void onFinished(ArrayList<Project> items);
    }

    void findItems(OnFinishedListener listener, String listName);
}
