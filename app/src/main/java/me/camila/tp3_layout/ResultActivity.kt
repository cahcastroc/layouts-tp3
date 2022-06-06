package me.camila.tp3_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("Name")
        val tvNameIntent = this.findViewById<TextView>(R.id.tvNameIntent)
        tvNameIntent.text = "$name"

        val email = intent.getStringExtra("Email")
        val tvEmailIntent = this.findViewById<TextView>(R.id.tvEmailIntent)
        tvEmailIntent.text ="$email"


        val result = intent.getIntExtra("Result",0)
        val tvResult = this.findViewById<TextView>(R.id.tvResult)
        tvResult.text = "$result"

        val btShare = this.findViewById<Button>(R.id.btShare)
        btShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain") //Indica texto simples
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                "Yeaaah! Minha pontuação no Numind Game foi ${tvResult.text.toString()} pontos." )
            val chooser = Intent.createChooser(shareIntent, "Selecione")
            this.startActivity(chooser)
        }




    }
}