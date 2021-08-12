package com.bytedance.demo_post;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface PostInterface {
    //登陆，提交包含用户名和密码的登陆表单（只有登陆成功，才可以执行后续的查询）
    @POST("user/login")
    @FormUrlEncoded
    Call<ResponseBody> post1(@Field("username") String username,@Field("password") String password);


    //获取json，使用@Field提交表单字段
    @POST("article/query/0/json")
    @FormUrlEncoded
    Call<ResponseBody> post2(@Field("k") String k);


    //获取json，使用@Field提交表单字段，使用@Path动态修改url
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Call<ResponseBody> post3(@Field("k") String k, @Path("page") int page);


    //获取JavaBean对象，使用@Field提交表单字段，使用@Path动态修改url
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Call<MyResponse> post4(@Field("k") String k, @Path("page") int page);


    //获取JavaBean对象，使用@url取代@POST后面的url，使用@Field提交表单字段
    @POST
    @FormUrlEncoded
    Call<MyResponse> post5(@Url String url,@Field("k") String k);


    //错误--------------------@path与@url不可一起使用
    @POST
    @FormUrlEncoded
    Call<MyResponse> post6(@Url String url,@Field("k") String k,@Path("page") int page);



}
