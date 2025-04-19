package com.first.demo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("todos/1")
    Call<Todo> getTodo();
}
