package com.reeta.allapiquestion.getWithListAndQuery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.reeta.allapiquestion.R
import com.reeta.allapiquestion.commonClassess.APiService
import com.reeta.allapiquestion.commonClassess.Network
import com.reeta.allapiquestion.getRequest.ResponseDTO
import kotlinx.android.synthetic.main.activity_get_with_list_and_query.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetWithListAndQueryActivity : AppCompatActivity() {

    lateinit var responseDto:ListResponseDTO
    lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_with_list_and_query)

        btnClick.setOnClickListener {
            val apiService=Network.getRetrofit1().create(APiService::class.java)
            apiService.getUserList(etUserPost.text.toString().toInt())
                .enqueue(object :Callback<ListResponseDTO>{
                    override fun onResponse(
                        call: Call<ListResponseDTO>,
                        response: Response<ListResponseDTO>
                    ) {
                        responseDto= response.body()!!
                        setRecyclerView()
                    }

                    override fun onFailure(call: Call<ListResponseDTO>, t: Throwable) {
                        Toast.makeText(this@GetWithListAndQueryActivity,t.message,Toast.LENGTH_LONG).show()

                    }

                })
        }
    }

    private fun setRecyclerView() {
        itemAdapter=ItemAdapter(responseDto)
        val linearLayoutManager=LinearLayoutManager(this)
        recyclerView.apply {
            adapter=itemAdapter
            layoutManager=linearLayoutManager
            itemAnimator=DefaultItemAnimator()
        }
    }
}