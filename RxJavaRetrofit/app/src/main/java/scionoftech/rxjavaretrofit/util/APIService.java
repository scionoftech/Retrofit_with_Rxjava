package scionoftech.rxjavaretrofit.util;

import org.json.JSONObject;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface APIService {

    @Headers("Content-Type: application/json; charset=utf-8")
    @POST
    Observable<JSONObject> POST(@Url String url, @Body JSONObject jsonObject);

   /* @GET
    Observable<String> GET(@Url String url,@Path("id") String id);*/

    @GET
    Observable<JSONObject> GET(@Url String url);
}