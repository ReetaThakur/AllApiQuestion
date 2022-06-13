package com.reeta.allapiquestion.getRequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.reeta.allapiquestion.R
import com.reeta.allapiquestion.commonClassess.APiService
import com.reeta.allapiquestion.commonClassess.Network
import kotlinx.android.synthetic.main.activity_simple_get.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimpleGetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_get)

        btnFetchData.setOnClickListener {
            var apiService=Network.getRetrofit().create(APiService::class.java)
            apiService.getUser(etUserId.text.toString().toInt())
                .enqueue(object :Callback<ResponseDTO>{
                    override fun onResponse(
                        call: Call<ResponseDTO>,
                        response: Response<ResponseDTO>
                    ) {
                        val responseDTO=response.body()
                       Glide.with(avatarImage).load(responseDTO?.data?.avatar).into(avatarImage)
                        tvName.text=responseDTO?.data?.first_name
                    }

                    override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                       Toast.makeText(this@SimpleGetActivity,t.message,Toast.LENGTH_LONG).show()
                    }

                })
        }
    }
}