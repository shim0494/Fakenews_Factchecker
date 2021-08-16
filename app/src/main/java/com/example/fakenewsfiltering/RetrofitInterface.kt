package com.example.fakenewsfiltering

import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    @FormUrlEncoded
    @POST("/")
    fun requestKwdData(
        @Field("searchedText") searchedText:String
    ) : Call<KeywordSearch_ResultData>
}
