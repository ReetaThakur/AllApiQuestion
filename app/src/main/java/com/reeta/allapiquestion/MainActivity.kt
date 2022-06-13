package com.reeta.allapiquestion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reeta.allapiquestion.getRequest.SimpleGetActivity
import com.reeta.allapiquestion.getWithListAndQuery.GetWithListAndQueryActivity
import com.reeta.allapiquestion.postRequest.PostRequestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetRequest.setOnClickListener {
            val intent=Intent(this,SimpleGetActivity::class.java)
            startActivity(intent)
        }
        btnGetWithList.setOnClickListener {
            val intent=Intent(this,GetWithListAndQueryActivity::class.java)
            startActivity(intent)
        }
        btnPostRequest.setOnClickListener {
            val intent=Intent(this,PostRequestActivity::class.java)
            startActivity(intent)
        }
    }
}