package com.example.fakenewsfiltering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var kwdResultAdapter: Keyword_RCView_Adapter
    val datas = mutableListOf<KeywordSearch_ResultData>()

    lateinit var searchedText: EditText

    var getResult: KeywordSearch_ResultData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://52.78.96.19:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var retrofitService: RetrofitInterface = retrofit.create(RetrofitInterface::class.java)

        searchedText = findViewById<EditText>(R.id.searchedText)


        val kwdSearchBtn: Button = findViewById<Button>(R.id.btn_KwdSearch)
        kwdSearchBtn.setOnClickListener {
            var inputText = searchedText.text.toString()

            retrofitService.requestKwdData(inputText).enqueue(object : Callback<KeywordSearch_ResultData> {
                    override fun onResponse(
                        call: Call<KeywordSearch_ResultData>,
                        response: Response<KeywordSearch_ResultData>
                    ) {
                            getResult = response.body()
                            Log.d("Success", "데이터를 받아오는 데에 성공했습니다.")
                        }

                    override fun onFailure(call: Call<KeywordSearch_ResultData>, t: Throwable) {
                        Log.e("Failed", "데이터를 받아오는 데에 실패했습니다.")
                    }
                })
        }

        initRecycler()
    }

    private fun initRecycler() {
        kwdResultAdapter = Keyword_RCView_Adapter(this)
        keyword_RCView.adapter = kwdResultAdapter

        datas.apply {
            kwdResultAdapter.datas = datas
            kwdResultAdapter.notifyDataSetChanged()
        }

    }

}