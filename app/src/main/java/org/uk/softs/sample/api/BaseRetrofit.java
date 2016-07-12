package org.uk.softs.sample.api;

import android.content.Context;

import java.io.IOException;

import org.uk.softs.sample.R;
import org.uk.softs.sample.SampleAndroidApplication;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRetrofit {
    private Context mContext;

    private Interceptor mInterceptor = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            String token = SampleAndroidApplication.getInstance().getLoginManager().getAuthToken();
            if (token != null) {
                Request newRequest = chain.request().newBuilder().addHeader("access-token", token).build();
                return chain.proceed(newRequest);
            } else {
                return chain.proceed(chain.request()); //No modifications on request
            }
        }
    };


    public BaseRetrofit(Context context) {
        this.mContext = context;
    }

    protected String getServerUrl() {
        return mContext.getString(R.string.base_url);
    }

    public Retrofit getRetrofit() {

        // Add the mInterceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(mInterceptor);
        OkHttpClient client = builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getServerUrl())
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson()))
                .client(client)
                .build();

        return retrofit;
    }

}
