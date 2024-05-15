package com.codewithsrv.vj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetroFitApi {
    @GET
    Call<MsgModal> getMessage(@Url String url);
}
