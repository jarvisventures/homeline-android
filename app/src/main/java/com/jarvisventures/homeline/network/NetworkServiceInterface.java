package com.jarvisventures.homeline.network;

import com.jarvisventures.homeline.project.Project;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by klaytonerekson on 2/9/17.
 */

public interface NetworkServiceInterface {
    //Login and log-out calls
//    @POST("")
//    Call<Authentication> login(@Body AuthenticationRequest authenticationRequest);
//    @DELETE("")
////    Call<Empty> logout();
//
//    //registration call
//    @POST("")
////    Call<Authentication> register(@Body RegistrationRequest registrationRequest);
//
//    //get products by apiKey
//    @GET("")
//    Call<List<Product>> getProducts();

    //Get Inventory Items
    @Headers("X-Spree-Token: 1e167f9d39840bbf2f024cb586761da666174fbdf1096b19")
    @GET("projects")
    Call<List<Project>> getProjects();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.giftgenie.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();




}
