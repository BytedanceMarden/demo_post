package com.bytedance.demo_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMethod6();
    }


    //登陆，提交包含用户名和密码的登陆表单（只有登陆成功，才可以执行后续的查询）
    public void myMethod1(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .build();
        PostInterface postInterface=retrofit.create(PostInterface.class);
        Call<ResponseBody> call=postInterface.post1("marden","123123");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("marden",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }



    //获取json，使用@Field提交表单字段
    public void myMethod2(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .build();
        PostInterface postInterface=retrofit.create(PostInterface.class);
        Call<ResponseBody> call=postInterface.post2("android");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("marden",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }



    //获取json，使用@Field提交表单字段，使用@Path动态修改url
    public void myMethod3(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .build();
        PostInterface postInterface=retrofit.create(PostInterface.class);
        Call<ResponseBody> call=postInterface.post3("android",0);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("marden",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }



    //获取JavaBean对象，使用@Field提交表单字段，使用@Path动态修改url
    public void myMethod4(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostInterface postInterface=retrofit.create(PostInterface.class);
        Call<MyResponse> call=postInterface.post4("android",0);
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                MyResponse result=response.body();
                Log.d("marden",result.toString());
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });
    }



    //获取JavaBean对象，使用@url取代@POST后面的url，使用@Field提交表单字段
    public void myMethod5(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostInterface postInterface=retrofit.create(PostInterface.class);
        Call<MyResponse> call=postInterface.post5("article/query/0/json","android");
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                MyResponse result=response.body();
                Log.d("marden",result.toString());
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });
    }



    //错误--------------------@path与@url不可一起使用
    public void myMethod6(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostInterface postInterface=retrofit.create(PostInterface.class);
        Call<MyResponse> call=postInterface.post6("article/query/{page}/json","android",0);
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                MyResponse result=response.body();
                Log.d("marden",result.toString());
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });
    }







}