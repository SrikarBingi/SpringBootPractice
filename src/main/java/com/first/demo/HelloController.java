package com.first.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import retrofit2.Call;
// import retrofit2.Callback;
import retrofit2.Response;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Todo sayHello() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<Todo> call = apiService.getTodo();

        try {
            Response<Todo> response = call.execute(); // synchronous call
            if (response.isSuccessful() && response.body() != null) {
                return response.body(); // this will be converted to JSON automatically
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
