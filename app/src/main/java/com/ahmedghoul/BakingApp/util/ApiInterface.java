package com.ahmedghoul.BakingApp.util;

import com.ahmedghoul.BakingApp.model.Result;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;



public interface ApiInterface {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Observable<List<Result>> getDetails();

}
