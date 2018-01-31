package com.teamnexters.lastwednesday.network;

import com.teamnexters.lastwednesday.model.Tag;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JY on 2018-01-31.
 */

public interface ServiceApi {

    @GET("users/{user}/repos")
    Observable<List<Tag>> getRepos (
            @Path("user") String user
    );
}
