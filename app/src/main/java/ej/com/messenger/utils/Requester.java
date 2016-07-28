package ej.com.messenger.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ej.com.messenger.model.database.Pojo;
import ej.com.messenger.model.rest.ApiInterface;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by emil on 21.04.16.
 */
public class Requester {

    private static Requester requester;
    private Retrofit retrofit;
    private Gson gson;
    private ApiInterface apiInterface;
    private Pojo pojo;

    private Requester(){
        requestSetup();
    }

    public static Requester getInstance(){
        if (requester == null) {
            requester = new Requester();
        }
        return requester;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public void setApiInterface(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    private void requestSetup(){
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

}
