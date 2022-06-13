package com.reeta.allapiquestion.commonClassess

import com.reeta.allapiquestion.getRequest.ResponseDTO
import com.reeta.allapiquestion.getWithListAndQuery.ListResponseDTO
import com.reeta.allapiquestion.getWithListAndQuery.ListResponseDTOItem
import com.reeta.allapiquestion.postRequest.RegisterResponse
import com.reeta.allapiquestion.postRequest.RequestModel
import retrofit2.Call
import retrofit2.http.*

interface APiService {

    @GET("api/users/{userId}")
    fun getUser(@Path("userId")userID:Int):Call<ResponseDTO>

    // this is for query parameter if you api contain ? like things, we can write
    //multiple query also

    @GET("comments")
    fun getUserList(@Query("postId")postId:Int):Call<ListResponseDTO>

    //if we have query and path both then we can arrange get request like this
//    @GET("comments/{userId}")
//    fun getUserList(@Path("userId")userId:Int,@Query("postId")postId:Int,
    //    @Query("name")name:String):Call<List<ResponseDTO>>


    @POST("api/users")
    fun postData(@Body request:RequestModel):Call<RegisterResponse>
}