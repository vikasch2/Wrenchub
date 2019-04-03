package com.wrenchub.wrenchub.Retrofit;

import android.content.Context;
import android.text.TextUtils;

import com.wrenchub.wrenchub.R;

import java.util.concurrent.TimeUnit;


import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by anonymous on 25-10-2017.
 */

public class ServiceGenerator {

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass);
    }

  /*  public static <S> S createService(Class<S> serviceClass, Context context, boolean val) {
     //   String authToken = Credentials.basic(context.getResources().getString(R.string.username), context.getResources().getString(R.string.pass));
        if (val)
            return createService(serviceClass, authToken, context);
        else
            return practise(serviceClass, authToken, context);
    }*/

    public static <S> S createService(Class<S> serviceClass, final String authToken, Context context) {

        String url ="http://dts.bridalmehndiqueen.com/driver/";

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS).build();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(url)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        if (!TextUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }

        return retrofit.create(serviceClass);
    }

    public static <S> S practise(Class<S> serviceClass, final String authToken, Context context) {

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(context.getResources().getString(R.string.url))
                        .addConverterFactory(ScalarsConverterFactory.create());

        Retrofit retrofit = builder.build();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        if (!TextUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }

        return retrofit.create(serviceClass);
    }

}
