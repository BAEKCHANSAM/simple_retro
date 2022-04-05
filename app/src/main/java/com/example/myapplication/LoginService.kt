package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

  @FormUrlEncoded
  @POST("여기는 url 물어봐서 넣을 것!!!")
  fun requestLogin(
    //인풋을 정의 한 곳
    @Field("userid") userid: String,
    @Field("userpw") userpw: String,
  ): Call<Login>
}
