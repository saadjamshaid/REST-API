package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*


interface ApiService {


    @GET("users/1/posts")
    fun getAllUserPosts(): Call<List<User>>

    @PUT("posts/1")
    @FormUrlEncoded
    fun saveUserPut(@Field("id") id: Int?,
                     @Field("title") title: String?,
                     @Field("body") body: String?,
                     @Field("userId") userId: Long): Call<User>

    @POST("posts")
    @FormUrlEncoded
    fun saveUserPost(@Field("id") id: Int?,
                     @Field("title") title: String?,
                     @Field("body") body: String?,
                     @Field("userId") userId: Long): Call<User>

    @GET("users")
    fun getSpecifiedUser(): Call<UserData>

    @DELETE("posts/1")
    fun deletePost(@Field("id") id: Int?,
                   @Field("title") title: String?,
                   @Field("body") body: String?,
                   @Field("userId") userId: Long): Call<User>


}