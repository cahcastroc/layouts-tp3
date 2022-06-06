package me.camila.tp3_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntExtra("Result",0)


        val tvResult = this.findViewById<TextView>(R.id.tvResult)

        tvResult.text = "Seu resultado: $result"


    }
}