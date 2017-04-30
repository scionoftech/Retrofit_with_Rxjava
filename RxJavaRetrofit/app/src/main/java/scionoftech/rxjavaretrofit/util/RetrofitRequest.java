package scionoftech.rxjavaretrofit.util;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class RetrofitRequest {

    public static abstract class RESTAPI {
        public abstract void onSuccess(JSONObject response);

        public abstract void onFailure(String message);

       /* public abstract void onTimeout(String message);*/
    }

    private APIService mAPIService;
    private CompositeDisposable compositeDisposable;

    public RetrofitRequest(Context context) {
        compositeDisposable = new CompositeDisposable();
        ApiUtils apiUtils = new ApiUtils();
        mAPIService = apiUtils.getAPIService(context);
    }

    public void POST(final String end_url, JSONArray data, final RESTAPI handler) {
        Log.d("Type", "POST");

        JSONObject params = new JSONObject();
        try {
            params.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        compositeDisposable.add(mAPIService.POST(end_url, params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<JSONObject>() {
                    @Override
                    public void onNext(JSONObject value) {

                        handler.onSuccess(value);
                        Log.d(end_url + " response", value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //FirebaseCrash.report(e);
                        e.printStackTrace();
                        if(!isDisposed()) {
                            handler.onFailure(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    public void POST(final String end_url, JSONObject data, final RESTAPI handler) {
        Log.d("Type", "POST");

        JSONObject params = new JSONObject();
        try {
            params.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        compositeDisposable.add(mAPIService.POST(end_url, params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<JSONObject>() {
                    @Override
                    public void onNext(JSONObject value) {

                        handler.onSuccess(value);
                        Log.d(end_url + " response", value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //FirebaseCrash.report(e);
                        e.printStackTrace();
                        if(!isDisposed()) {
                            handler.onFailure(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    public void POST(final String end_url, String data, final RESTAPI handler) {
        Log.d("Type", "POST");


        JSONObject params = new JSONObject();
        try {
            params.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        compositeDisposable.add(mAPIService.POST(end_url, params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<JSONObject>() {
                    @Override
                    public void onNext(JSONObject value) {

                        handler.onSuccess(value);
                        Log.d(end_url + " response", value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //FirebaseCrash.report(e);
                        e.printStackTrace();
                        if(!isDisposed()) {
                            handler.onFailure(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    public void GET(String end_url, String data, final RESTAPI handler) {
        Log.d("Type", "GET");
        final String url;
        if (data != null) {
            url = end_url + data;
        } else {
            url = end_url;
        }

        compositeDisposable.add(mAPIService.GET(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<JSONObject>() {
                    @Override
                    public void onNext(JSONObject value) {
                        Log.d(url + " response", value.toString());
                        handler.onSuccess(value);


                    }

                    @Override
                    public void onError(Throwable e) {
                       // FirebaseCrash.report(e);
                        e.printStackTrace();
                        if(!isDisposed()) {
                            handler.onFailure(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    public void GET(final String end_url, final RESTAPI handler) {
        Log.d("Type", "GET");

        compositeDisposable.add(mAPIService.GET(end_url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<JSONObject>() {
                    @Override
                    public void onNext(JSONObject value) {
                        handler.onSuccess(value);
                        Log.d(end_url + " response", value.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                       // FirebaseCrash.report(e);
                        e.printStackTrace();
                        if(!isDisposed()) {
                            handler.onFailure(e.toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    public void Stop() {
        compositeDisposable.clear(); // do not send event after fragment has been destroyed
    }
}
