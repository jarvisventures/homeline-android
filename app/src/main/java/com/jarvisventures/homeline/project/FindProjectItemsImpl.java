package com.jarvisventures.homeline.project;

import android.view.SurfaceHolder;

import com.jarvisventures.homeline.network.NetworkServiceInterface;

import retrofit.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Callback;
import retrofit.Call;
import retrofit.Retrofit;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class FindProjectItemsImpl implements FindProjectItems {

    ArrayList<Project> list = new ArrayList<>();
    List<Project> projectList;

    @Override
    public void findItems(OnFinishedListener listener, String listName) {
        list.clear();
        getProductsFromApi(listener);

    }

    private ArrayList<Project> createArrayList() {
        return list;
    }

    private void getProductsFromApi(final FindProjectItems.OnFinishedListener listener) {

//        NetworkServiceInterface productService = NetworkServiceInterface.retrofit.create(NetworkServiceInterface.class);
//        Call<List<Project>> call2 = productService.getProjects();
//
//        call2.enqueue(new Callback<List<Project>>() {
//            @Override
//            public void onResponse(Response<List<Project>> response, Retrofit retrofit) {
//                // Get Response Body
//                projectList = response.body();
//
//                //Convert to ArrayList
//
//
//                listener.onFinished(createArrayList());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                System.out.println("FAILED");
//            }
//        });


        for (int i = 0; i < 5; i++){

            Project p = new Project("My Project "+i+1);
            list.add(p);
        }

        listener.onFinished(createArrayList());

    }
}
