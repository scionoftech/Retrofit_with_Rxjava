package scionoftech.rxjavaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import scionoftech.rxjavaretrofit.util.APIService;
import scionoftech.rxjavaretrofit.util.ApiUtils;
import scionoftech.rxjavaretrofit.util.RetrofitRequest;

public class MainActivity extends AppCompatActivity {

    RetrofitRequest retrofitRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        retrofitRequest = new RetrofitRequest(this);
        retrofitRequest.GET("/hello_world", new RetrofitRequest.RESTAPI() {
            @Override
            public void onSuccess(JSONObject response) {

                try {
                    Toast.makeText(MainActivity.this, response.get("message").toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(String message) {

                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });


    }

    //stop all requests
    @Override
    protected void onDestroy() {
        retrofitRequest.Stop();
        super.onDestroy();
    }
}
