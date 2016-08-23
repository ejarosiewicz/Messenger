package ej.com.messenger.model.rest;

import ej.com.messenger.model.database.Pojo;
import ej.com.messenger.model.database.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author Emil Jarosiewicz on 2015-05-11.
 */
public interface ApiInterface {

    @POST("/login")
    Observable<Pojo> getData(@Query("login") String login, @Query("password") String password);

    @POST("/send")
    Observable<Response> postMessage(@Query("sender") String sender,
                                     @Query("message") String message);
}
