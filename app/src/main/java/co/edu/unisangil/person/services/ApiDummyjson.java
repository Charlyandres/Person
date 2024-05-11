package co.edu.unisangil.person.services;

import co.edu.unisangil.person.model.ResponseApi;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDummyjson {
    @GET("products")
    Call<ResponseApi> getAllPerson();
}
