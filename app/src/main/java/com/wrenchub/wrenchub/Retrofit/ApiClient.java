package com.wrenchub.wrenchub.Retrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String Base_URL = " http://togglebits.in/pet-health/";
    public static Retrofit retrofit = null;
    
    public static Retrofit getClient() {
        
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    // .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        
        return retrofit;
    }
    
    
    /*public static void callApi(final PetHealthActivity context, Call<Result> call, final PetHealthFragment fragment, final int apiCallPostion) {
        final ProgressDialog mProgress = Utility.showProgressDialog(context);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                mProgress.dismiss();
                if (response.isSuccessful()) {
                    RetrofitCallback fragmentcallback = fragment;
                    RetrofitCallback activityCallBack = context;
                    Result result = response.body();
                    if (result.getSuccess()) {
                        if (fragment != null) {
                            fragmentcallback.successResult(result, apiCallPostion);
                        } else {
                            activityCallBack.successResult(result, apiCallPostion);
                        }
                        
                    } else {
                        if (fragment != null) {
                            fragmentcallback.failedResult(result, apiCallPostion);
                        } else {
                            activityCallBack.failedResult(result, apiCallPostion);
                        }
                    }
                } else
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                mProgress.dismiss();
                if (!Utility.checkconnection(context))
                    Utility.showconnectiondialog(context, fragment);
                else
                    Toast.makeText(context, "Server doesn't working.", Toast.LENGTH_SHORT).show();
    
               // Log.d("sam",t.getMessage());
                
            }
        });
    }*/
    
    
   /* public static void callApiDirectly(final Context context, Call<Result> call, final PetHealthFragment fragment, final int apiCallPostion, final RetrofitCallback callback) {
        final ProgressDialog mProgress = Utility.showProgressDialog(context);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                mProgress.dismiss();
                if (response.isSuccessful()) {
                    Result result = response.body();
                    if (result.getSuccess()) {
                        callback.successResult(result, apiCallPostion);
                    } else {
                        callback.failedResult(result, apiCallPostion);
                    }
                } else
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                mProgress.dismiss();
                if (!Utility.checkconnection(context))
                    Utility.showconnectiondialog(context, fragment);
                else
                    Toast.makeText(context, "Server doesn't working.", Toast.LENGTH_SHORT).show();
            }
        });
    }*/
    
    
}
