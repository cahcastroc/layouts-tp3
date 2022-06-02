package me.camila.tp3_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        val name = intent.getStringExtra("Name")

        val tvName = this.findViewById<TextView>(R.id.tvName)

        tvName.text = "Seja bem-vindo $name"

    }
}