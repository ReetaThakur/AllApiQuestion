package com.reeta.allapiquestion.postRequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.reeta.allapiquestion.R
import com.reeta.allapiquestion.commonClassess.APiService
import com.reeta.allapiquestion.commonClassess.Network
import kotlinx.android.synthetic.main.activity_post_request.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_request)
        btnRequestApi.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiService=Network.getRetrofit2().create(APiService::class.java)
        val requestModel=RequestModel(27,"Android Devloper","Reeta Thakur")
         apiService.postData(requestModel).enqueue(object :Callback<RegisterResponse>{
             override fun onResponse(
                 call: Call<RegisterResponse>,
                 response: Response<RegisterResponse>
             ) {
                 if (response.code()==201 && response.body()!=null){
                   tvRequestName.text= response.body()!!.name
                     tvRequestAge.text= response.body()!!.age.toString()
                     tvRequestCreateAt.text=response.body()!!.createdAt
                     tvRequestJob.text=response.body()!!.job
                     tvRequestId.text=response.body()!!.id
                 }
             }

             override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                 Toast.makeText(this@PostRequestActivity,t.message, Toast.LENGTH_LONG).show()

             }

         })
    }
}