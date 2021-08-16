package com.example.fakenewsfiltering

data class KeywordSearch_ResultData (
    val response : String,
    var naver_title : String,
    var naver_link : String,
    var naver_score : String,
    var snu_title : String,
    var snu_score : String,
    var top10_keyword : String
)