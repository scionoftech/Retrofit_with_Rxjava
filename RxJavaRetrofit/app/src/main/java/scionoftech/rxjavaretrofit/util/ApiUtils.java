package scionoftech.rxjavaretrofit.util;


import android.content.Context;

public class ApiUtils {

    public ApiUtils() {
    }

    RetrofitClient retrofitClient;

    public APIService getAPIService(Context context) {

        retrofitClient = new RetrofitClient();

        return retrofitClient.getClient(context).create(APIService.class);
    }
}
